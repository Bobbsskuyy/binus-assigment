package exam.src;

public class Submission {
    private final String submissionID;
    private final String studentID;
    private final String assignmentID;
    private final long timestamp;
    private final String answer;
 
    public Submission(String submissionID, String studentID,
                       String assignmentID, String answer) {
        this.submissionID = submissionID;
        this.studentID = studentID;
        this.assignmentID = assignmentID;
        this.answer = answer;
        this.timestamp = System.currentTimeMillis();
    }
 
    public String getSubmissionID() { return submissionID; }
    public String getStudentID() { return studentID; }
    public String getAssignmentID() { return assignmentID; }
    public long getTimestamp() { return timestamp; }
    public String getAnswer() { return answer; }
 
    @Override
    public String toString() {
        return "Submission{id=" + submissionID + ", student=" + studentID
             + ", assignment=" + assignmentID + ", ts=" + timestamp + "}";
    }
}
