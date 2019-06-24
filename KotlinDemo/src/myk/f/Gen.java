package myk.f;

public class Gen<T> {

    private T t;

    public Gen(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "Gen{" +
                "t=" + t +
                '}';
    }

}
