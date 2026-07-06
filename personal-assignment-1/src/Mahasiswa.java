class Mahasiswa {
    // Atribut
    private String nama;
    private String nim;
    private String jurusan;
    private double ipk;

    // Constructor untuk inisialisasi data
    public Mahasiswa(String nama, String nim, String jurusan, double ipk) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
        this.ipk = ipk;
    }
    
    // Method untuk menampilkan informasi mahasiswa
    public void tampilkanInfo() {
        System.out.println("=== Data Mahasiswa ===");
        System.out.println("Nama     : " + nama);
        System.out.println("NIM      : " + nim);
        System.out.println("Jurusan  : " + jurusan);
        System.out.printf( "IPK      : %.2f%n", ipk);
    }

    public void tampilkanInfoPredikat(){
        System.out.println("=== Data Mahasiswa ===");
        System.out.println("Nama     : " + nama);
        System.out.println("NIM      : " + nim);
        System.out.println("Jurusan  : " + jurusan);
        System.out.printf( "IPK      : %.2f%n", ipk);
        System.out.println("Status   : " + cekKelulusan());
        System.out.println("Predikat : " + hitungPredikat());
    }

    // Getter dan Setter
    public String getNama() {
        return nama;
    }
    public String getNim() {
        return nim;
    }
    public String getJurusan() {
        return jurusan;
    }
    public double getIpk() {
        return ipk;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public void setNim(String nim) {
        this.nim = nim;
    }
    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }
    
    /**
     * Mengubah IPK mahasiswa.
     * Validasi memastikan nilai berada dalam rentang 0.00–4.00.
     */
    public void setIpk(double ipk) {
        if (ipk >= 0.00 && ipk <= 4.00) {
            this.ipk = ipk;
        } else {
            System.out.println("IPK tidak valid. Harus berada di antara 0.00 dan 4.00.");
        }
    }

    /**
     * Memeriksa status kelulusan mahasiswa berdasarkan IPK.
     * IPK >= 3.00 → "Lulus", IPK < 3.00 → "Belum Lulus".
     *
     * @return String status kelulusan
     */
    public String cekKelulusan() {
        if (ipk >= 3.00) {
            return "Lulus";
        } else {
            return "Belum Lulus";
        }
    }

    /**
     * Memperbarui IPK mahasiswa dengan nilai baru.
     * Menggunakan setIpk() agar validasi rentang tetap berjalan.
     * @return true jika pembaruan berhasil, false jika nilai IPK baru tidak valid.
     */
    public boolean updateIpk(double ipkBaru) {
        if (ipkBaru >= 0.00 && ipkBaru <= 4.00) {
            this.ipk = ipkBaru; // langsung set, validasi sudah dilakukan di atas
            return true;
        }
        return false;
    }

    /**
     * Menentukan predikat akademik mahasiswa berdasarkan rentang IPK.
     *
     * IPK >= 3.75          : Dengan Pujian
     * 3.50 <= IPK < 3.75   : Sangat Memuaskan
     * 3.00 <= IPK < 3.50   : Memuaskan
     * IPK < 3.00           : Perlu Perbaikan
     *
     * @return String predikat akademik
     */
    public String hitungPredikat() {
        if (ipk >= 3.75) {
            return "Dengan Pujian";
        } else if (ipk >= 3.50) {
            return "Sangat Memuaskan";
        } else if (ipk >= 3.00) {
            return "Memuaskan";
        } else {
            return "Perlu Perbaikan";
        }
    }
}