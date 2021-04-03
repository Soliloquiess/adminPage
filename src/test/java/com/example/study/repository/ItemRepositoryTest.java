package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class ItemRepositoryTest extends StudyApplicationTests {
    @Autowired
    private  ItemRepository itemRepository;

    @Test
    public void create(){
        Item item = new Item();
        item.setStatus("미등록");
        item.setName("샘숭");
        item.setTitle("삼성");
        item.setContent("2019");
        item.setPrice(90000);
        item.setBrandName("샘성");
        item.setRegisteredAt(LocalDateTime.now());
        item.setCreatedAt(LocalDateTime.now());
        item.setCreatedBy("partner01");
        item.setPartnerId(1L);


        Item newItem = itemRepository.save(item);
        Assert.assertNotNull(newItem);
    }

    @Test
    public void read(){
        Long id = 1L;

        Optional <Item> item = itemRepository.findById(id);

        Assert.assertTrue(item.isPresent());

        //        item.ifPresent(i->{
//            System.out.println(i);
//        });
    }
}
