public class ComplexNumber {

    private double realPart;
    private double imaginaryPart;

    public ComplexNumber(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public double getRealPart() {
        return realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    public ComplexNumber add(ComplexNumber other) {
        double realSum = realPart + other.getRealPart();
        double imaginarySum = imaginaryPart + other.getImaginaryPart();

        return new ComplexNumber(realSum, imaginarySum);
    }

    @Override
    public String toString() {
        if (imaginaryPart < 0) {
            return realPart + " - " + Math.abs(imaginaryPart) + "i";
        }

        return realPart + " + " + imaginaryPart + "i";
    }
}
