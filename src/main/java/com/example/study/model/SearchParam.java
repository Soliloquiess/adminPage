package com.example.study.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data   //게터세터,생성자 바로 생성하게 해주는 롬복.
@AllArgsConstructor //이건 모든 매개변수 가진 생성자를 만들어준다.
public class SearchParam {
    private String account;
    private String email;
    private int page;


}
