package codingOn.springBootdefault.Controller._01_Thymeleaf;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PracticeController
{
    @GetMapping("people2")
    public String getPeople(Model model) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("홍길동", 10));
        personList.add(new Person("김민지", 10));
        personList.add(new Person("성춘향", 10));
        model.addAttribute("personList", personList);

        return "_01_thymeleaf/people2";
    }
}

@Getter
@Setter
@AllArgsConstructor
class Person
{
    private String name;
    private int age;
}
//이노베이션만 작성해주어도 가능함.
//lombok이 추가된 효과


