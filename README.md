# 🎈 ***TO-DO PROJECT***

## 🔊 프로젝트 소개
오늘의 할일을 간단히 작성하여 등록하는 TO-DO 프로젝트입니다.

## 🎨 Dependencies
- *Spring Web*
- *Spring Security*
- *Spring Data JPA*
- *Mustache*
- *MySQL Driver*
- *Lombok*


## 💻 개발환경
- **Version** : Java 17
- **IDE** : IntelliJ
- **Framework** : SpringBoot 3.4.3
- **Database** : MySQL 8.0

## 📖 파일 구조
    ToDoList/
    ├── controller/
    │   ├──TaskController : TO-DO 등록/삭제/편집 컨트롤러 (REST API)
    │   └── ViewController : 화면뷰 컨트롤러
    ├── dto/
    │   └── TaskDto : TO-DO DTO
    ├── entity/
    │   └── Task : TO-DO Entity
    ├── repository/
    │   └── TaskRepository : TO-DO Repository
    ├── service/
    │   └── TaskService : TO-DO 서비스 계층
    └── ToDoProjectApplication


## 📺 주요 기능
![image](https://github.com/user-attachments/assets/6bd72340-a525-4326-96f7-62fe2a63b1bc)

<details>
    <summary>TO-DO 등록</summary>

![Post](https://github.com/user-attachments/assets/59497b50-ab4f-4db0-8c19-2721ffc91c85)

- 입력창에 TO-DO를 입력후 엔터를 누르면 등록
- 화면이 새로고침 되면서 갱신
</details>

<details>
    <summary>TO-DO 수정</summary>

![Edit](https://github.com/user-attachments/assets/4c0a6992-c317-4601-8910-62fefbd02bdd)

- TO-DO 리스트 오른쪽 펜 버튼을 클릭
- 열린 Modal 창에서 TO-DO 수정 후, 수정 버튼 클릭
- 새로고침 없이 리스트에 반영
</details>

<details>
    <summary>TO-DO 삭제</summary>

![Delete](https://github.com/user-attachments/assets/960c6785-8ce2-4f56-979d-72db4c8dd2da)

- TO-DO 리스트 오른쪽 X 버튼을 클릭
- 새로고침 없이 리스트에서 제거
</details>

<details>
    <summary>TO-DO Checked 삭제</summary>

![CheckBox](https://github.com/user-attachments/assets/232f5e40-4868-4cd2-bd98-bb7153c4469a)

- TO-DO 리스트 왼쪽 체크박스를 클릭
- 아래 박스가 열리며 몇개가 선택 되었는지 보여줌
- 아래 박스의 휴지통 버튼을 누르면 새로고침 없이 리스트에서 제거
</details>

## ✏ 후기
조금 잊어버린 스프링부트의 감각을 되살리기 위해서 간단한 미니 프로젝트 였다. 하지만 개발하면서 조금 욕심이 생긴
나머지 애니메이션을 한번 넣어보자고 생각하여 애니메이션만 찾는데 반나절을 넘게 써버린 것 같다.  

아쉬운 점이 있다면 TO-DO를 등록한 후 무조건 웹을 새로고침 하는점..  
새로고침 없이 리스트를 추가하는 방식을 해보았지만 체크박스의 이벤트가 걸리지 않아서 새로고침 하는 방향으로 하게 되었다.

## 🏷 출처
- [CSS Animation](https://animista.net/play/basic/scale-up/scale-up-ver-top)
- [HTML/CSS 템플릿](https://www.callicoder.com/spring-boot-mongodb-angular-js-rest-api-tutorial/)


