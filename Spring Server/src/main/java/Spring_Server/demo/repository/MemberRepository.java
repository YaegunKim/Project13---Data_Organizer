package Spring_Server.demo.repository;

import Spring_Server.demo.domain.Member;
import org.springframework.beans.factory.config.RuntimeBeanReference;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
