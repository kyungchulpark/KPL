KPL 홈페이지 

기존 PHP 버전 호스팅 -> JAVA/Spring Boot로 리메이크 및 서버 (클라우드) 임대 

하루 트래픽 500MB 언더였는데 리소스 관리 필요. 변경시 증가 가능성 있음




-----------



* 회원 권한

 1) 일반 사용자
 2) 구단주
 3) 리그 관리자
 4) ADMIN 슈퍼계정


---------------------



* 메뉴구성 및 권한

1) About KPL (모든 사용자)
   - 리그 연혁 
   - Open Talk 참여 등 
   - 1 Page 로 구성할 것

2) League
   a. Regular League (모든 사용자)
     - 리그 일정
     - 리그 순위
     - 경기 결과 입력
     - 종료된 리그
     - 리그 수상자 확인
 
   b. Event League (모든 사용자)
     - Draft League 일정

4) Teams 
   - Team 목록 (모든 사용자)
   - Team 관리 (구단주)

5) Players
   - 선수 등록 (모든 사용자)
   - 선수 기록 확인 (모든 사용자)
   - FA 등록 (모든 사용자)

6) Management (구단주)
  - 리그 생성/삭제 관리
  - 리그 일정표 등록
  - 경기결과 리셋, 기권승 처리 (리그 결과 처리)



----------------------

리그 관련 프로세스 정리 

1) 리그 생성
  - 리그 관리자는 2024 1st, 2nd, 3rd 등 새로운 리그를 생성할 수 있다.
  - 리그 생성 시 각종 화면에 보여지는 deafult 리그(기준 리그)는 마지막으로 생성된 리그를 기준으로 한다.

2) 리그 일정 등록
  - 리그 관리자는 리그 일정을 등록할 수 있다.
  - 엑셀 파일 업로드 시 이를 읽어서 처리한다,
  - 엑셀파일 형식
    [경기 일자, 홈팀, 어웨이팀, 시작시간]

  - 엑셀파일 업로드 되면 백단에서는 자동으로 경기마다 ID를 부여하고, 경기 결과 업로드가 되었는지 확인하는 Flag 변수 지정
  


경기 관련 프로세스 정리

1) 리그 참여자들은 리그 일정을 확인하고, 각 시간에 맞추어 경기를 진행한다
2) 경기 진행 이후에는 '승리팀'에서 경기결과를 입력한다.
3) 경기결과 입력시 반드시 홈팀/어웨팀 유투브 URL 을 입력하게 하고, 이미 입력된 경기 결과는 스케쥴표에서 바로 보여야 한다. 또한 결과가 입력된 경기는 홈/어웨이측 유투브 링크 버튼을 제공해야 한다.
4) 순위확인은 리그 순위 메뉴에서 확인하며 다음 항목들을 확인해야 한다
  - 순위
  - 팀이름
  - 경기수
  - 승수
  - 패배수
  - 승률
  - 승점
  - 평균득점
  - 평균실점
  - 마진
  - 최근 5경기 결과
  
  승점은 승리시 2점, 패배시 1점이며 관리자에 의해 몰수처리 된다면 패배팀에 0점을 준다.
  
 
