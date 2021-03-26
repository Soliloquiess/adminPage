package com.example.study.model.entity;



import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@Entity //엔티티라는 거 정의
//@Table(name = "user")   //table을 유저라는 테이블을 가진 곳에 매핑시킬거다 선언
//근데 클래스의 이름이 동일하면 굳이 table 어노테이션을 설정 안해줘도 된다.
public class User { //이 클래스 이름은 디비의 이름과 동일하게(여기선 카멜 케이스에 맞게 선언)

    @Id//식별자에 대해선 Id를 붙이고
    @GeneratedValue(strategy = GenerationType.IDENTITY) //어떤식으로 관리할지 전략 설정
    private Long id;
//    @Column(name = "account")   이거도 마찬가지로 이름이 동일하면 안 써줘도 된다.
    private String account;
    private String email;
    private String phoneNumber;
    private LocalDate createdAt;
    private String createdBy;
    private LocalDate updatedAt;
    private String updatedBy;

    public User() { //이 부분은 에러나서 넣어줬다. Allargs넣으니까 에러나는데 ㅇㅅㅇ..

    }
}

//기본적으로 이 위까지가 mysql과 테이블 어떻게 할지 설정 완료