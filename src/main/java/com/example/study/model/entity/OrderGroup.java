package com.example.study.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ToString(exclude = {"user", "orderDetailList"})   //유저는 tostring에서 제외해달라 사실 한쪽만 하면 상관이 없지만 공평성을 위해 해줬다.
@EntityListeners(AuditingEntityListener.class)
 public class  OrderGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private String orderType;   //주문의 형태-일괄/개별
    private String revAddress;
    private String revName;
    private String paymentType;


    private BigDecimal totalPrice;
    private Integer totalQuantity;

    private LocalDateTime orderAt;
    private LocalDateTime arrivalDate;

    @CreatedDate
    private LocalDateTime createdAt;
    @CreatedBy
    private String createdBy;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @LastModifiedBy
    private String updatedBy;

    //OrderGroup N: 1 User
    @ManyToOne
    private User user;//유저.자바에 있는 mappedBy와 일치해야함.
    // private Long userId; 으로 관리하던걸 객체로 관리하겠다는 뜻.

    //OrderGroup 1:N OrderDetail
    @OneToMany(fetch =  FetchType.LAZY,mappedBy = "orderGroup")
    private List<OrderDetail> orderDetailList;

}
