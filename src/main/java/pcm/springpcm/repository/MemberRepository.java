package pcm.springpcm.repository;

import pcm.springpcm.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll(); //모든 회원 리스트 반환
}
