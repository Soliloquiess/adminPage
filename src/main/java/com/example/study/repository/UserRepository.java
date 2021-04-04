package com.example.study.repository;

import com.example.study.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findFirstByPhoneNumberOrderByIdDesc(String phoneNumber);

}



//@Repository //레파지토리라고 선언하는 어노테이션
//public interface UserRepository extends JpaRepository<User,Long> { //JPA의 레파지토리 상속
//    //어떠한 타입의 클래스가 들어갈지 제네릭으로 넘겨주고 두번쨰는 기본키에 대해 어떤키인지 선언.
//    //user라는 값의 아이디가 Long이라 Long을 넣어주는 것.
//    //그리고 이렇게 선언된 레파지토리로 CRUD를 할 수 있다.
//
//    User findFirstByPhoneNumberOrderByIdDesc(String phoneNumber);
//}
