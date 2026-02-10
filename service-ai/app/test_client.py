import sys
import os

sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))

import grpc
from stubs import zenflash_pb2
from stubs import zenflash_pb2_grpc

def run():
    with grpc.insecure_channel('localhost:9090') as channel:
        stub = zenflash_pb2_grpc.NlpServiceStub(channel)
        
        request = zenflash_pb2.AnalyzeRequest(text="Python menyapa Java!")
        
        print("--- Mengirim request ke Java Backend ---")
        try:
            response = stub.AnalyzeSentence(request)
            print(f"Respon diterima: {response.sentiment}")
            for token in response.tokens:
                print(f"Token: {token.surface} | POS: {token.part_of_speech}")
        except grpc.RpcError as e:
            print(f"Gagal terhubung ke server: {e.code()}")

if __name__ == '__main__':
    run()