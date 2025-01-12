package codingOn.springBootdefault.VO;


import lombok.Getter;

import java.util.Objects;

@Getter
public class userVO
{
    private String name;
    private int age;

    @Override
    public boolean equals(Object s)
    {
        if(this == s)  return true;
        if(s == null || getClass() != s.getClass()) return false;
        userVO uservO = (userVO)s;

        // 모든 필드에 대한 비교
        return Objects.equals(name, uservO.name) && (age == uservO.age);
    }

    @Override
    public int hashCode()
    {
        // 필드들을 이용한 해시 코드 생성
        return Objects.hash(name, age);
    }
}

