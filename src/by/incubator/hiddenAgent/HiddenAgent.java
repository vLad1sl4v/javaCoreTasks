package by.incubator.hiddenAgent;

public class HiddenAgent {
    public static void main(String[] args) {
        HiddenAgent obj = new HiddenAgent();
        Class<?> myClass = obj.getClass();

        Integer integer = new Integer(127);
        Class<?> myClassInt = integer.getClass();

        Test test = new Test();
        Class<?> myClassTest = test.getClass();

        System.out.println("class Loader and it's parents for HiddenAgent:");
        System.out.println(myClass.getClassLoader());
        System.out.println(myClass.getClassLoader().getParent());
        System.out.println(myClass.getClassLoader().getParent().getParent());

        System.out.println("class Loader for Integer:");
        System.out.println(myClassInt.getClassLoader());

        System.out.println("class Loader and it's parents for Test:");
        System.out.println(myClassTest.getClassLoader());
        System.out.println(myClassTest.getClassLoader().getParent());
        System.out.println(myClassTest.getClassLoader().getParent().getParent());
    }
}

class Test {

}
