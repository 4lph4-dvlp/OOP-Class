class SharedData {
    public int i = 0, j = 0, total = 0;
}

public class Lab9_3 {
    public static void main(String[] args) {
        SharedData data = new SharedData();
        MyTest jthread = new MyTest(data);

        data.i = 10;
        data.j = 20;
        jthread.start();

        try {
            jthread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("i= " + data.i);
        System.out.println("j= " + data.j);
        System.out.println("total= " + data.total);
    }
}

class MyTest extends Thread {
    private SharedData dt;

    public MyTest(SharedData d) {
        dt = d;
    }

    public void run() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dt.total = dt.i + dt.j;
    }
}
