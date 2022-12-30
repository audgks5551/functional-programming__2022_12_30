package util;

import java.util.function.Function;

// 객체를 함수화 하는 과정
public class Adder implements Function<Integer, Integer> {

    @Override
    public Integer apply(Integer x) {
        return x + 10;
    }
}

class Main {
    public static void main(String[] args) {
        // 객체를 함수로서 선언한다.
        Function<Integer, Integer> functionAdder = new Adder();

        int result = functionAdder.apply(5);
        System.out.println(result);
        // 너무 불편해...
        // 그냥 메서드로 만드는게 낫지 않나?? static 함수로 만들면 편할텐데..
        // 왜 객체를 함수로 만드는 걸까??
    }
}
