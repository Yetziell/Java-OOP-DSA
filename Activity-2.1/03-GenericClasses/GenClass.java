public class GenClass {
    private Object[] storage = new Object[50];

    public GenClass(Object firstValue, Object secondValue) {
        storage[0] = firstValue;
        storage[1] = secondValue;
    }

    public Object returnElement(int n) {
        return storage[n];
    }
}
