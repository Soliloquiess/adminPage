package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(exclude = {"user","item"})   //tostring에서 이 2가지 제외 이러면 상호참조 하던게 풀린다.
//롬복쓰면 투스트링 자동 만들어줘서 그부분에 orderdetail과 user가 상호참조해서 투스트링 계속해서 오버플로 생김
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime orderAt;
    //N:1
    @ManyToOne
    private User user; //user_id
    //N:1
    @ManyToOne
    private Item item;
//    private Long userId;
//    private Long itemId;

}
