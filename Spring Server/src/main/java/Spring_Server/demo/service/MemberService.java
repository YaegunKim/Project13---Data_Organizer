package Spring_Server.demo.service;

import Spring_Server.demo.domain.Member;
import Spring_Server.demo.repository.MemberRepository;
import Spring_Server.demo.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * register
     */
    public Long join(Member member){
        validateDuplicateMember();
        memberRepository.save(member);
        return member.getId();;
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
                throw new IllegalStateException("Member already Exists");
            });
    }

    /**
     * lookup member list
     * @return
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
