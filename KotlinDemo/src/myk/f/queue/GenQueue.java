package myk.f.queue;

public class GenQueue<T> implements IGenQ<T> {

    private T[] q;
    private int putLoc, getLoc;

    public GenQueue(T[] aRef) {
        this.q = aRef;
        putLoc = getLoc = 0;
    }

    @Override
    public void put(T ch) throws QueueFullException {
        if (putLoc == q.length) {
            throw new QueueFullException(q.length);
        }
        q[putLoc++] = ch;
    }

    @Override
    public T get() throws QueueEmptyException {
        if (getLoc == putLoc) {
            throw new QueueEmptyException();
        }
        return q[getLoc++];
    }
}
