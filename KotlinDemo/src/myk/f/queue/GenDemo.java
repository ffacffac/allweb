package myk.f.queue;

public class GenDemo {

    public static void main(String[] arr) {

//        GenQueue<String> g[] = new GenQueue[10];
//
//        g[1] = new GenQueue<>(new String[]{"1"});

        String[] strArr = new String[10];
        GenQueue<String> genQueue = new GenQueue<>(strArr);
        try {
            for (int i = 0; i < strArr.length; i++) {
                genQueue.put("i==" + i);
                System.out.println("put item success " + i);
            }
        } catch (QueueFullException e) {
            e.printStackTrace();
        }
        try {
            for (int i = 0; i < strArr.length; i++) {
                System.out.println("get queue item is " + genQueue.get());
            }
        } catch (QueueEmptyException e) {
            e.printStackTrace();
        }
    }
}
