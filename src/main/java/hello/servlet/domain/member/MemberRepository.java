package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 문제가 고려되어 있지 않음, 실무에서는
 * ConcurrentHashMap, AtomicLong 사용 고려
 */

public class MemberRepository { //command + shift + t 테스트 코드

    private static Map<Long, Member> store = new HashMap<>(); //싱글톤으로 했기때문에, static 이 없어도 된다.
    private static long sequence = 0L; //아이디가 하나씩 증가 ,static 없어도 됨

    //싱글톤으로 만들 것
    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;

    }

    //싱글톤으로 만들 때는 생성자를 막아야 됨. 아무나 생성하지 못하게
    private MemberRepository() {
    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //new list에 값을 넣거나밖에서 리스트를 조작해도 store에있는 value list 를 건들지 않기위해
    }

    public void clearStore() {
        store.clear();
    } //store를 다 날려버리는 것
}
