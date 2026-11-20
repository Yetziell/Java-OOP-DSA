public class Client {
    public static void main(String[] args) {
        // Create three objects of class C
        C object1 = new C("object1", 100, 2000.0);
        C object2 = new C("object2");
        C object3 = new C();

        // Call methods on the objects
        object1.method2(123);
        object1.method1();
        object2.method2(123, "object2");
        object3.method1();
    }
}
