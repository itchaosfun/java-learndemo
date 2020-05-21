package project;

import java.util.Random;

public class Frametrans {

    public void test() {
        try {
            sourceFrame();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void sourceFrame() throws InterruptedException {
        Object o;
        Random random = new Random();
        String[] strings = new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        while (true) {
            Thread.sleep(20);
            int nextInt = random.nextInt(150);
            int type = nextInt % 2;
            if (type == 0){
                o = nextInt;
            }else {
                o = strings[nextInt % 26];
            }
            transFrame(o);
        }
    }

    private long before;

    private void transFrame(Object o) {
        System.out.println("source data = " + o);

        long current = System.currentTimeMillis();

        if (current - before >= 1000) {
            before = System.currentTimeMillis();
            postData(o);
        }
    }

    private void postData(Object o) {
        System.out.println("post data = " + o);
    }

}
