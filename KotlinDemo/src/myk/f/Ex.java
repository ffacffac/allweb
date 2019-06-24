package myk.f;

public class Ex<T extends Gen> {
    private T t;

    Ex() {
    }

    public Ex(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    void setGen(Gen<?> gen) {
        System.out.println("gen class type is:" + gen.getClass().getTypeName());
        System.out.println("gen t value is :" + gen.getT().getClass().getTypeName());
    }

    public void setGenT(Gen<T> gen) {
        System.out.println("gen class type is:" + gen.getClass().getTypeName());
        System.out.println("gen t value is :" + gen.getT().getClass().getTypeName());
    }

    @Override
    public String toString() {
        return "Ex{" +
                "t=" + t +
                '}';
    }
}
