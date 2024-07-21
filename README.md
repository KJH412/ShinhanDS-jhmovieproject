## 프로젝트 소개
JSP와 Servlet을 이용한 MVC 패턴 프로젝트 - 영화 예매 서비스 

### :calendar: 기간
2024.04.08 ~ 2024.04.12  약 1주

### 주요 기능
- 영화 검색
- 영화 예매/취소
- 영화 즐겨찾기/삭제
- 로그인/회원가입
- 회원 정보 수정

### 개발 환경
- HTML5, CSS3, Javascript, jQuery
- Servlet/JSP
- Oracle 11.2.0.2.0
- Apache Tomcat-9.0.87
### TOOL 
- Eclipse IDE 4.30.0
- SQL Developer

### ERD
<img width="773" alt="영화예매서비스DB설계" src="https://github.com/user-attachments/assets/ed2a1d08-ce96-4dc0-951f-cd35333024d6">

### 시스템 구조
<img width="630" alt="영화예매서비스DB설계2" src="https://github.com/user-attachments/assets/9dc8d901-83ea-4cf3-908c-265204748a2a">

## :mag:구현 결과
### 로그인/회원가입
회원가입을 할 때 아이디 중복 체크로 확인할 수 있으며, 로그인 시 비밀번호가 맞지 않거나 해당 아이디가 존재하지 않으면 안내 문구가 나타납니다.

![GIFMaker_me (1)](https://github.com/user-attachments/assets/92e1b26e-89b5-4705-bdf7-db57dd5d8b10)
![GIFMaker_me (2)](https://github.com/user-attachments/assets/6e412a70-da82-4928-97e8-66b3a6eb2939)

### 1.메인페이지
메인 배너와 본문의 슬라이드를 Slick-Slider를 사용해 구현했습니다.
![GIFMaker_me](https://github.com/user-attachments/assets/844c894d-3068-4b7d-8f50-d0d11e3d8599)

### 2.영화 목록
- 보고 싶은 영화 포스터 밑에 별 모양 아이콘을 클릭하면 즐겨찾기에 추가 할 수 있고 로그인하지 않은 상태에서는 불가능합니다.
- 검색창에 영화 제목을 검색하면 검색된 영화만 목록에 나타납니다.
![그림5](https://github.com/user-attachments/assets/8f41623e-1a2e-46c7-bb05-dffe835c0328)

### 4.영화 예매
- 영화를 고르면 보여지는 영화 포스터가 선택한 영화에 맞게 변경됩니다.
- 좌석을 선택하지 않으면 안내창이 나타나고 예매가 진행되지 않습니다.
![그림4](https://github.com/user-attachments/assets/d782b9b8-2e07-40ca-9b28-313b69723383)

### 3.마이페이지
- 로그인한 회원의 정보를 확인할 수 있습니다.
- 예매한 영화 정보를 확인할 수 있고 예매를 취소할 수 있습니다.
- 즐겨찾기한 영화를 확인할 수 있고 즐겨찾기 목록에서 삭제할 수 있습니다.
- 버튼을 통해 로그아웃할 수 있습니다.
![그림7](https://github.com/user-attachments/assets/b84396d5-482f-46b3-9bfe-1d07fc3f6efd)



### 아쉬운점
- 메인 페이지에서 최신 및 인기 영화 목록을 정렬하여 나타내고 싶었지만 시간이 부족해 적용하지 못했습니다.
- 영화 정보에 대한 데이터를 OPEN API를 사용하여 구현하고 싶었지만 직접 데이터를 넣어 사용했습니다.
- 프로필 사진 등록 기능을 넣고 싶었지만 구현하지 못했습니다.
 
