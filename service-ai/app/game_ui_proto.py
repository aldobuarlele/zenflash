import customtkinter as ctk
import requests
import time
import sys

ctk.set_appearance_mode("dark")
ctk.set_default_color_theme("blue")

class ZenFlashGameUI(ctk.CTk):
    def __init__(self):
        
        print("[DEBUG] Menyiapkan komponen UI...")
        self.setup_ui()
        
        self.lift()
        self.attributes('-topmost', True)
        self.after(500, lambda: self.attributes('-topmost', False))
        
        print("[DEBUG] Menjadwalkan pemuatan sesi dalam 1 detik...")
        self.after(1000, self.load_session)

    def setup_ui(self):
        self.header_frame = ctk.CTkFrame(self)
        self.header_frame.pack(pady=20, padx=20, fill="x")
        
        self.label_score = ctk.CTkLabel(self.header_frame, text="XP: 0", font=("Arial", 16, "bold"))
        self.label_score.pack(side="left", padx=20)
        
        self.label_combo = ctk.CTkLabel(self.header_frame, text="Combo: 0", font=("Arial", 16, "bold"), text_color="yellow")
        self.label_combo.pack(side="right", padx=20)

        self.label_prompt = ctk.CTkLabel(self, text="Menghubungi Java...", font=("Arial", 28, "bold"))
        self.label_prompt.pack(pady=40)

        self.btn_frame = ctk.CTkFrame(self, fg_color="transparent")
        self.btn_frame.pack(pady=10)
        
        self.option_buttons = []
        for i in range(4):
            btn = ctk.CTkButton(self.btn_frame, text="-", width=250, height=50, 
                               command=lambda idx=i: self.check_answer(idx))
            btn.grid(row=i//2, column=i%2, padx=10, pady=10)
            self.option_buttons.append(btn)
        print("[DEBUG] Komponen UI siap.")

    def load_session(self):
        url = "http://localhost:8080/api/game/start?limit=10"
        print(f"[DEBUG] Menghubungi Backend: {url}")
        try:
            response = requests.get(url, timeout=5)
            print(f"[DEBUG] HTTP Response: {response.status_code}")
            
            if response.status_code == 200:
                self.current_questions = response.json()
                print(f"[DEBUG] Berhasil memuat {len(self.current_questions)} soal.")
                self.show_question()
            else:
                self.label_prompt.configure(text=f"Error Server: {response.status_code}", text_color="red")
        except requests.exceptions.ConnectionError:
            print("[ERROR] Java Backend (Port 8080) TIDAK AKTIF!")
            self.label_prompt.configure(text="Java Backend Offline!", text_color="red")
        except Exception as e:
            print(f"[ERROR] Terjadi kegagalan: {str(e)}")
            self.label_prompt.configure(text="Gagal Memuat Soal", text_color="red")

    def show_question(self):
        if self.current_index < len(self.current_questions):
            q = self.current_questions[self.current_index]
            print(f"[DEBUG] Menampilkan Soal {self.current_index + 1}: {q['prompt']}")
            self.label_prompt.configure(text=q['prompt'], text_color="white")
            
            for i, option in enumerate(q['options']):
                self.option_buttons[i].configure(text=option, state="normal", fg_color=["#3B8ED0", "#1F6AA5"])
            
            self.start_time = time.time()
        else:
            print("[DEBUG] Sesi Selesai.")
            self.label_prompt.configure(text="Sesi Selesai! 🎉", text_color="green")

    def check_answer(self, idx):
        q = self.current_questions[self.current_index]
        user_choice = q['options'][idx]
        is_correct = user_choice == q['correctAnswer']
        time_taken = time.time() - self.start_time

        print(f"[DEBUG] Jawaban User: {user_choice} | Benar: {is_correct} | Waktu: {time_taken:.2f}s")

        payload = {
            "cardId": q['cardId'],
            "correct": is_correct,
            "timeTaken": time_taken,
            "currentCombo": self.combo
        }
        
        try:
            print(f"[DEBUG] Submitting answer to /api/game/submit...")
            res = requests.post("http://localhost:8080/api/game/submit", json=payload, timeout=5).json()
            
            self.score = res['totalXp']
            self.combo = res['newCombo']
            
            if is_correct:
                self.option_buttons[idx].configure(fg_color="green")
            else:
                self.option_buttons[idx].configure(fg_color="red")
            
            self.update_stats()
            self.after(1000, self.next_question)
        except Exception as e:
            print(f"[ERROR] Gagal submit ke backend: {e}")

    def update_stats(self):
        self.label_score.configure(text=f"XP: {self.score}")
        self.label_combo.configure(text=f"Combo: {self.combo}")

    def next_question(self):
        self.current_index += 1
        self.show_question()

if __name__ == "__main__":
    try:
        app = ZenFlashGameUI()
        print("[DEBUG] Menjalankan Mainloop...")
        app.mainloop()
    except Exception as e:
        print(f"[CRITICAL] Aplikasi gagal dijalankan: {e}")