class Table {
    synchronized void printTable(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.print(n * i);
            if (i != 5) System.out.print(" ");
        }
        if (n == 5) {
            System.out.print(" \n"); // space after 25, then newline
        }
    }
}

class MyThread1 extends Thread {
    Table t;
    MyThread1(Table t) { this.t = t; }
    public void run() { t.printTable(5); }
}

class MyThread2 extends Thread {
    Table t;
    MyThread2(Table t) { this.t = t; }
    public void run() { t.printTable(100); }
}

public class SynchronizationDemo {
    public static void main(String[] args) throws InterruptedException {
        Table t = new Table();
        MyThread1 t1 = new MyThread1(t);
        MyThread2 t2 = new MyThread2(t);

        t1.start();
        t1.join();   // table of 5 finishes first
        t2.start();
        t2.join();   // then table of 100
    }
}
