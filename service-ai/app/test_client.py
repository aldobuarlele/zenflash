import sys
import os
import grpc

sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))

from stubs import zenflash_pb2
from stubs import zenflash_pb2_grpc
from app.translator_service import TranslatorService 

def run():
    translator = TranslatorService()
    
    with grpc.insecure_channel('localhost:9090') as channel:
        stub = zenflash_pb2_grpc.NlpServiceStub(channel)
        
        text_input = "私は日本語を勉強します"
        print(f"\n[1/3] Mengirim teks ke Java untuk dianalisis: {text_input}")
        
        try:
            analyze_request = zenflash_pb2.AnalyzeRequest(text=text_input)
            analyze_response = stub.AnalyzeSentence(analyze_request)
            
            card_id = analyze_response.sentiment.replace("SAVED_ID_", "")
            print(f"✅ Kartu tersimpan di DB dengan ID: {card_id}")

            print(f"\n[2/3] Memproses AI Translation...")
            translation = translator.translate(text_input)

            if translation and card_id:
                print(f"\n[3/3] Mengirim terjemahan kembali ke Backend...")
                update_request = zenflash_pb2.UpdateTranslationRequest(
                    card_id=card_id,
                    translated_text=translation
                )
                update_response = stub.UpdateTranslation(update_request)
                
                if update_response.success:
                    print(f"🎉 SUCCESS: {update_response.message}")
                else:
                    print(f"❌ FAILED: {update_response.message}")

        except grpc.RpcError as e:
            print(f"🔴 Error Komunikasi gRPC: {e.code()}")
        except Exception as e:
            print(f"🔴 Error Sistem: {e}")

if __name__ == '__main__':
    run()