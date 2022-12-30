package chapter5;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.BiFunction;

public class Chapter5Section1 {

    public static int calculate(int x, int y, BiFunction<Integer, Integer, Integer> operator) {
        return operator.apply(x, y);
    }

    public static int multiply(int x, int y) {
        return x * y;
    }

    public int subtract(int x, int y) {
        return x - y;
    }

    public void myMethod() {
        System.out.println(calculate(10, 3, this::subtract));
    }

    public static void main(String[] args) {
        int a = Integer.parseInt("15");
        System.out.println(a);

        Function<String, Integer> functionParseInt = s -> Integer.parseInt(s);
        Function<String, Integer> functionParseInt2 = Integer::parseInt;
        System.out.println(functionParseInt.apply("20"));

        String str = "hello";
        boolean b = str.equals("world");
        Predicate<String> functionEqualsToHello = str::equals;
        System.out.println(functionEqualsToHello.test("world"));

        System.out.println(calculate(8, 2, (x, y) -> x + y));
        System.out.println(calculate(8, 2, (x, y) -> multiply(x, y)));
        System.out.println(calculate(8, 2, Chapter5Section1::multiply));

        Chapter5Section1 instance = new Chapter5Section1();

        System.out.println(calculate(8, 2, (x, y) -> instance.subtract(x, y)));
        System.out.println(calculate(8, 2, instance::subtract));
        instance.myMethod();
    }
}
