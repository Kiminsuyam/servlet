package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemberRepositoryTest { //test는 public없어도 된다.

    MemberRepository memberRepository = MemberRepository.getInstance(); //new로 하면 안된다. 싱글톤이기 떄문에

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();        //테스트 끝날 때 마다 초기화
    }

    @Test
    void save() {
        //given ->이런 게 주어 줬을 때.
        Member member = new Member("hello", 20);

        //when  ->이런 걸 실행 했을 때.
        Member savedMember = memberRepository.save(member);

        //then  -> 결과가 이 것이여야 되.
        Member findMember = memberRepository.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember);
    }

    @Test // 모든 것을 조회하는 테스트.
    void findAll() {
        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);
        //얘들을 미리 저장
        memberRepository.save(member1);
        memberRepository.save(member2);

        //when
        List<Member> result = memberRepository.findAll();
        //then
        assertThat(result.size()).isEqualTo(2); //Assertions -> Option + Enter ->import
        assertThat(result).contains(member1,member2); //result안에 데이터가 있는지 확인

    }
}
