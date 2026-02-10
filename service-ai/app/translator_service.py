from deep_translator import GoogleTranslator

class TranslatorService:
    def __init__(self, source='ja', target='id'):
        self.translator = GoogleTranslator(source=source, target=target)

    def translate(self, text):
        try:
            if not text or text.strip() == "":
                return None
            
            print(f"[AI] Menerjemahkan: {text}")
            result = self.translator.translate(text)
            print(f"[AI] Hasil: {result}")
            return result
        except Exception as e:
            print(f"[Error AI] Gagal menerjemahkan: {e}")
            return None

# Untuk testing mandiri (Unit Test sederhana)
if __name__ == "__main__":
    service = TranslatorService()
    service.translate("日本語を勉強します")