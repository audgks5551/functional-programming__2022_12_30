package chapter4;

import java.util.function.Supplier;

public class Chapter4Section1 {
    public static void main(String[] args) {
        Supplier<String> functionStringSupplier = () -> "안녕";
        System.out.println(functionStringSupplier.get());

        Supplier<Double> functionRandomDoubleSupplier = () -> Math.random();
        System.out.println(functionRandomDoubleSupplier.get());
        System.out.println(functionRandomDoubleSupplier.get());
        System.out.println(functionRandomDoubleSupplier.get());

        printRandomDoubles(functionRandomDoubleSupplier, 5);
    }

    // random number 를 만드는 방식에 관해서는 printRandomDoubles 메서드가 관여하지 않는다.
    public static void printRandomDoubles(Supplier<Double> randomSupplier, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(randomSupplier.get());
        }
    }
}
