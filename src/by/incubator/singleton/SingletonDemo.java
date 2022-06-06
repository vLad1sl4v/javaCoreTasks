package by.incubator.singleton;

public class SingletonDemo {
    public static void main(String[] args) {
        startThreads();
    }

    private static void startThreads() {
        Runnable runnable = () -> {
            Singleton singleton = Singleton.instance();
            System.out.println(singleton);
        };

        Thread firstThread = new Thread(runnable);
        Thread secondThread = new Thread(runnable);
        Thread thirdThread = new Thread(runnable);

        firstThread.start();
        secondThread.start();
        thirdThread.start();
    }
}