package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity //order_detail에 자동 연결
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime orderAt;

//    private Long userId;
//    private Long itemId;


    //N:1 orderdetail입장에서 자신은 N 상대는 1
    @ManyToOne
    private User user;  //user_id찾아감.
//객체이름 적어줘야 하이버네이트에서 알어서 유저네임찾아감.

    //자신은 N 상대는 1
    @ManyToOne
    private Item item;

}
