# 부수효과
- 암묵적 입력과 출력을 없애면 계산이 됩니다.
- 암묵적 입력은 함수의 인자로 바꾸고, 암묵적 출력은 함수의 리턴값으로 바꾸면 됩니다.

# 리팩터링
- 코드를 고칠 때 동작을 유지하면서 고치는 감각을 기르는 것이 좋다

# 계산 추출하는 방법
1. 계산 코드를 찾아 빼냅니다.
2. 새 함수에 암묵적 입력과 출력을 찾습니다.
3. 암묵적 입력은 인자로 암묵적 출력은 리턴값으로 바꿉니다.
- 인자와 리턴값은 바뀌지 않는 불변값이라는 것이 중요