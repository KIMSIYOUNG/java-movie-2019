# 우아한 테크코스 (영화예매 : 작년 오프라인 코딩테스트)

## 프로그램 설명

- 커멘드라인에서 현재 상영중인 영화의 목록을 출력해주고
- 예매할 수 있도록 유도하는 프로그램입니다.

## 기능 구현

1. 영화목록을 출력하고, 관람하고자 하는 영화를 입력받는다.
    
    - [x] 문구 : 예약할 영화를 선택하세요.
    - [x] 영화는 총 8개의 종류 
    - [x] 예외처리
        - [x] ~~1~Movies.size()의 값을 벗어나는 입력(잘못이해함)~~
        - [x] 입력한 값이 영화의 아이디 중 있어야 예약가능.
        - [x] Integer 타입이 아닌 형태의 입력
        - [x] 전체 플레이타임의 예약가능인원 합이 0인 경우 예매 불가능
    - [x] 선택한 영화를 출력한다.

2. 사용자에게 예매하고자 하는 시간대의 영화번호를 입력받는다.

    - [x] 문구 : 예약할 시간표를 선택하세요 (위에서부터 0번)
    - [x] 예외처리
        - [x] Integer 타입이 아닌 형태의 입력 
        - ~~범위는 1~Movie.getSchedule()~~
        - [x] 해당 영화의 해당 스케쥴이 0이 아니어야 한다.
    - [x] 영화의 예약가능인원이 0인 경우 안됨

3. 예약할 인원을 입력받는다.
    
    -[x] 문구 : 예약할 인원을 입력하세요.
    -[x] 예외처리
        -[x] Integer 타입이 아닌 경우
        -[x] 1~6 사이의 값이 아닌 경우 (어떤 영화든, 최대 예약 가능인원은 6명)
        -[x] 예약할 인원이 예약가능인원보다 큰 경우
 
4. 예약을 종료하고 결제를 진행하려면 1번을, 추가 예약을 진행하려면 2번을 입력받는다.

    -[x] 문구 : 예약을 종료하고 결제를 진행하려면 1번을, 추가 예약을 진행하려면 2번을 입력해주세요.
    -[x] 에러처리
        -[x] 1 또는 2의 값이 아닌 모든 경우
    -[x] 1번을 선택하는 경우, 현재까지 예약한 영화만을 가지고 5번으로 넘어간다.
    -[x] 2번을 선택하는 경우 다시 1번으로 돌아간다. (재 출력)

5. 1번을 선택하는 경우 예약하는 영화 및 플레이 타임을 보여주고, 결제로 넘어간다.

    - 문구 : 결제를 진행합니다 NEXT_LINE 
    - 출력
        - 예약하는 영화
        - 예약한 플레이 타임
        - 예약한 사람의 수
        
6. 2번을 입력하는 경우 다시, 1번항목으로 돌아간다
    
    - 예외처리
        - 추가적으로 영화를 예매하는 경우 기존의 영화타임과 1시간 이하의 차이가 나는 경우 

7. 결제를 진행하는 경우 포인트 사용유무를 물어보고, 금액을 입력받는다.

    - 문구 : 포인트 사용 금액을 입력하세요. 포인트가 없으면 0을 입력
    - 기능
        - 유저 생성시 초기 가입 포인트로 1000원 제공
        - 포인트도 함께 출력하기
    - 예외처리
        - 본인의 포인트보다 큰 값을 입력하는 경우
        - 마이너스 값을 입력하거나 Integer 타입이 아닌 값을 입력하는 경우
    
8. 신용카드와 현금 각기 다른 할인율이 적용됨으로 이를 고려해 총 결제금액을 계산한다.

    - 문구 : 신용카드는 1번, 현금은 2번을 입력해주세요.
    - 예외처리
        - 1 또는 2의 값이 아닌 모든 경우

9. 최종결제 금액을 출력하고 프로그램이 종료된다.

    - 문구 : 최종 결제한 금액은 Money 입니다. NEXT_LINE 즐거운 영화감상 되세요~
    - 최종 결제 금액 : (선택한 영화의 금액 * 예약명수 * 할인율) - 포인트