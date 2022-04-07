package by.incubator.animals;

public class Dragonfly extends Animal{
    Dragonfly(String name, int footNumber, boolean hasMustache) {
        super(name, footNumber, hasMustache);
    }

    @Override
    public void move() {
        System.out.println("flight");
    }

    @Override
    public void voice() {
        System.out.println("bj-w-w");
    }

    @Override
    public void isHungry() {
        System.out.println("I want insects");
    }
}
