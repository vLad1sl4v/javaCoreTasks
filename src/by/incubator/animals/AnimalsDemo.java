package by.incubator.animals;

public class AnimalsDemo {
    public static void main(String[] args) {
        Animal[] herd = new Animal[7];
        herd[0] = new Horse("Horse", 4, false);
        herd[1] = new Horse("Horse 2", 4, false);
        herd[2] = new Kangaroo("Kangaroo", 2, true);
        herd[3] = new Kangaroo("Kangaroo 2", 2, true);
        herd[4] = new Dragonfly("Dragonfly", 6, true);
        herd[5] = new Dragonfly("Dragonfly 2", 6, true);
        herd[6] = new Animal("Unknown type", 10, true) {
        };

        Horse horse = new Horse("Horse 3", 4, false);
        Kangaroo kangaroo = new Kangaroo("Kangaroo 3", 2, true);
        Dragonfly dragonfly = new Dragonfly("Dragonfly 3", 6, true);

        for (Animal animal : herd) {
            animal.voice();
        }

        horse.voice();
        kangaroo.voice();
        dragonfly.voice();

        for (Animal animal : herd) {
            animal.move();
        }

        horse.move();
        kangaroo.move();
        dragonfly.move();

        for (Animal animal : herd) {
            animal.isHungry();
        }

        horse.isHungry();
        kangaroo.isHungry();
        dragonfly.isHungry();

    }
}
