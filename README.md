## **1. 프로젝트 명**

“모모”

---

## **2. 프로젝트 개요**

> 커뮤니티 중심의 주식 모의 투자 시스템으로, 사용자가 직접 커뮤니티 방을 생성하고, 국내 주식 거래를 실시간으로 체험하며, 참가자들과의 소통과 전략 공유를 통해 투자 경험을 쌓을 수 있는 플랫폼
> 

### **핵심 기능**

1. **모의 주식 거래**
    - 국내 주식 실시간 시세를 반영한 가상 투자 시스템
    - 매수/매도, 포트폴리오 관리, 수익률 랭킹 제공
2. **커뮤니티 기반 방 생성**
    - 사용자가 커뮤니티(방)를 생성하여 참가자들과 함께 모의 투자
    - 방 별 초기 자금 설정, 공개/비공개 방 설정 가능
    - 방 내 랭킹 시스템, 포트폴리오 공개 여부 설정 가능
3. **피드 & 소통 기능**
    - 방 내 피드를 통해 참가자들이 투자 전략, 시장 이슈 등을 공유
    - ~~채팅 기능으로 실시간 소통 가능~~
4. **방 운영 시스템**
    - 시작일자 ~ 종료일자 설정으로 일정 기간 동안 모의 투자
    - 종료된 방은 기록으로 보존

---

## **3. 주제 선정 이유**

1. **기존 모의투자 시스템의 한계 극복**
    - 기존 모의투자 시스템에는 상시 참여가 가능한 형태도 있지만, 대부분은 단순 수익률 경쟁에 초점이 맞춰져 있어 사용자의 참여 동기 부여가 제한적임.
    - 특히, 개인 간의 소규모 경쟁이나 스터디형 투자가 어려워, 일부 사용자들은 엑셀과 같은 비공식적인 방법을 통해 소규모 투자 스터디를 진행하는 불편함을 겪고 있음.
    - 본 플랫폼은 사용자가 자유롭게 커뮤니티 방을 생성하고, 참가자들과 원하는 형태로 모의투자를 운영할 수 있는 유연한 환경을 제공하여 이러한 한계를 극복함.
2. **커뮤니티 중심의 전략 공유와 소통**
    - 기존 시스템이 제공하지 못하는 **커뮤니티 기능**을 통해 사용자는 피드, 댓글, 채팅 기능으로 실시간으로 소통하고, 투자 전략과 정보를 공유할 수 있음.
    - 방 내 피드를 통해 종목 분석, 투자 아이디어, 전략 검토 등을 자유롭게 공유할 수 있으며, 이를 통해 참가자들은 단순한 수익률 경쟁을 넘어 협업과 학습의 기회를 얻을 수 있음.
    - 순위 시스템을 통해 경쟁심을 자극하면서도, 커뮤니티를 통한 협업과 전략 공유가 가능.
    - 투자 학습과 전략 검증의 장으로 활용 가능하며, 단순 수익률 경쟁을 넘어 실전 감각을 키울 수 있는 환경 제공.
3. **다양한 활용 가능성**
    - 단순 수익률 경쟁 외에도 증권학회, 금융 동아리, 투자 스터디 등에서 학습 도구로 활용 가능.
    - 방 별로 공개/비공개 설정, 랭킹 숨김, 기간 설정 등 커스터마이징이 가능해 **투자 스터디**, **팀별 포트폴리오 관리**, **초보자 투자 연습** 등 다양한 목적에 맞춘 사용이 가능.
    - 특히 금융 교육 분야로 확장하여, 대학생, 취업 준비생 등을 대상으로 한 금융 교육 플랫폼으로도 활용 가능.

**💬 요약:***“단순 수익률 경쟁을 넘어, 투자 전략 공유, 협업, 그리고 학습을 지원하는 커뮤니티 기반 투자 플랫폼으로서 기존 모의투자 시스템의 한계를 극복합니다.”*

---

## **4. 비즈니스적 이점**

### **1. 신규 투자자 유입 (리드 생성 플랫폼)**

- 기존 모의투자 시스템은 개인이 혼자 시작해야 하는 부담이 커서 초보자들이 쉽게 접근하기 어려움
- 단순한 수익률 경쟁이 아니라, **전략 공유, 피드백, 커뮤니티를 통해 성장하는 투자 경험**을 제공하여 초보자들이 자연스럽게 시장에 적응할 수 있도록 유도
- 키움증권과의 연동을 통해 모의 투자 참가자들을 실거래 사용자로 전환할 수 있는 기회 창출

---

## **5. 전체 시스템 구조 (시스템 아키텍처)**

```
[사용자] ⇄ [프론트엔드(JSP/HTML/CSS)] ⇄ [백엔드(Java Servlet)] ⇄ [DB(Oracle, MyBatis 사용)]
                          ⇣
                   [실시간 시세 API] (한국투자증권 API)

```

### **1) 프론트엔드 (JSP/HTML/CSS)**

- 사용자 인터페이스(UI) 구현
- 피드, 실시간 주식 시세 데이터, 주식 거래 등 핵심 화면 구성
- 실시간 데이터 반영 (AJAX, WebSocket 활용 가능)

### **2) 백엔드 (Java Servlet)**

- 사용자 관리 (회원가입/로그인, 인증)
- 방 생성/참여, 거래 내역 관리, 포트폴리오 관리
- 피드/댓글 CRUD 기능
- 실시간 시세 반영 및 거래 처리 로직

### **3) 데이터베이스 (Oracle + MyBatis)**

- 사용자 정보, 방 정보, 거래 기록, 피드/댓글 저장
- 수익률 계산을 위한 포트폴리오 데이터 관리
- 방 생성/종료, 포기 등 운영 로그 관리

### **4) 외부 API 연동**

- 국내 주식 실시간 시세 제공 (한국투자증권 API 사용)
- 거래 제한 (장 운영시간 반영: 09:00~15:30)

---

## ERD

![주식 모의 투자 시스템.png](attachment:81d1063a-6745-4542-a6d0-b77919ce6418:64731f0d-7eb4-4d67-a526-16afb6862d07.png)
