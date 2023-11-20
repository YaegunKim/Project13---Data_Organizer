package Spring_Server.demo.service;

import Spring_Server.demo.domain.Member;
import Spring_Server.demo.repository.MemberRepository;
import Spring_Server.demo.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void register() {
        //given
        Member member = new Member();
        member.setName("Yaegun");

        //when
        Long saveId = memberService.join(member);

        //then
        Member foundMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(foundMember.getName());
    }

    @Test
    public void duplicate_exception() {
        //given
        Member member1 = new Member();
        member1.setName("Yaegun");

        Member member2 = new Member();
        member2.setName("Yaegun");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("Member already Exists");
/*
        try{
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("Member already Exists");
        }
*/

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}