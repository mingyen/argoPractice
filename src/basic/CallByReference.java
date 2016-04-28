package basic;

/**
 * http://brownydev.blogspot.tw/2011/06/java-call-by-value-call-by-reference.html
 * http://stackoverflow.com/questions/40480/is-java-pass-by-reference-or-pass-by-value
 */
public class CallByReference {


    //    public static void main(String args[]) {
//        int[] myInt = {1};
//        System.out.println("Array contents : " + myInt[0]);
//        increment(myInt, 5);
//        System.out.println("Array contents : " + myInt[0]);
//    }
//
//    public static void increment(int[] array, int amount) {
//        array[0] = array[0] + amount;
//    }


    public static void main(String[] args) {
        Dog aDog = new Dog("Max");
        System.out.println(Integer.toHexString(System.identityHashCode(aDog)));
        foo(aDog);

        System.out.println(Integer.toHexString(System.identityHashCode(aDog)));
        if (aDog.getName().equals("Max")) { //true
            System.out.println("Java passes by value.");

        } else if (aDog.getName().equals("Fifi")) {
            System.out.println("Java passes by reference.");
        }

        bar(aDog);
        if (aDog.getName().equals("Max")) { //true
            System.out.println("Java passes by value.");

        } else if (aDog.getName().equals("Fifi")) {
            System.out.println("Java passes by reference.");
        }
    }

    public static void foo(Dog d) {
        System.out.println(Integer.toHexString(System.identityHashCode(d)));
        d.getName().equals("Max");

        d = new Dog("Fifi"); //
        System.out.println(Integer.toHexString(System.identityHashCode(d)));
        d.getName().equals("Fifi");
    }

    public static void bar(Dog d) {
        d.setName("Fifi");
        System.out.println(Integer.toHexString(System.identityHashCode(d)));

    }
}
