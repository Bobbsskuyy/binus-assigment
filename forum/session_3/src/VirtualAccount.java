package forum.session_3.src;

class VirtualAccount extends MetodePembayaran {
    private String nomorVA;

    public VirtualAccount(String namaMetode, double saldo, String nomorVA) {
        super(namaMetode, saldo);
        this.nomorVA = nomorVA;
    }

    // Polymorphism: Mengubah perilaku prosesBayar khusus Virtual Account (bebas biaya admin)
    @Override
    public void prosesBayar(double jumlah) {
        System.out.println("\n--- Memproses Virtual Account (" + nomorVA + ") ---");
        System.out.println("Mengecek validasi nomor VA...");
        super.prosesBayar(jumlah);
    }
}