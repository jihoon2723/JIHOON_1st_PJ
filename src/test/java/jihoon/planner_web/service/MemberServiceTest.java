//package jihoon.planner_web.service;
//
//import jihoon.planner_web.domain.MemberInfo;
//import jihoon.planner_web.repository.MemoryMemberRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//public class MemberServiceTest {
//    MemberService memberService;
//    MemoryMemberRepository memberRepository;
//
//    @BeforeEach
//    public void beforeEach() {
//        memberRepository = new MemoryMemberRepository();
//        memberService = new MemberService(memberRepository);
//    }
//
//    @AfterEach
//    public void afterEach() {
//        memberRepository.clearStore();
//    }
//
//    @Test
//    public void 회원가입() throws Exception {
//        //given
//        MemberInfo member = new MemberInfo();
//        member.setEmail("jihoon@naver.com");
//        member.setName("이지훈");
//        //when
//        Long saveId = memberService.join(member);
//        //then
//        MemberInfo findMember = memberRepository.findById(saveId).get();
//        Assertions.assertEquals(member.getEmail(), findMember.getEmail());
//        Assertions.assertEquals(member.getName(), findMember.getName());
//    }
//
//    @Test
//    public void 중복_회원_예외() throws Exception {
//        //given
//        MemberInfo member1 = new MemberInfo();
//        member1.setName("이지후운");
//        member1.setEmail("jihoon@naver");
//
//        MemberInfo member2 = new MemberInfo();
//        member2.setName("이지후운");
//        member2.setEmail("jihoon@naver");
//        //when
//        memberService.join(member1);
//        IllegalStateException e = Assertions.assertThrows(IllegalStateException.class,
//                () -> memberService.join(member2)); // 예외가 발생해야함.
//       org.assertj.core.api.Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//
//
//        //then
//    }
//
//
//}
