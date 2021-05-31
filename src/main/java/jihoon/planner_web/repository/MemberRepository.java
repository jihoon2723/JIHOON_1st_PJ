package jihoon.planner_web.repository;

import jihoon.planner_web.domain.MemberInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberInfo,Long> {
    Optional<MemberInfo> findByEmail(String email);
    boolean existsByEmail(String email);
}
