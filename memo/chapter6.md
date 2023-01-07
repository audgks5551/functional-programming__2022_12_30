# 변경 가능한 데이터 구조를 가진 언어에서 불변성 유지하기
- 동작을 읽기와 쓰기 또는 둘 다로 분류할 수 있습니다
- 쓰기를 할 때 불변성 원칙을 따라야 합니다
- 인자만 받는 읽기는 계산이다
- 계산에서는 변경 가능한 데이터에 쓰기를 할 수 없습니다
- 

# 카피-온-라이트(copy-on-write)
- 카피-온-라이트는 불변성 원칙을 적용합니다.
- 카피-온-라이트는 쓰기를 읽기로 바꾸는 행동입니다.
- 카피-온-라이트 규칙
  1. 복사본 만들기
  2. 복사본 변경하기(원하는 만큼)
  3. 복사본 리턴하기

# 쓰기와 읽기를 동시에 하는 동작은 어떻게 카피-온-라이트를 할 수 있는 방법
- 2가지 방법 
  1. 함수를 분리하기
     - 쓰기와 읽기로 분리
  2. 값을 두 개 리턴하기