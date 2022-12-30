package chapter6;

import model.Order;
import model.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chapter6Section3 {
    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(3, 6, -4);

        Stream<Integer> numberStream = numberList.stream();
        Stream<Integer> numberStreamX2 = numberStream.map(x -> x * 2);
        List<Integer> numberListX2 = numberStreamX2.toList();
        System.out.println(numberListX2);

        List<Integer> numberListX3 = numberList.stream()
                .map(number -> number * 2)
                .toList();
        System.out.println(numberListX3);

        Stream<Integer> numberListStream = numberList.stream();
        Stream<String> strStream = numberListStream.map(x -> "Number is " + x);
        List<String> strList = strStream.collect(Collectors.toList());
        System.out.println(strList);

        User user1 = new User()
                .setId(101)
                .setName("Alice")
                .setVerified(true)
                .setEmailAddress("alice@example.com");

        User user2 = new User()
                .setId(102)
                .setName("Bob")
                .setVerified(false)
                .setEmailAddress("bob@example.com");

        User user3 = new User()
                .setId(103)
                .setName("Charlie")
                .setVerified(true)
                .setEmailAddress("charlie@example.com");

        List<User> users = Arrays.asList(user1, user2, user3);

        List<String> userEmails = users.stream()
                .map(User::getEmailAddress)
                .toList();

        System.out.println(userEmails);

        Order order1 = new Order()
                .setId(1001)
                .setStatus(Order.OrderStatus.CREATED)
                .setCreatedByUserId(101);

        Order order2 = new Order()
                .setId(1002)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreatedByUserId(102);

        Order order3 = new Order()
                .setId(1003)
                .setStatus(Order.OrderStatus.PROCESSED)
                .setCreatedByUserId(103);

        Order order4 = new Order()
                .setId(1004)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreatedByUserId(104);

        Order order5 = new Order()
                .setId(1005)
                .setStatus(Order.OrderStatus.IN_PROGRESS)
                .setCreatedByUserId(105);

        List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);

        List<Long> createdByUserIds = orders.stream()
                .map(Order::getCreatedByUserId)
                .toList();

        System.out.println(createdByUserIds);
    }
}
