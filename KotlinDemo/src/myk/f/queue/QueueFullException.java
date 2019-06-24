package myk.f.queue;

public class QueueFullException extends Exception {

    private int size;

    QueueFullException(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "\nQueue is full,Maximum size is " + size;
    }
}
