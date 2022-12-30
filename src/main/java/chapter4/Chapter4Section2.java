package chapter4;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Chapter4Section2 {
    public static void main(String[] args) {
        Consumer<String> functionStringConsumer = x -> System.out.println(x);

        functionStringConsumer.accept("안녕");

        List<Integer> integerInputs = Arrays.asList(4, 2, 3); // immutable list
        List<Double> doubleInputs = Arrays.asList(1.1, 2.2, 3.3);
        // integerInputs.add(4); // java.lang.UnsupportedOperationException
        Consumer<Integer> functionIntegerConsumer1 = x -> System.out.println("Processing integer1 : " + x);
        Consumer<Integer> functionIntegerConsumer2 = x -> System.out.println("Processing integer2 : " + x);
        Consumer<Double> functionDoubleConsumer = x -> System.out.println("Processing double : " + x);

        process(integerInputs, functionIntegerConsumer2);
        process(doubleInputs, functionDoubleConsumer);
    }

    public static <T> void process(List<T> inputs, Consumer<T> processor) {
        for (T input : inputs) {
            processor.accept(input);
        }
    }
}
