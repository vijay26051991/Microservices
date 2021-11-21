package com.cloing;

public class DoubleCheckLocking {

    public static void main(String[] args) {
        WorkerThread workerThread1 = new WorkerThread();
        Thread thread1 = new Thread(workerThread1);
        Thread thread2 = new Thread(workerThread1);
        Thread thread3 = new Thread(workerThread1);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class WorkerThread implements Runnable {

    @Override
    public void run() {
        System.out.println(Singleton.getInstance().hashCode());
    }
}

class Singleton {
    private volatile static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }
}
