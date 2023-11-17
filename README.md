# DDD 도메인 주도 개발론 적용 프로젝트

## 개요
- DDD 이론만을 공부하는 것이 아닌 실제 프로젝트에 적용해보는 것이 목적입니다.

## 프로젝트 구성
- Kotlin
- Spring Boot
- Spring Data JPA
- Spring Security
- H2 Database

## 프로젝트 구조
- `ddd.ui` : 표현 영역
- `ddd.domain` : 도메인 영역
- `ddd.application` : 응용 영역
- `ddd.infrastructure` : 구현 기술 영역

## 도메인
- 회원 (Member)
- 상품 (Product)
- 주문 (Order)
- 결제 (Payment)
- 지갑 (Wallet)

## 패키지 구조
```agsl
payment
├── command
│   ├── application
│   └── domain
├── infra
├── query
│   ├── application
│   └── dto
└── ui
```

- command : 명령을 처리하는 패키지 (CQRS)
- infra : 인프라스트럭처 패키지
- query : 조회를 처리하는 패키지 (CQRS)
- ui : 표현 영역 패키지