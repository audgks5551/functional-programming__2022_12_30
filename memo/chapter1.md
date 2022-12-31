# 1장 쏙쏙 들어오는 함수형 코딩에 오신 것을 환영합니다
# 함수형 프로그래밍
1. 수학함수를 사용하고 부수효과(side effect)를 피하는 것이 특징인 프로그래밍 패러다임
2. 부수효과 없이 순수함수(pure function)만 사용하는 프로그래밍 스타일

# 부수효과
- 함수가 리턴값 이외에 하는 모든일
- 대부분의 함수형 프로그래머는 불필요한 부수 효과를 가능한 사용하지 않으려고 합니다
- ex) 이메일 보내기, 파일 읽기, 불빛을 깜빡이기, 웹 요청을 하기, 자동차에 브레이크 밟기

# 순수 함수 == 수학 함수
- 인자에만 의존하고 부수 효과가 없는 함수
- 인자에만 의존한다는 말은 같은 인자를 넣으면 항상 같은 결과를 돌려준다는 의미

> 항상 부수효과와 순수함수를 사용할 순 없다
> 적절한 조화가 필요함

# 실용적인 측면에서 함수형 프로그래 정의의 문제점
- 문제1 부수 효과는 필요합니다
  - 필요할 때는 써야한다
- 문제2 함수형 프로그래밍은 부수 효과를 잘 다룰 수 있습니다
- 문제3 함수형 프로그래밍은 실용적입니다
> 정의만 보고 프로그래밍에 적용하려면 적용할 수 없다

# 함수형 프로그래밍을 학문적 지식이 아닌 기술과 개념으로 보기
- 이 책에서는 일반적인 함수형 프로그래밍의 정의를 쓰지 않는다
- 함수형 프로그래밍을 하기 위해 당장 쓸 수 있는 기술과 개념을 배울 수 있다
- 이 책의 함수형 프로그래밍은 객체 지향 프로그래밍이나 절차적 프로그래밍을 가리지 않고 모든 프로그래밍 언어에서 쓸 수 있다

# 액션과 계산, 데이터 구분하기
1. 액션
   - 액션은 호출하는 시점과 횟수에 의존한다
   - 호출 할 때 조심해야함
2. 계산
   - 여러 번 호출해도 상관없음 왜냐하면 몇번을 호출하더라도 항상 같은 값을 줌
   - 어떤 시점에 호출해도 상관없음
   - 계산은 실행하기 전까지 어떻게 동작할 지 알 수 없다
3. 데이터
   - 여러 번 호출해도 상관없음 왜냐하면 몇번을 호출하더라도 항상 같은 값을 줌
   - 어떤 시점에 호출해도 상관없음
   - 데이터는 같은 데이터를 여러 형태로 해석할 수 있다
   - 데이터는 정적이고 해석이 필요하다
> 계산과 데이터의 차이는 실행여부에 있는데, 계산은 실행 가능하나 데이터는 그렇지 않다
```
<< 액션 >>
sendEmail(to, from, subject, body)
saveUserDB(user)
getCurrentTime()

<< 그 외 >>
{ "firstname": "Eric", "lastname": "Normand" }
sum(numbers)
string_length(str)
[1, 10, 2, 45, 3, 98]
```

# 함수형 프로그래머는 실행하는 코드와 그렇지 않은 코드를 구분합니다
```
<< 액션 >>
sendEmail(to, from, subject, body)
saveUserDB(user)
getCurrentTime()

<< 계산 >>
sum(numbers)
string_length(str)

<< 데이터 >>
{ "firstname": "Eric", "lastname": "Normand" }
[1, 10, 2, 45, 3, 98]
```
- 액션과 계산, 데이터를 구분하는 것은 함수형 프로그래밍의 기본 개념
- 일반적으로 액션 보다는 계산이 쓰기 쉽고 계산 보다는 데이터가 쓰기 쉽다

# 함수형 프로그래머는 액션과 계산, 데이터를 구분합니다
- 1단계: 사용자가 작업 완료 표시를 함
  - UI 이벤트인데 실행 횟수에 의존하기 때문에 `액션`
- 2단계: 클라이언트가 서버로 메시지를 보냄
  - 메세지를 보내는 행위는 `액션`
  - 메세지 자체는 `데이터`
- 3단계: 서버가 메세지를 받음
  - `액션`
- 4단계: 서버가 누구에게 알림을 보낼지 결정
  - 결정하는 것은 `계산`
- 5단계: 서버가 이메일로 알림을 보냄
  - 이메일 보내기는 `액션`

# 액션, 계산, 데이터를 구분하면 어떤 장점이 있나요?
- 함수형 프로그래밍은 요즘 유행하는 분산 시스템에 잘 어울립니다
- 실행 시점이나 횟수에 의존하는 코드를 없애면, 코드를 더 쉽게 이해할 수 있고 심각한 버그를 막을 수 있다
- 코드를 데이터와 계산으로 바꿀수록 분산 시스템에서 생기는 여러가지 문제를 해결할 수 있다
- 액션은 실행 시점과 횟수에 의존하기 때문에 여전히 문제가 되지만, 코드 전체에 영향을 주지 않도록 격리시켜야 한다
- `액션 => 계산` 으로 옮기면 결과적으로 액션도 다루기 쉬워진다 

# 함수형 사고가 무엇인가요?
- 함수형 프로그래머가 소프트웨어 문제를 해결하기 위해 사용하는 기술과 생각
- 중요한 개념
  1. 액션과 계산, 데이터를 구분해서 생각하는 것
  2. 일급 추상

# 이 책을 읽는 기본 규칙
1. 특정 언어 기능에 의존하지 않아야 합니다
2. 실용적이라 바로 쓸 수 있어야 합니다
3. 여러분의 현재 가지고 있는 코드와 관계없이 쓸 수 있어야 합니다
