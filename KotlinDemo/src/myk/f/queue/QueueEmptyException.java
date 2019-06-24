package myk.f.queue;

public class QueueEmptyException extends Exception {
    @Override
    public String toString() {
        return "\n Queue is empty";
    }
}
