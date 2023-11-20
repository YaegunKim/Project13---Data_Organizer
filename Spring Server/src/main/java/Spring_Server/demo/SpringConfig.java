package Spring_Server.demo;

import Spring_Server.demo.repository.MemberRepository;
import Spring_Server.demo.repository.MemoryMemberRepository;
import Spring_Server.demo.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
