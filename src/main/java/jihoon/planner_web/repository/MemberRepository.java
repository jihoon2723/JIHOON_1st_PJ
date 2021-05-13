package jihoon.planner_web.repository;

import jihoon.planner_web.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);
    Optional<Member> findByEmail(String email);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
