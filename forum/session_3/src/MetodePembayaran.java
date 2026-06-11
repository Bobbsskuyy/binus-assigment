package forum.session_3.src;

// Encapsulation: Membuat class dengan variabel private dan method public untuk mengaksesnya
class MetodePembayaran {
    // Encapsulation: Variabel di-set private agar tidak bisa diubah sembarangan dari luar
    private String namaMetode;
    private double saldo;

    // Constructor
    public MetodePembayaran(String namaMetode, double saldo) {
        this.namaMetode = namaMetode;
        this.saldo = saldo;
    }

    // Encapsulation: Getter dan Setter untuk mengakses data private
    public String getNamaMetode() {
        return namaMetode;
    }

    public double getSaldo() {
        return saldo;
    }

    // Method yang akan di-override (Polymorphism)
    public void prosesBayar(double jumlah) {
        if (saldo >= jumlah) {
            saldo -= jumlah;
            System.out.println("Pembayaran menggunakan " + namaMetode + " berhasil sebesar Rp" + jumlah);
        } else {
            System.out.println("Saldo " + namaMetode + " tidak cukup.");
        }
    }
}