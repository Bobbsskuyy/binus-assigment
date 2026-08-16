package exam.src;

public class Main {
    public static void main(String[] args) {
        SubmissionSystem system = new SubmissionSystem();
        system.addSubmission(new Submission("S001", "STD01", "A01", "Jawaban 1"));
        system.addSubmission(new Submission("S002", "STD02", "A01", "Jawaban 2"));
        system.undoSubmission();       // undo S002
        system.processSubmission();    // memproses S001
        system.searchSubmission("S001");
 
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        String postfix = evaluator.infixToPostfix("A+B*C");
        System.out.println("Postfix: " + postfix); // ABC*+
 
        String numericPostfix = evaluator.infixToPostfix("3+4*2");
        System.out.println("Hasil: " + evaluator.evaluatePostfix(numericPostfix)); // 11.0
    }
}
