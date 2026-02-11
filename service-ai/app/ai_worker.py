import sys
import os
import grpc

sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))

from stubs import zenflash_pb2
from stubs import zenflash_pb2_grpc
from app.translator_service import TranslatorService

def run_ai_worker():
    translator = TranslatorService()
    
    with grpc.insecure_channel('localhost:9090') as channel:
        stub = zenflash_pb2_grpc.NlpServiceStub(channel)
        
        print("\n--- 🤖 ZenFlash AI Worker Started ---")
        
        try:
            print("[Worker] Mencari kartu dengan status 'Pending Translation'...")
            request = zenflash_pb2.GetPendingCardsRequest(limit=50)
            response = stub.GetPendingCards(request)
            
            if not response.cards:
                print("[Worker] Tidak ada kartu yang perlu diproses. Pekerjaan selesai! 😎")
                return

            print(f"[Worker] Menemukan {len(response.cards)} kartu. Memulai proses terjemahan...")

            for card in response.cards:
                print(f"\n[ID] {card.card_id}")
                print(f"[Jepang] {card.text_to_translate}")
                
                translation = translator.translate(card.text_to_translate)
                
                if translation:
                    update_request = zenflash_pb2.UpdateTranslationRequest(
                        card_id=card.card_id,
                        translated_text=translation
                    )
                    update_response = stub.UpdateTranslation(update_request)
                    
                    if update_response.success:
                        print(f"✅ Berhasil diterjemahkan: {translation}")
                    else:
                        print(f"❌ Gagal update DB: {update_response.message}")
                else:
                    print("❌ Gagal mendapatkan terjemahan dari AI.")

            print("\n--- 🤖 Worker Selesai Memproses Batch ---")

        except grpc.RpcError as e:
            print(f"🔴 Error gRPC: {e.code()}")
        except Exception as e:
            print(f"🔴 Error Sistem: {e}")

if __name__ == '__main__':
    run_ai_worker()