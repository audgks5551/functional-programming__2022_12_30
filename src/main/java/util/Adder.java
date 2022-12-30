package util;

import java.util.function.Function;
import java.util.function.BiFunction;

// 객체를 함수화 하는 과정
public class Adder implements Function<Integer, Integer> {

    @Override
    public Integer apply(Integer x) {
        return x + 10;
    }
}

class AdderMain {
    public static void main(String[] args) {
        // 객체를 함수로서 선언한다.
        Function<Integer, Integer> functionAdder = new Adder();

        int result = functionAdder.apply(5);
        System.out.println(result);
        // 너무 불편해...
        // 그냥 메서드로 만드는게 낫지 않나?? static 함수로 만들면 편할텐데..
        // 왜 객체를 함수로 만드는 걸까??
        // 람다식이 존재하네 한번 사용해보자!!

        Function<Integer, Integer> functionAdder2 = x -> x + 10;
        int result2 = functionAdder2.apply(5);
        System.out.println(result2);
        // 어? 클래스를 만들지 않아도 객체를 함수로 만들 수 있네!!

        // 매개변수를 두개 받는 건 어떻게 하지??
        // BiFunction 을 구현해보자!!
        BiFunction<Integer, Integer, Integer> functionAdd = (x, y) -> x + y;
        int result3 = functionAdd.apply(10, 20);
        System.out.println(result3);
    }
}
