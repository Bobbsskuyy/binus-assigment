// Class Queue - antrian pelanggan, FIFO (First In First Out)
class Queue {
    private Node front, rear;
    private int jumlahData;
 
    public Queue() {
        front = rear = null;
        jumlahData = 0;
    }
 
    // Enqueue - tambah pelanggan baru ke BELAKANG antrian
    public void enqueue(String nomor, String nama, double total) {
        // Validasi jumlah data maksimal 5 pelanggan dalam antrian
        if (jumlahData >= 5) {
            System.out.println("Antrian penuh! Maksimal 5 pelanggan.");
            return;
        }
        Node baru = new Node(nomor, nama, total);
        if (rear == null) {
            front = rear = baru;
        } else {
            rear.next = baru;
            rear = baru;
        }
        jumlahData++;
        System.out.println("Data pelanggan ditambahkan ke antrian!");
    }
 
    // Dequeue - keluarkan pelanggan paling DEPAN untuk dilayani
    public Node dequeue() {
        if (front == null) {
            System.out.println("Antrian kosong, tidak ada pelanggan untuk dilayani.");
            return null;
        }
        Node dilayani = front;
        front = front.next;
        if (front == null) {
            rear = null; // antrian jadi kosong
        }
        jumlahData--;
        return dilayani;
    }
 
    // Tampilkan antrian pelanggan saat ini
    public void tampilkanAntrian() {
        if (front == null) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("Antrian Saat Ini:");
        Node current = front;
        while (current != null) {
            System.out.println("No: " + current.nomorAntrian + " | Nama: " + current.namaPelanggan
                    + " | Total: " + current.totalBelanja);
            current = current.next;
        }
    }
}
