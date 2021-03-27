package com.example.study.repository;


import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import com.example.study.model.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends StudyApplicationTests {

    @Autowired//DI로 Dependency Inㅓection으로 우선순위 주입을 뜻한다. 직접 객체를 만들지 않고(new) 스프링이 직접 관리하겠다는 뜻.
    private UserRepository userRepository;

    @Test
    public void create(){
        //String sql = insert into user(%s,%s,%d) value (account, email, age);
        User user = new User();//싱글톤으로 User는 매번 다른 값이 들어갈 수 있어 매번 생성하고 사용해야
        user.setAccount("TestUser03");
        user.setEmail("TestUser03@gmail.com");
        user.setPhoneNumber("010-3333-3333");
        user.setCreatedAt(LocalDate.now());
        user.setCreatedBy("testUser3");
        //데이터 들어갈 타입 맞춰서 컬럼으로 생성

        User  newUser = userRepository.save(user);
        System.out.println("newUser:"+newUser);
    }
    @Test
    @Transactional
//    public void read(@RequestParam Long id){    //get에 대해 아이디 받고 그걸 리턴시키는 형태로 작성도 가능

    public void read(){
        Optional<User> user= userRepository.findById(7L);
        //2L는 lonlong이고 옵셔널은 제너릭 타입으로 받게 됨.

        user.ifPresent(selectUser->{       //있을때만 실행에 대한 결과를 받겠다.

            selectUser.getOrderDetailList().stream().forEach(detail->{
                Item item = detail.getItem();
                System.out.println(detail.getItem());
            });

            //seleectUser가 있으면 그 값을 꺼내 달라는 뜻.
//            System.out.println("user:"+selectUser);
//            System.out.println("email:" + selectUser.getEmail());
        });
        //return user.get();

    }

    @Test
    public void update(){
        Optional<User> user= userRepository.findById(2L);   //2번 셀렉트
        //2L는 lonlong이고 옵셔널은 제너릭 타입으로 받게 됨.

        user.ifPresent(selectUser->{
           selectUser.setAccount("PPPP");
           selectUser.setUpdatedAt(LocalDate.now());
           selectUser.setUpdatedBy("update Method");
           //값은 이거만 바꿨지만  jpa에서는 셀렉트유저값에 들어있는 특정 아이디값을 검색하고 한번더 꺼낸 다음
            //한번 더 업데이트 쳐줌.

           userRepository.save(selectUser);
           //쿼리문 통해 특정 유저 셀렉트 해주고 아이디를 한번 더 셀렉트 값 변경되서 값 찾고 그 값에 대해 업데이트 시킴.
        });
    }
//    @RequestMapping("/api/user")    //딜리트도 매핑해줘야한다.(근데 일단은 지우고)
    @Test
    @Transactional  //마지막 데이터 남으면 그거에 대한 동작은 안 일어남.(아예 비면 그건 데이터베이스의 의미가 없어서)
    public void delete(){
        Optional<User> user= userRepository.findById(3L);   //2번 셀렉트
        //2L는 lonlong이고 옵셔널은 제너릭 타입으로 받게 됨.

        Assert.assertTrue(user.isPresent()); // 반드시 값이 있는 값 통과해서

        user.ifPresent(selectUser->{
            userRepository.delete(selectUser);
        });

        //이제 유저가 진짜 삭제 됐는지 확인해보자,(딜리트 된 유저 삭제 되었는지 확인)
        Optional<User> deleteUser = userRepository.findById(1L);

        Assert.assertFalse(deleteUser.isPresent()); //false 그값이 삭제해서 반드시 false가 된다
//테스트 코드 쓰려면 Assert 사용하는게 더 좋다.
        //        if(deleteUser.isPresent()){
//            System.out.println("데이터 존재: "+ deleteUser.get());
//        }else{
//            System.out.println("데이터 삭제 데이터 없음. ");
//
//        }
    }
}
