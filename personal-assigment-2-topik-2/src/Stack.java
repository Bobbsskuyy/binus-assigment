// Class Stack - riwayat transaksi, LIFO (Last In First Out)
class Stack {
    private Node top;
 
    public Stack() {
        top = null;
    }
 
    // Push - simpan transaksi pelanggan yang baru selesai dilayani ke puncak stack
    public void push(Node pelanggan) {
        pelanggan.next = top; // node baru menunjuk ke puncak lama
        top = pelanggan;      // puncak baru adalah pelanggan ini
    }
 
    // Tampilkan riwayat transaksi dari yang TERBARU ke yang LAMA
    public void tampilkanRiwayat() {
        if (top == null) {
            System.out.println("Belum ada riwayat transaksi.");
            return;
        }
        System.out.println("Riwayat Transaksi (terbaru ke lama):");
        Node current = top;
        while (current != null) {
            System.out.println("No: " + current.nomorAntrian + " | Nama: " + current.namaPelanggan
                    + " | Total: " + current.totalBelanja);
            current = current.next;
        }
    }
}
