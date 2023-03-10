# 함수형 프로그래밍
- 함수에서 결괏값을 주는 것 외에 하는 행동(부수효과)이 없어야 하며 부수 효과 없이 결과값이 인자에만 의존하는 함수(순수함수)
- 해석하면 어떤 함수가 외부에 영향을 주면 안되고 인자가 같다면 항상 같은 결과를 가져와야 합니다

# 함수형 프로그래밍의 오해
1. 부수 효과는 필요없다??
   - 함수형 프로그래밍에서는 부수 효과가 필요하며 필요할 때만 써야합니다
   - 함수형 프로그래머는 부수 효과를 잘 다룰 수 있어야 합니다
2. 함수형 프로그래밍은 실용적이지 않다??
   - 함수형 프로그래밍은 실용적이다

# 액션과 계산, 데이터 구분하기 (3장)
- 액션과 계산, 데이터를 구분하는 것은 함수형 프로그래밍의 시작이다
- 액션 == 동작 == 실행 시점이나 횟수 또는 둘 다에 의존한다
  - 액션함수를 사용한 함수는 액션함수가 된다
- 계산 == 순수함수 == 수학함수 == 입력값으로 출력값을 만드는 것
  - 같은 입력값을 가지고 계산하면 항상 같은 결과값을 반환한다
  - 계산을 쓰면 신경쓰지 않아도 되는 것들
    1. 동시에 실행되는 것
    2. 과거에 실행되었던 것이나 미래에 실행할 것
    3. 실행 횟수
  - 읽기 동작만 하는 함수
- 데이터 == 이벤트에 대해 기록한 사실
- 구현순서
  1. 데이터
  2. 계산
  3. 액션
- 부수효과는 암묵적 입력과 출력입니다
  - 암묵적 입력은 인자로 암묵적 출력은 리턴값으로 바꿉니다

# 카피-온-라이트
- 카피-온-라이트는 쓰기를 읽기로 바꿉니다

# 얕은 복사, 깊은 복사, 방어적 복사
- 얕은 복사는 최상위 데이터 구조는 복사하고 하위 데이터 구조는 참조만 복사하여 구조적 공유를 이룬다
- 얕은 복사는 하위 데이터 구조를 변경할 때 카피-온-라이트를 사용하여 참조를 변경시켜야 한다
- 깊은 복사는 앞뒤로 최상위는 물론 하위 데이터까지 모두 복사하여 구조적 공유를 하지 않는 복사를 이야기한다
  - 예) API 직렬화
- 방어적 복사는 앞뒤로 깊은 복사를 해야주어야한다
  ```javascript
  var cart_copy = deepCopy(shopping_cart); // 앞
  black_friday_promotion(cart_copy);
  shopping_cart = deepCopy(cart_copy); // 뒤 
  ```

# 계층형 설계 (8~9장)
- 비즈니스 규칙
- 도메인 규칙
- 기술스택

# 일급함수
- 코드의 냄새 : 함수 이름에 있는 암묵적 인자
- 해결방법
  1. 암묵적 인자를 드러내기
  2. 함수 본문을 콜백으로 바꾸기

# 타임라인 다이어그램을 그리는 방법(15장)

# 타임라인 커팅(17장)