package forum.session_3.src;

class EWallet extends MetodePembayaran {
    private String nomorHp;

    public EWallet(String namaMetode, double saldo, String nomorHp) {
        super(namaMetode, saldo); // Memanggil constructor induk
        this.nomorHp = nomorHp;
    }

    // Polymorphism: Mengubah perilaku prosesBayar khusus untuk E-Wallet (ada biaya admin)
    @Override
    public void prosesBayar(double jumlah) {
        double biayaAdmin = 1000;
        double totalTagihan = jumlah + biayaAdmin;
        
        System.out.println("\n--- Memproses E-Wallet (" + nomorHp + ") ---");
        if (getSaldo() >= totalTagihan) {
            // Karena saldo di class induk private, kita pakai logic custom atau simulasi di sini
            System.out.println("Biaya Admin: Rp" + biayaAdmin);
            super.prosesBayar(jumlah); // Memanggil method induk untuk potong saldo asli jika diizinkan, atau bisa di-handle mandiri
        } else {
            System.out.println("Gagal: Saldo tidak cukup untuk membayar tagihan + biaya admin.");
        }
    }
}