package com.example.study.model.entity;



import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor//기본생성자.
@Entity //엔티티라는 거 정의
@ToString(exclude = {"orderGroup"}) //해당 변수와 이름 매칭되면  롬복이 해당 유저클래스에 대해 투스트링 할때 오더그룹 제외하겠다는 뜻.
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain=true)
//@Table(name = "user")   //table을 유저라는 테이블을 가진 곳에 매핑시킬거다 선언
//근데 클래스의 이름이 동일하면 굳이 table 어노테이션을 설정 안해줘도 된다.
public class User { //이 클래스 이름은 디비의 이름과 동일하게(여기선 카멜 케이스에 맞게 선언)

    @Id//식별자에 대해선 Id를 붙이고
    @GeneratedValue(strategy = GenerationType.IDENTITY) //어떤식으로 관리할지 전략 설정
    private Long id;
    private String account;
    private String password;

    @Enumerated(EnumType.STRING)
    private String status;  //Registered/ unRegistered/ waiting
    private String email;
    private String phoneNumber;
    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;
    @CreatedDate
    private LocalDateTime createdAt;
    @CreatedBy
    private String createdBy;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @LastModifiedBy
    private String updatedBy;

    //user 1:N orderGroup   이렇게 상호참조 하면 롬복에서 투스트링 하면서 서로 계속 찍기때문에 오버플로우가 나서 반드시 exclude시켜야 한다.
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<OrderGroup> orderGroupList;    //one to manyf라 리스트 타입으로 받음.
}

//기본적으로 이 위까지가 mysql과 테이블 어떻게 할지 설정 완료