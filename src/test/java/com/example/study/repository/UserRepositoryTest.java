package com.example.study.repository;


import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
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
//    public void read(@RequestParam Long id){    //get에 대해 아이디 받고 그걸 리턴시키는 형태로 작성도 가능

    public void read(){    
        Optional<User> user= userRepository.findById(2L);
        //2L는 lonlong이고 옵셔널은 제너릭 타입으로 받게 됨.

        user.ifPresent(selectUser->{       //있을때만 실행에 대한 결과를 받겠다.
            //seleectUser가 있으면 그 값을 꺼내 달라는 뜻.
            System.out.println("user:"+selectUser);
            System.out.println("email:" + selectUser.getEmail());
        });
        //return user.get();

    }
    public void update(){

    }
    public void delete(){

    }
}
