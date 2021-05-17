package jihoon.planner_web.repository;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jihoon.planner_web.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        //given
        Member member = new Member();
        member.setEmail("jihoon2723@naver.com");
        member.setName("이지훈");
        //when
        repository.save(member);
        //then
        Member result = repository.findById(member.getId()).get();
        Assertions.assertThat(result).isEqualTo(member);
    }

    @Test
    public void findByEmail() {
        //given
        Member member1 = new Member();
        member1.setEmail("naver.com");
        repository.save(member1);
        //when
        Member result = repository.findByEmail("naver.com").get();
        //then
        Assertions.assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findByName() {
        //given
        Member member2 = new Member();
        member2.setName("지훈이");
        repository.save(member2);
        //when
        Member result = repository.findByName("지훈이").get();
        //then
        Assertions.assertThat(result).isEqualTo(member2);
    }

    @Test
    public void findAll() {
        //given
        Member member1 = new Member();
        member1.setName("이지훈");
        member1.setEmail("jihoon");
        repository.save(member1);
        Member member2 = new Member();
        member2.setName("spring2");
        member2.setEmail("ljh");
        repository.save(member2);
        //when
        List<Member> result = repository.findAll(); //then
        Assertions.assertThat(result.size()).isEqualTo(2);

    }
}
