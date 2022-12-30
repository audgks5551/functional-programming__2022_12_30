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