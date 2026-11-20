public class Main {
    public static void main(String[] args) {
        C2 object1 = new C2();

        object1.f1();
        
        C2.f2();
        C2.f2("Calling an overloaded static method.");
    }
}