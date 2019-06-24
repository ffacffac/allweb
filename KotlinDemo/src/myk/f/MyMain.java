package myk.f;

public class MyMain {

    public static void main(String[] arrs) {

        Gen<Integer> iG = new Gen<>(10);
        Gen<String> strG = new Gen<>("string");

        Ex<Gen> exG = new Ex<>();
        exG.setGen(iG);
        exG.setGen(strG);


    }
}
