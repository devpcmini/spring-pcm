package pcm.springpcm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pcm.springpcm.service.MemberService;

@Controller
public class MemberController {

    private final MemberService memberService;
    //Dependency injection
    //컴포넌트 스캔 방식
    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }


}
