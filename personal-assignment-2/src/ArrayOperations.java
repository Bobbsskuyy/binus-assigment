// Robby Fahsya - 2902765505
import java.util.Arrays;

/**
 * Kelas ArrayOperations
 * Berisi operasi: traversal, pencarian (linear & binary), penyisipan, dan penghapusan.
 */
public class ArrayOperations {

    private int[] data;
    private int size;

    public ArrayOperations(int[] initialData) {
        this.data = Arrays.copyOf(initialData, initialData.length);
        this.size = initialData.length;
    }

    public int[] getData() {
        return Arrays.copyOf(data, size);
    }

    public int getSize() {
        return size;
    }

    // Traversal: menampilkan isi array. 
    public void traversal() {
        System.out.println("Array Traversal: " + Arrays.toString(getData()));
    }

    // Linear search: mengembalikan indeks elemen, atau -1 jika tidak ditemukan.
    public int linearSearch(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Binary search: array HARUS sudah terurut agar hasil valid.
     * Mengembalikan indeks elemen pada array asli, atau -1 jika tidak ditemukan.
     */
    public int binarySearch(int value) {
        int[] sorted = Arrays.copyOf(data, size);
        Arrays.sort(sorted);

        int low = 0, high = size - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sorted[mid] == value) {
                // cari indeks value tersebut pada array data asli (tidak diurutkan)
                return linearSearch(value);
            } else if (sorted[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // Penyisipan nilai di akhir array menggunakan System.arraycopy().
    public void insert(int value) {
        int[] newData = new int[size + 1];
        System.arraycopy(data, 0, newData, 0, size);
        newData[size] = value;
        data = newData;
        size++;
    }

    // Penyisipan nilai pada posisi (index) tertentu. 
    public void insertAt(int value, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index tidak valid: " + index);
        }
        int[] newData = new int[size + 1];
        System.arraycopy(data, 0, newData, 0, index);
        newData[index] = value;
        System.arraycopy(data, index, newData, index + 1, size - index);
        data = newData;
        size++;
    }

    // Penghapusan elemen pertama yang bernilai sama dengan value.
    public boolean delete(int value) {
        int index = linearSearch(value);
        if (index == -1) {
            return false;
        }
        int[] newData = new int[size - 1];
        System.arraycopy(data, 0, newData, 0, index);
        System.arraycopy(data, index + 1, newData, index, size - index - 1);
        data = newData;
        size--;
        return true;
    }
}
