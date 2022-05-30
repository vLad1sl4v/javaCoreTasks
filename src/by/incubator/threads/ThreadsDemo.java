package by.incubator.threads;

import by.incubator.threads.callableImpl.Caller;
import by.incubator.threads.runnableImpl.Runner;

public class ThreadsDemo {
    public static void main(String[] args) throws Exception {
        startMyThread();
        startRunner();
        startCaller();
        startAnonymous();
    }

    private static void startAnonymous() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous started");
                System.out.println("Anonymous finished");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    private static void startCaller() throws Exception {
        Caller caller = new Caller();
        caller.call();
    }

    private static void startRunner() {
        Thread thread = new Thread(new Runner());
        thread.setDaemon(true);
        thread.start();
    }

    private static void startMyThread() {
        MyThread myThread = new MyThread("MyThread");
        myThread.start();
    }
}
