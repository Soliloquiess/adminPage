package com.example.study.controller;


import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController //컨트롤러라고 활용할거라는 지시어
@RequestMapping("/api") //api 주소 매핑하기 위해 리퀘스트 매핑 사용
public class PostController {
    //HTML <FORM>,
    //ajax 검색
    //http post body ->data 집어 넣어서 보내겠다.
    // json, xml , multipart-form / text-plain 같이 여러 형태로 올릴 수 있다.


    @PostMapping(value = "/postMethod")
    public SearchParam postMethod(@RequestBody SearchParam searchParam){
        //RequestBody에 SearchParam searchParam 이런 값들을 매칭시켜 주세요라는 뜻.
        return searchParam;
    }

    //근데 PutMapping patchMapping 잘 안쓴다고는 아는데 자세한 건 후에 배울듯.
    @PutMapping("/putMethod")
    public void put(){
    }

    @PatchMapping("/patchMethod")
    public void patch(){

    }
}



