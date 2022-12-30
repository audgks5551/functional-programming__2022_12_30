# Lambda Expression (람다식)
- 이름이 없는 함수 == Anonymous function

```java
(Integer x) -> {
    return x + 10;    
}
```

## 람다식을 단순하게 만들 수 있는 경우
- 매개변수의 타입이 유추 가능할 경우 타입 생략 가능
- 매개변수가 하나일 경우 괄호 생략 가능
- 바로 리턴하는 경우 중괄호 생략 가능

# Functional Interface
- 단 하나의 추상 메서드만을 가지는 인터페이스
- Single Abstract Method interface
- 예로는 Runnable, Comparator, Callable, etc
- `@FunctionalInterface`가 interface 에 선언이 되어 있으면 단 하나의 추상 메서드만을 가지고 람다식이 가능한 interface
```java
@FunctionalInterface
public interface Function<T, R> {
    
    R apply(T t);
    
    default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
        Objects.requireNonNull(before);
        return (V v) -> apply(before.apply(v));
    }
    
    default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t) -> after.apply(apply(t));
    }
    
    static <T> Function<T, T> identity() {
        return t -> t;
    }
}
```