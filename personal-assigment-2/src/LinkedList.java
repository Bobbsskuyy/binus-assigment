import java.util.Scanner;

// Class LinkedList - mengelola kumpulan Node buku
class LinkedList {
    private Node head;
    private int jumlahData;
 
    public LinkedList() {
        head = null;
        jumlahData = 0;
    }
 
    // Tambah Buku (Push) - data baru selalu dimasukkan di AKHIR daftar
    public void tambahBuku(String kodeBuku, String judul, String penulis) {
        // Validasi: kodeBuku maksimal 5 karakter
        if (kodeBuku.length() > 5) {
            System.out.println("Gagal! Kode buku maksimal 5 karakter.");
            return;
        }
        Node baru = new Node(kodeBuku, judul, penulis);
        if (head == null) {
            head = baru; // jika list masih kosong, jadikan node pertama
        } else {
            Node current = head;
            while (current.next != null) { // cari node terakhir
                current = current.next;
            }
            current.next = baru; // sambungkan ke akhir
        }
        jumlahData++;
        System.out.println("Data berhasil ditambahkan!");
    }
 
    // Hapus Buku (Pop) - menghapus data buku TERAKHIR dari daftar
    public void hapusBuku() {
        if (head == null) {
            System.out.println("Tidak ada data untuk dihapus.");
            return;
        }
        if (head.next == null) {
            // hanya ada 1 data
            System.out.println("Buku '" + head.judul + "' berhasil dihapus.");
            head = null;
        } else {
            Node current = head;
            // berhenti di node kedua dari belakang
            while (current.next.next != null) {
                current = current.next;
            }
            System.out.println("Buku '" + current.next.judul + "' berhasil dihapus.");
            current.next = null; // putuskan node terakhir
        }
        jumlahData--;
    }
 
    // Cari Buku berdasarkan kodeBuku
    public void cariBuku(String kodeBuku) {
        Node current = head;
        while (current != null) {
            if (current.kodeBuku.equalsIgnoreCase(kodeBuku)) {
                System.out.println("Buku ditemukan!");
                System.out.println("Kode: " + current.kodeBuku + " | Judul: " + current.judul
                        + " | Penulis: " + current.penulis);
                return;
            }
            current = current.next;
        }
        System.out.println("Buku tidak ditemukan.");
    }
 
    // Tampilkan semua data buku sesuai urutan input
    public void tampilkanSemua() {
        if (head == null) {
            System.out.println("Belum ada data buku.");
            return;
        }
        System.out.println("Daftar Buku:");
        Node current = head;
        while (current != null) {
            System.out.println("Kode: " + current.kodeBuku + " | Judul: " + current.judul
                    + " | Penulis: " + current.penulis);
            current = current.next;
        }
        System.out.println("Total Buku: " + jumlahData);
    }
 
    public int getJumlahData() {
        return jumlahData;
    }
}
