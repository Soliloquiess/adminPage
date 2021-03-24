package com.example.study.controller;


import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController //컨트롤러라고 활용할거라는 지시어
@RequestMapping("/api") //api 주소 매핑하기 위해 리퀘스트 매핑 사용
//localhost:8080/api
public class GetController {

    @RequestMapping(method= RequestMethod.GET, path = "/getMethod") //localhost:8080/api/getMethod
    public String getRequest(){ //()안에 파라미터 넣는다.
        return "Hi getMethod";
    }
    @GetMapping("/getParameter")    //주소지정 localhost:8080/api/getParameter라는 곳에 매핑이 된다.
    //localhost:8080/api/getParameter?id=1234&pasword=abcd
    //아이디와 패스워드 넘기기 위해 스프링에서는 RequestParam이란 걸 넘기게 된다.

    //localhost:8080/api/getMultiParameter?account=abcd&email=study@gmail.com&page=10
    public String getParameter(@RequestParam String id, @RequestParam(name ="password") String pwd){

        String password ="bbbb";
        System.out.println("id:" + id);
        System.out.println("pw:" + password);

        return id+password;
    }

    @GetMapping("getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam){
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());


        //보통 json 형태로 데이터 통신.(스프링에서 json 객체를 내부적으로 내장하고 있다.)
        //{"account":"","email":"","page":0}
        return searchParam;
    }
}
