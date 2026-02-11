import sys
import os
import grpc

sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))

from stubs import zenflash_pb2
from stubs import zenflash_pb2_grpc

def start_review_session():
    with grpc.insecure_channel('localhost:9090') as channel:
        stub = zenflash_pb2_grpc.NlpServiceStub(channel)
        
        print("--- 📚 Sesi Belajar ZenFlash Dimulai ---")
        
        try:
            request = zenflash_pb2.GetDueCardsRequest(limit=10)
            response = stub.GetDueCards(request)
            
            if not response.cards:
                print("✅ Luar biasa! Tidak ada kartu yang perlu direview hari ini.")
                return

            print(f"Ditemukan {len(response.cards)} kartu yang perlu Anda pelajari.\n")
            
            for i, card in enumerate(response.cards, 1):
                print(f"{i}. [{card.card_id}] {card.front_text}")

        except grpc.RpcError as e:
            print(f"🔴 Gagal terhubung ke server: {e.code()}")

def start_review_session():
    with grpc.insecure_channel('localhost:9090') as channel:
        stub = zenflash_pb2_grpc.NlpServiceStub(channel)
        
        print("\n--- 📚 Sesi Belajar ZenFlash Dimulai ---")
        
        try:
            request = zenflash_pb2.GetDueCardsRequest(limit=10)
            response = stub.GetDueCards(request)
            
            if not response.cards:
                print("✅ Semua kartu sudah dipelajari!")
                return

            print(f"Ada {len(response.cards)} kartu menunggu.\n")
            
            for i, card in enumerate(response.cards, 1):
                print("-" * 30)
                print(f"KARTU #{i}")
                print(f"Jepang: {card.front_text}")
                
                input("\n[Tekan ENTER untuk melihat jawaban...]")
                
                print(f"Arti  : {card.back_text}")
                print("-" * 30)
                
                print("\n(Lanjut ke kartu berikutnya...)")

        except grpc.RpcError as e:
            print(f"🔴 Error: {e.code()}")

def start_review_session():
    with grpc.insecure_channel('localhost:9090') as channel:
        stub = zenflash_pb2_grpc.NlpServiceStub(channel)
        
        print("\n--- 📚 Sesi Belajar ZenFlash Dimulai ---")
        
        try:
            request = zenflash_pb2.GetDueCardsRequest(limit=10)
            response = stub.GetDueCards(request)
            
            if not response.cards:
                print("✅ Semua kartu sudah dipelajari!")
                return

            print(f"Ada {len(response.cards)} kartu menunggu.\n")
            
            for i, card in enumerate(response.cards, 1):
                print("-" * 40)
                print(f"KARTU #{i}")
                print(f"Jepang: {card.front_text}")
                
                input("\n[Tekan ENTER untuk melihat jawaban...]")
                
                print(f"Arti  : {card.back_text}")
                
                score = -1
                while score < 0 or score > 5:
                    try:
                        score_input = input("\nSeberapa hafal? (0-5)\n5: Sangat Hafal, 0: Lupa Sama Sekali\nSkor: ")
                        score = int(score_input)
                    except ValueError:
                        print("Masukkan angka 0 sampai 5 saja!")

                review_request = zenflash_pb2.ReviewRequest(
                    card_id=card.card_id,
                    quality_score=score
                )
                review_response = stub.SubmitReview(review_request)
                
                if review_response.next_review_date:
                    print(f"\n✅ Berhasil! Jadwal berikutnya: {review_response.next_review_date}")
                
                print("-" * 40)

            print("\n🎉 Sesi belajar selesai. Kerja bagus, Aldo!")

        except grpc.RpcError as e:
            print(f"🔴 Error: {e.code()}")

if __name__ == '__main__':
    start_review_session()