package myk.f;

public class GenericMethodDemo {

    public static void main(String[] arrs) {
        Integer nums[] = {1, 2, 3, 4, 5};
        Integer nums2[] = {1, 2, 3, 4, 5};
        Integer nums3[] = {1, 2, 7, 4, 5};
        Integer nums4[] = {1, 2, 7, 4, 5, 6};

        Float fN[] = {1.0f, 2.0f, 3.0f, 4.0f};
        Float fN2[] = {1.0f, 2.0f, 3.0f, 4.0f};
        Float fN3[] = {1.0f, 2.0f, 5.0f, 4.0f};

        if (arraysEqual(nums, nums2)) {
            System.out.println("unms equals nums2");
        }

        if (arraysEqual(fN, fN2)) {
            System.out.println("fN equals fN2");
        }
    }

    private static <T extends Comparable<T>, V extends T> boolean arraysEqual(T[] x, V[] y) {
        if (x.length != y.length) return false;
        for (int i = 0; i < x.length; i++) {
            if (!x[i].equals(y[i])) return false;
        }
        return true;
    }
}
