package stack;

public class StackUnderFlowException extends RuntimeException {
    public StackUnderFlowException(String message) {
        super(message);
    }
}
