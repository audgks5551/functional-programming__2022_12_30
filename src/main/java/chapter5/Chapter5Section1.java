package chapter5;

import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

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

    public static void printUserField(List<User> users, Function<User, Object> getter) {
        for (User user : users) {
            System.out.println(getter.apply(user));
        }
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

        Function<String, Integer> functionStrLength = s -> s.length();
        Function<String, Integer> functionStrLength2 = String::length;
        System.out.println(functionStrLength2.apply("hello"));

        BiPredicate<String, String> functionStrEquals = (s, anObject) -> s.equals(anObject);
        BiPredicate<String, String> functionStrEquals2 = String::equals;
        functionStrEquals.test("hello", "world");

        List<User> users = new ArrayList<>();
        users.add(new User(3, "mark"));
        users.add(new User(1, "Charlie"));
        users.add(new User(5, "Bob"));

        printUserField(users, user -> user.getId());
        printUserField(users, User::getName);

        User user = new User(3, "mark");
        BiFunction<Integer, String, User> functionUserCreator = User::new;

        System.out.println(functionUserCreator.apply(3, "mark"));
    }
}
