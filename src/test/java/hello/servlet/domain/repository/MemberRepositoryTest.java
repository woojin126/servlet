package hello.servlet.domain.repository;

import hello.servlet.domain.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

//컨트롤 쉬프트 T 자동테스트 클래스생성
class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach //테스트끝나면 깔끔히 초기화
    void afterEach(){
        memberRepository.clearStore(); //순서보장위해 save먼저 실행되면 저장이 3개가됨
    }

    @Test
    void save(){
        //given 주어졌을시
        Member member = new Member("hello", 20);
        //when 실행했을시
        Member saveMember = memberRepository.save(member);
        //then 결과값
        Member findMember = memberRepository.findById(saveMember.getId());
        assertThat(findMember).isEqualTo(saveMember);
    }

    @Test
    void findAll(){
        //given
        Member member1 = new Member("member1",20);
        Member member2 = new Member("member2",30);

        memberRepository.save(member1);
        memberRepository.save(member2);
        //when

        List<Member> result = memberRepository.findAll();

        //then

        Assertions.assertThat(result.size()).isEqualTo(2);
        Assertions.assertThat(result).contains(member1,member2); //member1 ,member2 을 가지고있는가


    }
}