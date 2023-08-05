package pcm.springpcm;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pcm.springpcm.repository.MemberRepository;
import pcm.springpcm.repository.MemoryMemberRepository;
import pcm.springpcm.service.MemberService;

@Configuration
public class SpringConfig {
    //스프링 빈에 올려놓기
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
