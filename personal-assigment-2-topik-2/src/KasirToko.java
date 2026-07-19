import java.util.Scanner;

public class KasirToko {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue antrian = new Queue();
        Stack riwayat = new Stack();
        int pilihan;
 
        do {
            System.out.println("\n=== SISTEM KASIR TOKO ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Layani Pelanggan");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Lihat Riwayat Transaksi");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = Integer.parseInt(sc.nextLine().trim());
 
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Nomor Antrian: ");
                    String nomor = sc.nextLine();
                    System.out.print("Masukkan Nama Pelanggan: ");
                    String nama = sc.nextLine();
                    System.out.print("Masukkan Total Belanja: ");
                    double total = Double.parseDouble(sc.nextLine().trim());
                    antrian.enqueue(nomor, nama, total);
                    break;
                case 2:
                    Node dilayani = antrian.dequeue();
                    if (dilayani != null) {
                        System.out.println("Melayani pelanggan " + dilayani.nomorAntrian
                                + " (" + dilayani.namaPelanggan + ")");
                        riwayat.push(dilayani);
                        System.out.println("Transaksi disimpan ke riwayat.");
                    }
                    break;
                case 3:
                    antrian.tampilkanAntrian();
                    break;
                case 4:
                    riwayat.tampilkanRiwayat();
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
