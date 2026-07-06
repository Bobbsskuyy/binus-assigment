import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    // Initiate array Mahasiswa dengan data awal
    private static Mahasiswa[] daftar = {
        new Mahasiswa("Andi Prasetyo",   "2440001", "Teknik Informatika", 3.85), // Dengan Pujian
        new Mahasiswa("Budi Santoso",    "2440002", "Sistem Informasi",   2.75), // Perlu Perbaikan
        new Mahasiswa("Citra Lestari",   "2440003", "Teknik Informatika", 3.55), // Sangat Memuaskan
        new Mahasiswa("Dimas Kurniawan", "2440004", "Manajemen",          3.20), // Memuaskan
        new Mahasiswa("Eka Fitriani",    "2440005", "Akuntansi",          3.90)  // Dengan Pujian
    };

    public static void main(String[] args) {
        boolean jalan = true;
 
        while (jalan) {
            tampilkanMenu();
 
            System.out.print("Pilih nomor (1-3) atau 0 untuk keluar: ");
            String input = scanner.nextLine().trim();
 
            // Menggunakan switch untuk routing ke method yang sesuai
            switch (input) {
                case "1":
                    System.out.println("\n=== Jawaban 1 ===");
                    answer1();
                    break;
                case "2":
                    System.out.println("\n=== Jawaban 2 ===");
                    answer2();
                    break;
                case "3":
                    System.out.println("\n=== Jawaban 3 ===");
                    answer3();
                    break;
                case "0":
                    System.out.println("\nProgram selesai. Sampai jumpa!");
                    jalan = false;
                    break;
                default:
                    // Input selain 0-3 dianggap tidak valid
                    System.out.println(" Pilihan tidak valid. Masukkan angka 0–3.\n");
            }
        }
 
        scanner.close();
    }

    private static void tampilkanMenu() {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║         MENU JAWABAN PRAKTIKUM       ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║  1. Jawaban 1 — Membuat Objek        ║");
        System.out.println("║  2. Jawaban 2 — Enkapsulasi & Update ║");
        System.out.println("║  3. Jawaban 3 — Predikat Akademik    ║");
        System.out.println("║  0. Keluar                           ║");
        System.out.println("╚══════════════════════════════════════╝");
    }

    private static void answer1() {
        // Menampilkan informasi mahasiswa
        for (int i = 0; i < daftar.length; i++) {
            System.out.printf("%nMahasiswa #%d:%n", i + 1);
            daftar[i].tampilkanInfo();
        }
    }

    private static void answer2() {
        System.out.println("\nData mahasiswa sebelum update:");
        for (int i = 0; i < daftar.length; i++) {
            System.out.printf("%nMahasiswa #%d:%n", i + 1);
            daftar[i].tampilkanInfo();
        }
 
        // Input NIM dan IPK baru dari pengguna
        boolean berhasil = false; // flag untuk mengulang jika input tidak valid
 
        while (!berhasil) {
            System.out.print("\nMasukkan NIM mahasiswa yang ingin diupdate: ");
            String nimCari = scanner.nextLine().trim();
 
            Mahasiswa target = null;
            for (Mahasiswa m : daftar) {
                if (m.getNim().equals(nimCari)) {
                    target = m;
                    break;
                }
            }
 
            if (target == null) {
                System.out.println(" NIM tidak ditemukan. Coba lagi.");
                continue;
            }
 
            // Input IPK baru dengan validasi format angka
            System.out.print("Masukkan IPK baru: ");
            double ipkBaru;
            try {
                ipkBaru = Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("  Format angka tidak valid. Coba lagi.");
                continue;
            }
 
            // Memanggil updateIpk() — return false jika di luar rentang 0.00–4.00
            boolean updated = target.updateIpk(ipkBaru);
            if (!updated) {
                System.out.println("  IPK tidak valid (harus antara 0.00 – 4.00). Coba lagi.");
                continue;
            }
 
            // Menampilkan konfirmasi dan info terbaru (termasuk status kelulusan)
            System.out.println("\nData berhasil diperbarui!");
            target.tampilkanInfo();
 
            berhasil = true;
        }
 
    }

     private static void answer3() {
        // Loop menampilkan info lengkap termasuk predikat dari hitungPredikat()
        for (int i = 0; i < daftar.length; i++) {
            System.out.printf("%nMahasiswa #%d:%n", i + 1);
            daftar[i].tampilkanInfoPredikat(); // tampilkanInfoPredikat() sudah memanggil hitungPredikat() di dalamnya
        }
    }
}
