package util;

@FunctionalInterface
public interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}

class TriFunctionMain {
    public static void main(String[] args) {
        TriFunction<Integer, Integer, Integer, Integer> functionSumThreeNumbers = (x, y, z) -> x + y + z;

        int result = functionSumThreeNumbers.apply(10, 20, 30);
        System.out.println(result);
    }
}
