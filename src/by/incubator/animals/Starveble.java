package by.incubator.animals;

public interface Starveble {
    default void isHungry() {
        System.out.println("not hungry");
    }
}
