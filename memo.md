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

### 5. Comparator
- 비교를 위한 인터페이스
```java
@FunctionalInterface
public interface Comparator<T> {
    int compare(T o1, T o2);
}
```

## Method Reference
- 기존에 이미 선언되어있는 메서드를 지정하고 싶을 때
- :: 오퍼레이터 사용
- 생략이 많기 때문에 사용할 메서드의 매개변수의 타입과 리턴 타입을 미리 숙지해야함

### 메서드 레퍼런스의 4가지 케이스
- ClassName::staticMethodName
  - 클래스의 static method 를 지정할 때
- objectName::instanceMethodName
  - 선언된 객체의 instance method 를 지정할 때
- ClassName::instanceMethodName
  - 객체의 instance method 를 지정할 때
- ClassName:new
  - 클래스의 constructor 를 지정할 때

## Stream
- 시내, 흐름

## Filter
- 거름종이 같은 필터
- 만족하는 데이터만 걸러내는데 사용
- Predicate 에 true 를 반환하는 데이터만 존재하는 stream 을 리턴
```java
@FunctionalInterface
public interface Stream<T> extends BaseStream<T, Stream<T>> {
  Stream<T> filter(Predicate<? super T> predicate);    
}
```

## Map
- 데이터 변형
- 데이터에 해당 함수가 적용된 결과물을 제공하는 stream 을 리턴

```java
import java.util.stream.BaseStream;

@FunctionalInterface
public interface Stream<T> extends BaseStream<T, Stream<T>> {
    <R> Stream<R> map(Function<? super T, ? extends R> mapper);
}
```