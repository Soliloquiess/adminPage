package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ItemRepositroyTest extends StudyApplicationTests {
    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create(){
      Item item = new Item();
      item.setName("노트북2");
      item.setPrice(200000);
      item.setContent("삼성 노트북2");

      Item newItem = itemRepository.save(item);
        Assert.assertNotNull(newItem);
    }

    @Test
    public void read(){
        Long id = 1L;

        Optional<Item> item = itemRepository.findById(id);

        Assert.assertTrue(item.isPresent());
//                item.ifPresent(i->{
//            System.out.println(i);
//        });
    }
}
