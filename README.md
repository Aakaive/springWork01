| 기능       | Method | URL                 | 요청            | 응답       |상태코드|
|----------|--------|---------------------|---------------|----------|------|
| 일정 등록    | POST   | /api/schedules      | RequestBody   | 등록 정보    |200|
| 일정 전체 조회 | GET    | /api/schedules      | RequestBody   | 다건 응답 정보 |200|
| 일정 조회    | GET    | /api/schedules/{id} | Request-Param | 단건 응답 정보 |200|
| 일정 수정    | PUT    | /api/schedules/{id} | Request-Param | id       |200|
| 일정 삭제    | DELETE | /api/schedules/{id} | Request-Param | id       |200|


