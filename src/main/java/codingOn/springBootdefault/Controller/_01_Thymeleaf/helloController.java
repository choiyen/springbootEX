package codingOn.springBootdefault.Controller._01_Thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class helloController
{

    @GetMapping("peractice")
    public String Getperactice(Model model){

        //ver2.  Thymeleaf  표현식과 문법
        model.addAttribute("age",10);

        return "_01_Thymeleaf/peractice";
    }

    @GetMapping("people")
    public String Getpeople(Model model){

        ArrayList<Person> person = new ArrayList<>();
        person.add(new Person("kim", 10));
        person.add(new Person("lee", 20));
        person.add(new Person("hong", 30));
        person.add(new Person("park", 40));
        person.add(new Person("shin", 50));

        //ver2.  Thymeleaf  표현식과 문법
        model.addAttribute("persons", person);

        return "_01_Thymeleaf/people";
    }

    @GetMapping("hi")
    public String GetHi(Model model)
    {
        //Model model : Controller 클래스 안의 메서드가 파라미터로 받을 수 있는 객체
        // - 정보를 담아 view에게 넘겨줄 떄 사용
        // - 개발자가 직접 model 을 생성할 필요 없이, 파라미터로 선언만 해주면 스프링이 알아서 만들어줌
        model.addAttribute("msg", "Hi~");


        //ver2.  Thymeleaf  표현식과 문법
        model.addAttribute("hello" ,"Spring boot");
        model.addAttribute("uText","<strong>Hello</strong>");

        model.addAttribute("value","이름을 입력하세요.");
        model.addAttribute("withValue","hello");
        model.addAttribute("Time","hi");

        model.addAttribute("imgSrc","iscream.png");
        model.addAttribute("userRole","admin");
        model.addAttribute("isAdmin",false);

        List<String> names = Arrays.asList("kim","lee","hong","sum");

        model.addAttribute("names", names);

        Hello hello = new Hello(25);

        model.addAttribute("classHello", hello);


        return "_01_Thymeleaf/hi";
    }

    class Hello
    {
        private int age;

        public Hello(int age) {
           this.age = age;
        }
        public int getAge() {
            return age;
        }
    }

    class Person
    {
        private String name;
        private int age;

        public Person(String name, int age)
        {
            this.name = name;
            this.age = age;
        }
        public String getName()
        {
            return name;
        }
        public int getAge()
        {
            return age;
        }
    }
}
