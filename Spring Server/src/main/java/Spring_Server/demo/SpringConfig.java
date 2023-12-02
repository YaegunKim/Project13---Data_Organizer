package Spring_Server.demo;

import Spring_Server.demo.aop.TimeTraceAop;
import Spring_Server.demo.repository.JdbcMemberRepository;
import Spring_Server.demo.repository.JdbcTemplateMemberRepository;
import Spring_Server.demo.repository.JpaMemberRepository;
import Spring_Server.demo.repository.MemberRepository;
import Spring_Server.demo.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }


    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}
