# 🎌 ZenFlash: Survival Daily Quest

**ZenFlash** adalah platform pembelajaran bahasa Jepang berbasis **Spaced Repetition System (SRS)** yang menggabungkan performa tinggi *backend* Java dengan fleksibilitas AI Python melalui **gRPC**. Proyek ini dirancang untuk mensimulasikan tantangan bertahan hidup (*survival*) di Jepang melalui konten yang dihasilkan secara dinamis oleh AI untuk membantu pengguna menguasai kosakata harian secara fungsional.

---

## 🚀 Fitur Utama

* **Hybrid Microservices Architecture**: Komunikasi antar-layanan menggunakan **gRPC** untuk latensi rendah dan *type-safety* menggunakan Protocol Buffers.
* **AI-Powered Content**: Python Worker secara otomatis menerjemahkan kartu dan men-generate kalimat contoh yang natural menggunakan LLM.
* **Gamified Learning Logic**: Sistem "Survival Quest" dengan perhitungan skor dinamis berbasis waktu dan *combo*.
* **Advanced SRS Algorithm**: Implementasi algoritma **SM-2** yang dimodifikasi untuk mengoptimalkan retensi memori jangka panjang.
* **Cross-Platform Interface**: Tersedia dalam versi GUI Python (CustomTkinter) dan sedang dalam pengembangan versi Web (React + Vite).


---

## 🛠️ Tech Stack

### **AI Service (The Specialist)**
* **Python 3.10**: Menjalankan *background worker* dan pemrosesan bahasa alami.
* **CustomTkinter**: Prototipe GUI untuk pengujian logika permainan secara lokal.
* **Miniconda**: Manajemen *environment* untuk isolasi dependensi AI.

### **Backend (The Core)**
* **Java 17 & Spring Boot 3**: Menangani logika bisnis, manajemen database, dan REST API.
* **PostgreSQL**: Penyimpanan data utama untuk kartu, statistik user, dan progres SRS.
* **gRPC**: Protokol komunikasi *server-to-server* dengan Python Service.
* **Lombok & JPA/Hibernate**: Untuk efisiensi pengembangan *boilerplate* code.


---

## 📐 Arsitektur & Logika

### **Alur Data**
Sistem beroperasi dengan aliran data sebagai berikut:
1.  **Frontend** meminta sesi permainan melalui REST API.
2.  **Spring Boot** mengelola antrean kartu yang jatuh tempo (*due*) berdasarkan algoritma SM-2.
3.  **Python Worker** memproses kartu baru secara *asynchronous* melalui gRPC untuk mengisi konteks terjemahan dan contoh kalimat.

### **Kalkulasi Skor & SRS**
Perhitungan skor per jawaban menggunakan rumus:
$$Score = \left( \frac{100 \times Combo}{TimeTaken} \right)$$

Penjadwalan ulang kartu mengikuti fungsi interval SM-2:
$$I(n) = \begin{cases} 1 & n=1 \\ 6 & n=2 \\ I(n-1) \cdot EF & n > 2 \end{cases}$$
Di mana **EF** adalah *Easiness Factor* yang diperbarui secara dinamis berdasarkan kualitas jawaban pengguna.

---

## 📦 Instalasi & Menjalankan

### **Prasyarat**
* Docker & Docker Compose
* Java 17+
* Miniconda / Python 3.10+
