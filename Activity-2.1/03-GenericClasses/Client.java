public class Client {
    public static void main(String[] args) {
        GenClass intObject = new GenClass(12, 13);
        GenClass doubleObject = new GenClass(12, 13.2);

        System.out.println("Object 1: " +
            ((Integer) intObject.returnElement(1)).intValue());

        System.out.println("Object 2: " +
            ((Double) doubleObject.returnElement(1)).doubleValue());
    }
}