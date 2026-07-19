// Robby Fahsya - 2902765505

/**
 * Kelas Comparison
 * Membandingkan kinerja Array (ArrayOperations) dan ArrayList (ArrayListOperations)
 * dengan mengukur waktu eksekusi operasi dasar menggunakan System.nanoTime().
 */
public class Comparison {

    // Hasil satu baris perbandingan, dipakai untuk mencetak tabel. 
    static class Result {
        String operation;
        double arrayTimeMs;
        double arrayListTimeMs;

        Result(String operation, double arrayTimeMs, double arrayListTimeMs) {
            this.operation = operation;
            this.arrayTimeMs = arrayTimeMs;
            this.arrayListTimeMs = arrayListTimeMs;
        }
    }

    public static double toMillis(long nanos) {
        return nanos / 1_000_000.0;
    }

    /**
     * Menjalankan perbandingan traversal, pencarian, penyisipan, dan penghapusan
     * untuk ukuran data tertentu. searchValue harus ada di dalam data.
     */
    public static Result[] run(int[] data, int searchValue, int insertValue, int insertIndex, int deleteValue) {
        ArrayOperations arrOps = new ArrayOperations(data);
        ArrayListOperations listOps = new ArrayListOperations(data);

        Result[] results = new Result[4];

        // --- Traversal ---
        long t1 = System.nanoTime();
        arrOps.traversal();
        long t2 = System.nanoTime();
        long t3 = System.nanoTime();
        listOps.traversal();
        long t4 = System.nanoTime();
        results[0] = new Result("Traversal", toMillis(t2 - t1), toMillis(t4 - t3));
        System.out.println();

        // --- Pencarian (linear search vs indexOf) ---
        t1 = System.nanoTime();
        int arrIdx = arrOps.linearSearch(searchValue);
        t2 = System.nanoTime();
        t3 = System.nanoTime();
        int listIdx = listOps.search(searchValue);
        t4 = System.nanoTime();
        System.out.println("Pencarian " + searchValue + " dalam Array: "
                + (arrIdx != -1 ? "Ditemukan di indeks " + arrIdx : "Tidak ditemukan"));
        System.out.println("Pencarian " + searchValue + " dalam ArrayList: "
                + (listIdx != -1 ? "Ditemukan di indeks " + listIdx : "Tidak ditemukan"));
        System.out.println();
        results[1] = new Result("Pencarian", toMillis(t2 - t1), toMillis(t4 - t3));

        // --- Penyisipan (pada posisi terurut, sesuai contoh output soal) ---
        t1 = System.nanoTime();
        arrOps.insertAt(insertValue, insertIndex);
        t2 = System.nanoTime();
        t3 = System.nanoTime();
        listOps.addAt(insertValue, insertIndex);
        t4 = System.nanoTime();
        System.out.println("Array setelah penyisipan elemen " + insertValue + ": "
                + java.util.Arrays.toString(arrOps.getData()));
        System.out.println("ArrayList setelah penyisipan elemen " + insertValue + ": "
                + listOps.getData());
        System.out.println();
        results[2] = new Result("Penyisipan", toMillis(t2 - t1), toMillis(t4 - t3));

        // --- Penghapusan ---
        t1 = System.nanoTime();
        arrOps.delete(deleteValue);
        t2 = System.nanoTime();
        t3 = System.nanoTime();
        listOps.remove(deleteValue);
        t4 = System.nanoTime();
        System.out.println("Array setelah penghapusan elemen " + deleteValue + ": "
                + java.util.Arrays.toString(arrOps.getData()));
        System.out.println("ArrayList setelah penghapusan elemen " + deleteValue + ": "
                + listOps.getData());
        System.out.println();
        results[3] = new Result("Penghapusan", toMillis(t2 - t1), toMillis(t4 - t3));

        return results;
    }

    public static void printTable(String title, Result[] results) {
        System.out.println("\n=== " + title + " ===");
        System.out.printf("%-12s | %-18s | %-18s%n", "Operasi", "Array (ms)", "ArrayList (ms)");
        System.out.println("-------------|--------------------|-------------------");
        for (Result r : results) {
            System.out.printf("%-12s | %-18.5f | %-18.5f%n",
                    r.operation, r.arrayTimeMs, r.arrayListTimeMs);
        }
    }

    public static void main(String[] args) {
        // 1) Data uji kecil, sesuai contoh output pada soal
        int[] smallData = {10, 20, 30, 40, 50};
        Result[] smallResults = run(smallData, 30, 25, 2, 25);
        printTable("Perbandingan (data kecil, n=5)", smallResults);

        // 2) Data uji besar (1000 elemen) untuk melihat perbedaan nyata
        int n = 1000;
        int[] largeData = new int[n];
        for (int i = 0; i < n; i++) {
            largeData[i] = i; // data terurut 0..999
        }
        int searchValue = largeData[n - 1];   // worst case untuk linear search
        int insertValue = 9999;
        int deleteValue = largeData[n / 2];

        // Traversal 1000 elemen di-print akan sangat panjang, jadi untuk data besar
        // kita ukur waktunya tanpa mencetak isi array secara penuh ke layar.
        Result[] largeResults = runLarge(largeData, searchValue, insertValue, deleteValue);
        printTable("Perbandingan (data besar, n=1000)", largeResults);
    }

    /** Sama seperti run(), tapi tanpa mencetak isi array/arraylist penuh (untuk data besar). */
    public static Result[] runLarge(int[] data, int searchValue, int insertValue, int deleteValue) {
        ArrayOperations arrOps = new ArrayOperations(data);
        ArrayListOperations listOps = new ArrayListOperations(data);
        Result[] results = new Result[4];

        long t1 = System.nanoTime();
        arrOps.getData(); // representasi traversal tanpa mencetak ke layar
        long t2 = System.nanoTime();
        long t3 = System.nanoTime();
        listOps.getData();
        long t4 = System.nanoTime();
        results[0] = new Result("Traversal", toMillis(t2 - t1), toMillis(t4 - t3));

        t1 = System.nanoTime();
        arrOps.linearSearch(searchValue);
        t2 = System.nanoTime();
        t3 = System.nanoTime();
        listOps.search(searchValue);
        t4 = System.nanoTime();
        results[1] = new Result("Pencarian", toMillis(t2 - t1), toMillis(t4 - t3));

        t1 = System.nanoTime();
        arrOps.insertAt(insertValue, data.length / 2);
        t2 = System.nanoTime();
        t3 = System.nanoTime();
        listOps.addAt(insertValue, data.length / 2);
        t4 = System.nanoTime();
        results[2] = new Result("Penyisipan", toMillis(t2 - t1), toMillis(t4 - t3));

        t1 = System.nanoTime();
        arrOps.delete(deleteValue);
        t2 = System.nanoTime();
        t3 = System.nanoTime();
        listOps.remove(deleteValue);
        t4 = System.nanoTime();
        results[3] = new Result("Penghapusan", toMillis(t2 - t1), toMillis(t4 - t3));

        return results;
    }
}
