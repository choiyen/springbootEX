package codingOn.springBootdefault.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class userDTO
{
    private String name;
    //@Getter
    //@Setter
    // 특정 필드에만 이노페이션을 붙일 수 있음.
    private int age;
}

//UserDTO
// - 요청 시에 전달된 값을 받는데 사용할 객체
// - 비즈니스 로직을 캡슐화
// : 모델은 데이터베이스 테이블 구조와 매우 유사함. DTO로 변환하면 외부 사용자에게 서비스 내부의 로직, 데이터베이스 구조를 숨길 수 있음.
// - 클라이언트로 반환시에는 부가 정보 추가 가능
// : ex. 에러 메세지
// 참고. LomDoK 라이브러리
// - getter, setter, builder, constructor 등의 코드를 자동 생성
// - @Builder : 빌더 패턴 지원
// - @NonNull : null이 될 수 없음을 명시
// - @RequiredArgsConstructor : 인자를 갖는 생성자
// - @Constructor
// - @NoArgsConstructor : 매개변수가 없는 생성자
// - @ALlArgsConstructor : 모든 맴버 변수를 매개변수로 받는 생성자.
// - @Data : 클래스 맴버 변수의 getter, setter를 모두 구현



