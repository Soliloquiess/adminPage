package com.example.study.repository;


import com.example.study.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>  {  //넣는 카테고리는 생성한 모델 하위의 엔티티 아래 카테고리 넣어줘야 한다(반드시)

}
