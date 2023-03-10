# Actions, calculations, and data
1. 문제에 대해 생각할 때
   - 코드를 작성할 때 액션과 계산을 명확하게 알 수 있어야 한다
2. 코딩할 때
   - 액션에서 계산을 최대한 빼내야 한다
   - 계산에서 데이터를 최대한 빼내야 한다
   - 액션이 계산이 될 수 있는지, 계산은 데이터가 될 수 있는지 고민해야 함
3. 코드를 읽을 때
   - 액션과 계산, 데이터 중 어떤 것에 속하는지 잘 살펴봐야 합니다

# 액션, 계산, 데이터 적용
- 액션에 숨어 있는 다른 액션이나 계산 또는 데이터를 발견하기 위해 나눌 수 있는 만큼 나누는 것이 좋다 그러나 나누는 것을 언제 멈춰야 할 지 아는 것이 중요
- 데이터를 먼저 찾아야 한다 그러면 동작에 대해 많은 것을 알 수 있다
- 계산은 우리 사고 과정에 녹아있기 때문에 찾기가 쉽지 않다
- 결정과 계획은 계산이 될 가능성이 높다

# 데이터
- 데이터는 이벤트에 대한 사실
- 데이터는 일어난 일의 결과를 기록한 것
- 데이터의 구조를 정할 때 해당 환경에 맞는 구조로 정하면 된다
  - 만약 리스트에 순서가 필요하다면 순서를 정할 수 있는 데이터 구조를 사용하면 된다
- 데이터는 불변 데이터 구조로 만들어야 한다
  1. 카피-온-라이트(copy-on-write) : 변경할 때 복사본을 만든다
  2. 방어적 복사(defensive copy) : 보관하려고 하는 데이터의 복사본을 만든다
- 데이터는 언제나 쉽게 해석할 수 있도록 표현해야 한다.
- 데이터는 데이터 자체로 할 수 있는 것이 없다.
- 데이터의 장점
  1. 직렬화
  2. 동일성 비교
  3. 자유로운 해석
     - ex) 바이트 -> 문자 -> JSON -> 컬렉션 -> 사용자 정보
- 데이터는 유연하게 해석할 수 있지만 해석이 반드시 필요하다는 단점이 존재

# 연습문제 1
```
A : 액션
C : 계산
D : 데이터
---
이메일 보내기 (A)
데이터베이스에서 구독자 가져오기 (A)
쿠폰에 등급 매기기 (D) ?? (C) 아닌가????
데이터베이스에서 쿠폰 가져오기 (A)
이메일 제목 (D)
이메일 주소 (D)
추천 수 (D)
어떤 이메일이 쿠폰을 받을지 결정하기 (C)
구독자 DB 레코드 (D)
쿠폰 DB 레코드 (D)
쿠폰 목록 DB 레코드 (D)
구독자 목록 DB 레코드 (D)
이메일 본문 (D)
```
```
<< 쿠폰 보내는 과정 >> 

       액션                    계산                    데이터
DB에서 구독자 가져오기 -------------------------------> 구독자 목록
DB에서 쿠폰 가져오기 ---------------------------------> 쿠폰 목록
                                                 good 쿠폰 목록 <----
                                                  bad 쿠폰 목록 <----
                         쿠폰 등급 결정하기 <--------
                                        --------->  쿠폰 등급
    쿠폰 등급이 "good"이면 good 이메일을 만들기 <----------
    쿠폰 등급이 "best"이면 best 이메일을 만들기 <----------
                                        ---------> 이메일 목록
                       ( 이메일 목록 계획하기 <-------
                                         <-------
                                         --------> 이메일 목록 )
이메일 보내기 <--------------------------------------
```
- 계산을 사용하려는 이유는 테스트하기 쉽기 때문에

# 코드 작성 순서
```
데이터 -> 계산 -> 액션
```

# 계산
- 계산은 일반적으로 함수형 프로그래밍 외부에 있는 액션을 통해 수행됩니다.
- 계산 내에서 걱정하지 않아도 되는것
  1. 동시에 실행되는 것
     - 외부에 영향을 주는 요소가 없기 때문에 동시에 실행되어도 상관없다
  2. 과거에 실행되었던 것이나 미래에 실행할 것
     - 실행 시점
  3. 실행 횟수
- 계산과 액션은 실행하기 전에 어떤 일이 발생할지 알 수 없다는 단점이 있습니다.
- 계산과 액션의 단점이 싫다면 데이터를 사용해야 합니다.

# 액션
- 어떤 함수 안에 액션이 존재한다고 액션을 품고 있는 함수도 액션입니다. 
- 액션을 찾을 수 있는 방법은 코드가 호출 시점이나 횟수에 의존하는지 생각해보면 된다
- 반복이 일어났을 때 문제가 있고 순서가 변경되었을 때 문제가 있다면 액션이다. 