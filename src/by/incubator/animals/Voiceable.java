package by.incubator.animals;

public interface Voiceable {
    default void voice() {
        System.out.println("voice");
    };
}


