package forum.session_3.src;

public class Main {
    public static void main(String[] args) {
        
        // Membuat objek menggunakan konsep Polymorphism (Deklarasi menggunakan Class Induk)
        MetodePembayaran dompetDigital = new EWallet("OVO", 50000, "08123456789");
        MetodePembayaran vaBank = new VirtualAccount("BCA Virtual Account", 100000, "8001234567");

        // Eksekusi Polymorphism: Method yang dipanggil sama, tapi outputnya berbeda sesuai karakteristik class anak
        dompetDigital.prosesBayar(20000);
        vaBank.prosesBayar(50000);
        
        System.out.println("\n=================================");
        // Pembuktian Encapsulation: Saldo tidak bisa diakses langsung (misal: dompetDigital.saldo)
        // Harus lewat getter
        System.out.println("Sisa Saldo " + dompetDigital.getNamaMetode() + " sekarang: Rp" + dompetDigital.getSaldo());
    }
}