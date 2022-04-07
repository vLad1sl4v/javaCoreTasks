package by.incubator.animals;

public interface Movable {
    default void move() {
        System.out.println("movement");
    }
}
