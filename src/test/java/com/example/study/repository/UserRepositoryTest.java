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
        String account="Test01";
        String password="Test01";
        String status="REGISTERED";
        String email="Test01@gmail.com";
        String phoneNumber="010-1111-2222";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
        user.setCreatedAt(createdAt);
        user.setCreatedBy(createdBy);

        User newUser = userRepository.save(user);
        Assert.assertNotNull(newUser);



    }


    @Test
    @Transactional
//    public void read(@RequestParam Long id){    //get에 대해 아이디 받고 그걸 리턴시키는 형태로 작성도 가능
    public void read(){
        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");
        //User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2221");
        //번호가 없으면 널이 들어옴. 근데 반드시 들어와야하기 때문에 Assert 사용 번호 없으면 에러 발생.
        if(user!=null){
        user.getOrderGroupList().stream().forEach(orderGroup -> {
                System.out.println("주문묶음");
                System.out.println("수령인:" + orderGroup.getRevName());
                System.out.println("수령지: " + orderGroup.getRevAddress());
                System.out.println("총금액:" + orderGroup.getTotalPrice());
                System.out.println("총수량:" + orderGroup.getTotalQuantity());

                System.out.println("--------------주문상세--------------");

                orderGroup.getOrderDetailList().forEach(orderDetail -> {
                    System.out.println("주문상태" + orderDetail.getStatus());
                    System.out.println("도착일자" + orderDetail.getArrivalDate());
                });


             });
        }
        Assert.assertNotNull(user);
    } 

    @Test
    public void update(){
        Optional<User> user= userRepository.findById(2L);   //2번 셀렉트
        //2L는 lonlong이고 옵셔널은 제너릭 타입으로 받게 됨.

        user.ifPresent(selectUser->{
           selectUser.setAccount("PPPP");
           selectUser.setUpdatedAt(LocalDateTime.now());
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
