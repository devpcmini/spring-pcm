package pcm.springpcm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pcm.springpcm.repository.JdbcMemberRepository;
import pcm.springpcm.repository.JdbcTemplateMemberRepository;
import pcm.springpcm.repository.MemberRepository;
import pcm.springpcm.repository.MemoryMemberRepository;
import pcm.springpcm.service.MemberService;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    //스프링 빈에 올려놓기
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
