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

## functional interface 종류
### 1. Supplier 
- 공급하는 인터페이스
- 아낌없이 주는 나무
- input 없이 return 값만 있다.
```java
@FunctionalInterface
public interface Supplier<T> {
    T get();
}
```
> 실제로 어디서 사용할까??
> 실제 예제나 있나??

### 2. Consumer
- 먹보
- input 으로 받기만 하고 return 값이 없다
```java
@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}
```
### 3. BiConsumer
- 더 먹보
- input 2개를 받기만하고 return 값이 없다.
```java
@FunctionalInterface
public interface BiConsumer<T, U> {
    void accept(T t, U u);
}
```

### 4. Predicate
- 진실 혹은 거짓
```java
@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);

    default Predicate<T> and(Predicate<? super T> other) {
        Objects.requireNonNull(other);
        return (t) -> test(t) && other.test(t);
    }
    
    default Predicate<T> negate() {
        return (t) -> !test(t);
    }
    
    default Predicate<T> or(Predicate<? super T> other) {
        Objects.requireNonNull(other);
        return (t) -> test(t) || other.test(t);
    }
    
    static <T> Predicate<T> isEqual(Object targetRef) {
        return (null == targetRef)
                ? Objects::isNull
                : object -> targetRef.equals(object);
    }

    @SuppressWarnings("unchecked")
    static <T> Predicate<T> not(Predicate<? super T> target) {
        Objects.requireNonNull(target);
        return (Predicate<T>)target.negate();
    }
}
```
- and 메서드 경우 `(T t) -> test(t) && other.test(t);` 라고 표현할 수 있다
- 즉, T 타입의 새로운 함수를 만들어 반환하는 것이다.