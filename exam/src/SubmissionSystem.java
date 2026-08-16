package exam.src;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class SubmissionSystem {
    // Queue: menjaga urutan pemrosesan sesuai kedatangan (FIFO)
    private final Queue<Submission> submissionQueue = new LinkedList<>();

    // Stack: menyimpan submission terbaru untuk kebutuhan undo (LIFO)
    private final Deque<Submission> undoStack = new ArrayDeque<>();

    // HashMap: pencarian cepat berdasarkan submissionID
    private final Map<String, Submission> submissionIndex = new HashMap<>();

    // Menandai submission yang sudah di-undo (lazy deletion)
    private final Set<String> cancelledIds = new HashSet<>();
 
    // O(1) amortized: enqueue + push + hashmap put
    public void addSubmission(Submission submission) {
        submissionQueue.offer(submission);
        undoStack.push(submission);
        submissionIndex.put(submission.getSubmissionID(), submission);
    }
 
    // O(1): hanya submission TERAKHIR yang bisa di-undo
    public boolean undoSubmission() {
        if (undoStack.isEmpty()) {
            System.out.println("Tidak ada submission untuk di-undo.");
            return false;
        }
        Submission last = undoStack.pop();
        cancelledIds.add(last.getSubmissionID());
        submissionIndex.remove(last.getSubmissionID());
        System.out.println("Submission " + last.getSubmissionID() + " di-undo.");
        return true;
    }
 
    // Amortized O(1) per elemen yang di-skip;
    // O(1) untuk submission valid
    public Submission processSubmission() {
        while (!submissionQueue.isEmpty()) {
            Submission s = submissionQueue.poll();
            if (!cancelledIds.contains(s.getSubmissionID())) {
                System.out.println("Memproses: " + s);
                return s;
            }
        }
        System.out.println("Tidak ada submission tersisa untuk diproses.");
        return null;
    }
 
    // O(1) rata-rata: pencarian langsung via HashMap
    public Submission searchSubmission(String submissionID) {
        Submission result = submissionIndex.get(submissionID);
        if (result == null || cancelledIds.contains(submissionID)) {
            System.out.println("Submission " + submissionID + " tidak ditemukan.");
            return null;
        }
        return result;
    }
}

