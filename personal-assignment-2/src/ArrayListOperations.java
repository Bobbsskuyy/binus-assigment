// Robby Fahsya - 2902765505
import java.util.ArrayList;
import java.util.Collections;

/**
 * Kelas ArrayListOperations
 * Berisi operasi dasar pada ArrayList: menambah elemen, menghapus elemen,
 * pencarian elemen, dan pengurutan.
 */
public class ArrayListOperations {

    private ArrayList<Integer> data;

    public ArrayListOperations(int[] initialData) {
        data = new ArrayList<>();
        for (int value : initialData) {
            data.add(value);
        }
    }

    public ArrayList<Integer> getData() {
        return new ArrayList<>(data);
    }

    // Traversal: menampilkan isi ArrayList.
    public void traversal() {
        System.out.println("ArrayList Traversal: " + data);
    }

    // Menambahkan elemen ke akhir ArrayList.
    public void add(int value) {
        data.add(value);
    }

    // Menambahkan elemen pada posisi (index) tertentu.
    public void addAt(int value, int index) {
        data.add(index, value);
    }

    // Menghapus elemen pertama yang bernilai sama dengan value. 
    public boolean remove(int value) {
        // Integer.valueOf() dipakai supaya remove() memakai objek (by value),
        // bukan remove(int index) yang menghapus berdasarkan posisi.
        return data.remove(Integer.valueOf(value));
    }

    // Pencarian nilai dalam ArrayList (memakai indexOf, setara linear search). 
    public int search(int value) {
        return data.indexOf(value);
    }

    // Mengurutkan elemen ArrayList menggunakan Collections.sort(). 
    public void sort() {
        Collections.sort(data);
    }
}
