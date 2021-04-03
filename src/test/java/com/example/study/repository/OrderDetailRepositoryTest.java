package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderDetailRepositoryTest extends StudyApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void create(){

        OrderDetail orderDetail = new OrderDetail();


        orderDetail.setStatus("Waiting");
        orderDetail.setArrivalDate(LocalDateTime.now().plusDays(2));    //현재 날짜부터 2일이 더해짐

        orderDetail.setQuantity(1);
        orderDetail.setTotalPrice(BigDecimal.valueOf(90000));

        orderDetail.setOrderGroupId(7L);
         orderDetail.setItemId(1L);

         orderDetail.setCreatedAt(LocalDateTime.now());
         orderDetail.setCreatedBy("adminServer");

        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
        Assert.assertNotNull(newOrderDetail);
    }
}
