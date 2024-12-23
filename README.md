### 프로젝트 구조

- api (최상위 모듈 domain, common 사용)
  - rest
    - model
    - mapper (domain model -> api model)
    - request
    - response
  - graphql
    - type
    - query
    - mutation
    - mapper (domain model -> api model)
    - input
    - dataloader
- batch (배치 모듈 domain, common 사용) # todo 설계 필요
- domain (비지니스 로직 및 DB 작업)
  - app (Facade)
  - domain (비지니스 로직)
    - exception
    - model
    - service
  - infrastructure (DB 작업)
    - entity
    - repository
    - mapper (entity -> domain model)
    - reader (read 작업만)
    - store (insert, update, delete 작업만)
- common (모든 패키지에서 사용하는 공통 모듈)
- external (외부 서비스 모듈)