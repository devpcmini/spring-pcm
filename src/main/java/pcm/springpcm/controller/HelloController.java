package pcm.springpcm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        return "hello";
    }

    //required default 값은 true false이면서 RequestParam을 입력안할경우 null
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false) String name,
                           Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //http에서 header,body 중 body에 데이터를 직접 넣어주겠다.
    public String helloString(@RequestParam("name") String name){
        //웹 브라우저 -> 내장 톰켓 서버 -> 스프링 컨테이너 -> viewResolver -> HTML 변환 후 웹 브라우저
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        //웹 브라우저 -> 내장 톰켓 서버 -> 스프링 컨테이너 -> HttpMessageConverter -> 웹 브라우저
        //HttpMessageConverter = JsonConverter , StringConverter
        //기본 문자처리 : StringHttpMessageConverter
        //기본 객체처리 : MappingJackson2HttpMessageConverter
        //byte 처리 등등 기타 여러 HttpMessageConverter가 기본으로 등록되어 있음
        Hello hello = new Hello();
        hello.setName(name);
        return hello; //JSON 방식으로 return
    }

    //객체 생성
    static class Hello{
        private String name;

        //프로퍼티 접근 방식
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
