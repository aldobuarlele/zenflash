from deep_translator import GoogleTranslator

class TranslatorService:
    def __init__(self, source='ja', target='id'):
        self.translator = GoogleTranslator(source=source, target=target)
        self.example_translator = GoogleTranslator(source='ja', target='id')

    def translate(self, text):
        try:
            if not text or text.strip() == "":
                return None
            
            print(f"[AI] Menerjemahkan: {text}")
            result = self.translator.translate(text)
            return result
        except Exception as e:
            print(f"[Error AI] Gagal menerjemahkan: {e}")
            return None

    def generate_example(self, word):
        """
        Menghasilkan kalimat contoh Jepang dan terjemahannya.
        Note: Di masa depan, bagian 'example_ja' bisa diganti dengan 
        panggilan API OpenAI/Gemini untuk hasil yang lebih natural.
        """
        try:
            example_ja = f"{word}は面白いです。"
            
            if "します" in word or "ます" in word:
                example_ja = f"毎日{word}。"
            print(f"[AI] Membuat contoh: {example_ja}")
            example_id = self.example_translator.translate(example_ja)
            
            return example_ja, example_id
        except Exception as e:
            print(f"[Error AI] Gagal generate contoh: {e}")
            return None, None

if __name__ == "__main__":
    service = TranslatorService()
    print(service.generate_example("日本語"))