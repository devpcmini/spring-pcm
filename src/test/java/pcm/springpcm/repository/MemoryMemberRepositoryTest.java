package pcm.springpcm.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import pcm.springpcm.domain.Member;

import java.util.List;

import static org.assertj.core.api.Assertions.*; //static으로 임포트

//테스트는 순서 보장이 안됨 전체 실행할 경우 참고
class MemoryMemberRepositoryTest {
    //TTD : 테스트를 먼저 만들고 구현클래스르 만들어서 돌려보는것
    //해당 클래스는 그냥 테스트를 만들고 테스트한 것
    MemoryMemberRepository repository = new MemoryMemberRepository();

    //callback 메서드 테스트케이스 끝난 후 실행
    @AfterEach
    public void afterEach(){
        //테스트 순서 의존관계없이 실행 하나 끝날때마다 저장소나 공용데이터를 깔끔하게 지우는 작업
        repository.clearStore();
    }

    @Test //JUnit을 이용하여 테스트
    public void save() {
        Member member = new Member();
        member.setName("박창민");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
//        Assertions.assertEquals(result , member); //JUnit을 이용하여 result와 member equals 비교
        assertThat(member).isEqualTo(result);  //org.assertj.core.api를 활용하여 문자 비교
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("박창민1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("박창민2");
        repository.save(member2);

        Member result = repository.findByName("박창민1").get();
//        Optional<Member> result = repository.findByName("박창민2").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("박창민1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("박창민2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
