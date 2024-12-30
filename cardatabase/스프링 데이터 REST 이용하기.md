> 스프링 데이터 REST 이용하기.md

# 스프링 데이터 REST 이용하기
- 스프링 데이터 REST서비스는 모든 CRUD 작업을 제공한다.

HTTP방식 | CRUD
---|---
GET | 읽기(Read)
POST | 생성(Create)
PUT/PATCH | 업데이트(Update)
DELETE | 삭제(Delete)

## 삭제
- 자동차를 삭제하려면 DELETE방식을 이용해 삭제될 자동차의 링크 (http:// localhost:8080/cars/{id}를 지정한다. HTTP방식을 DELETE로 선택하고 요청 URL를 입력한 다음 Send버튼을 클릭하면 된다.
- 작업이 정상적으로 수행되면 포스트맨에 204 No Content 응답이 표시된다. 삭제 요청을 수행이 정상적으로 진행 됐다는 걸 알 수 있습니다.

## 생성
- 데이터베이스에 새 자동차를 추가하려면 POST방식과 요청 URL로 http://localhost:8080/cars를 이용해야 한다. 헤더에는 값이 application/json인 Content-Type필드가 있어야 하며, 새 car객체를 JSON형식의 요청 본문에 포함한다.
- 포스트맨에서 Body탭을 클릭하고 raw를 선택하면 Body탭에 새 자동차의 JSON문자열을 입력할 수 있다.
- 또한 포스트맨에서 Headers탭을 클릭하고 헤더를 설정해야 한다.
- POST 요청은 새로 생성된 car객체를 다시 보내며, 정상적으로 수행되면 응답 상태가 201 Created로 표시된다.

## 업데이트
- 엔티티를 업데이트하려면 PATCH방식과 업데이트하려는 자동차의 링크(http://localhost:8080/cars/{id}를 이용한다. 헤더에는 값이 application/json인 Content-Type 필드가 있어야 하며, 데이터가 편집된 car객체를 요청 본문에 지정한다. PATCH요청을 수행하려면 업데이트된 필드만 보내야 한다. PUT요청을 수행하려면 요청 본문에 모든 필드를 포함해야 한다.
- 업데이트가 수행되면 응답 상태는 200 OK가 된다.















