import java.util.Scanner;

public class Perpustakaan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList daftarBuku = new LinkedList();
        int pilihan;
 
        do {
            System.out.println("\n===== SISTEM DATA BUKU =====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Lihat Semua Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = Integer.parseInt(sc.nextLine().trim());
 
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Kode Buku: ");
                    String kode = sc.nextLine();
                    System.out.print("Masukkan Judul: ");
                    String judul = sc.nextLine();
                    System.out.print("Masukkan Penulis: ");
                    String penulis = sc.nextLine();
                    daftarBuku.tambahBuku(kode, judul, penulis);
                    break;
                case 2:
                    daftarBuku.hapusBuku();
                    break;
                case 3:
                    System.out.print("Masukkan Kode Buku: ");
                    String cari = sc.nextLine();
                    daftarBuku.cariBuku(cari);
                    break;
                case 4:
                    daftarBuku.tampilkanSemua();
                    break;
                case 5:
                    System.out.println("Program selesai. Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 5);
 
        sc.close();
    }
}
