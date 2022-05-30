package by.incubator.threads.callableImpl;

import java.util.concurrent.Callable;

public class Caller implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() +  " started");
        System.out.println(Thread.currentThread().getName() + " finished");
        return Thread.currentThread().getName();
    }
}
