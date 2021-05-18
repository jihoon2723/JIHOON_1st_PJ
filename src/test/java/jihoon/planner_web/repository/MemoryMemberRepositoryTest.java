//package jihoon.planner_web.repository;
//
//import jihoon.planner_web.domain.MemberInfo;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//class MemoryMemberRepositoryTest {
//
//    MemoryMemberRepository repository = new MemoryMemberRepository();
//
//    @AfterEach
//    public void afterEach() {
//        repository.clearStore();
//    }
//
//    @Test
//    public void save() {
//        //given
//        MemberInfo member = new MemberInfo();
//        member.setEmail("jihoon2723@naver.com");
//        member.setName("이지훈");
//        //when
//        repository.save(member);
//        //then
//        MemberInfo result = repository.findById(member.getId()).get();
//        Assertions.assertThat(result).isEqualTo(member);
//    }
//
//    @Test
//    public void findByEmail() {
//        //given
//        MemberInfo member1 = new MemberInfo();
//        member1.setEmail("naver.com");
//        repository.save(member1);
//        //when
//        MemberInfo result = repository.findByEmail("naver.com").get();
//        //then
//        Assertions.assertThat(result).isEqualTo(member1);
//    }
//
//    @Test
//    public void findByName() {
//        //given
//        MemberInfo member2 = new MemberInfo();
//        member2.setName("지훈이");
//        repository.save(member2);
//        //when
//        MemberInfo result = repository.findByName("지훈이").get();
//        //then
//        Assertions.assertThat(result).isEqualTo(member2);
//    }
//
//    @Test
//    public void findAll() {
//        //given
//        MemberInfo member1 = new MemberInfo();
//        member1.setName("이지훈");
//        member1.setEmail("jihoon");
//        repository.save(member1);
//        MemberInfo member2 = new MemberInfo();
//        member2.setName("spring2");
//        member2.setEmail("ljh");
//        repository.save(member2);
//        //when
//        List<MemberInfo> result = repository.findAll(); //then
//        Assertions.assertThat(result.size()).isEqualTo(2);
//
//    }
//}
