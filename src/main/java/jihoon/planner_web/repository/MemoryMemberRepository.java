//package jihoon.planner_web.repository;
//
//import jihoon.planner_web.domain.MemberInfo;
//import org.springframework.stereotype.Repository;
//
//import java.util.*;
//
//@Repository
//public class MemoryMemberRepository implements MemberRepository {
//    private static Map<Long, MemberInfo> store = new HashMap<>();
//    private static long sequence = 0L;
//
//    @Override
//    public MemberInfo save(MemberInfo member) {
//        member.setId(++sequence);
//        store.put(member.getId(), member);
//        return member;
//    }
//
//    @Override
//    public Optional<MemberInfo> findById(Long id) {
//        return Optional.ofNullable(store.get(id));
//    }
//
//    @Override
//    public Optional<MemberInfo> findByEmail(String email) {
//        return store.values().stream().filter(member -> member.getEmail().equals(email)).findAny();
//    }
//
//    @Override
//    public Optional<MemberInfo> findByName(String name) {
//        return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
//    }
//
//    @Override
//    public List<MemberInfo> findAll() {
//        return new ArrayList<>(store.values());
//    }
//    public void clearStore() {
//        store.clear();
//    }
//}
