package codingOn.springBootdefault.Controller._02_RestAPI;

import codingOn.springBootdefault.DTO.listDTO;
import codingOn.springBootdefault.DTO.userDTO;
import codingOn.springBootdefault.DTO.userDTO2;
import codingOn.springBootdefault.VO.userVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
public class RestController
{
    /// =====================Template 렌더링 =========================
    @GetMapping("/user")
    public String getReq() {
        return "_02_RESTAPI/req";
    }

    //==============Get 요청 처리 ==================
    // 매개변수 넘겨받는 법
    //1. /test?id=123
    //2. /test/123
    @GetMapping("/get/res1")
    public String getRes1(@RequestParam(value = "name") String name, @RequestParam(value = "age") int age, Model model)
    {
        //@RequestParam 어노테이션
        // - string query 중에서 name key 에 대한 value 를 String name을 매핑(?key = value)
        // - required = true가 기본값이므로 요청 URL에 대한 name key 값을 필수로 보내야함.
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "_02_RESTAPI/res";

    }

    @GetMapping("/get/res2")
    public String getRes2(@RequestParam(value = "name", required = false) String name, Model model)
    {
        //required = false 옵션
        // - query string 에서 직접 key를 optional 하게 있어야 하는 경우
        model.addAttribute("name", name);
        return "_02_RESTAPI/res";
    }
        @GetMapping("/get/res3/{param1}/{param2}")
        public String getRes3(@PathVariable String param1, @PathVariable(value = "param2") int age, Model model) {

            //@PathVariable 어노테이션
            // - test/{id} 형식의 URL 경로로 넘어오는 값을 변수로 받을 떄 사용
            // - 기본적으로 경로 변수는 값을 가져야 할 (값이 없는 경우 404 에러 발생)
            //참고. url에 기입한 변수명과 다른 매개변수 이름을 사용하고 싶다면
            //@PathVariable(value = "param2") int age

            model.addAttribute("name", param1);
            model.addAttribute("age", age);
            return "_02_RESTAPI/res";
        }
    @GetMapping({"/get/res4/{name}","/get/res4/{name}/{age}" })
    public String getRes4(@PathVariable String name, @PathVariable(required = false) Integer age, Model model)
    {

        //@PathVariable 어노테이션
        // - test/{id} 형식의 URL 경로로 넘어오는 값을 변수로 받을 떄 사용
        // - 기본적으로 경로 변수는 값을 가져야 할 (값이 없는 경우 404 에러 발생)
        //참고. url에 기입한 변수명과 다른 매개변수 이름을 사용하고 싶다면
        //@PathVariable(value = "param2") int age

        // : name(필수), age(옵션 선택)
        // : optional한  parameter가 있다면 맨 뒤에 오도록 설정
        // 참고. Integer age 라고 지정한 이유
        // - age는 optional, 즉, null이 될 수도 있기 때문에 primitive type이 아닌 reference type은 객체 시점

        model.addAttribute("name", name);
        model.addAttribute("age", age);

        return "_02_RESTAPI/res";
    }
    @GetMapping("/practice")
    public String getpractice() {
        return "_02_RESTAPI/preactice_req";
    }

    @GetMapping("/practice2")
    public String getpractice2() {
        return "_02_RESTAPI/preactice_req2";
    }


    @GetMapping("/introduce/{param1}")
    public String getRes5(@PathVariable String param1, Model model) {

        //@PathVariable 어노테이션
        // - test/{id} 형식의 URL 경로로 넘어오는 값을 변수로 받을 떄 사용
        // - 기본적으로 경로 변수는 값을 가져야 할 (값이 없는 경우 404 에러 발생)
        //참고. url에 기입한 변수명과 다른 매개변수 이름을 사용하고 싶다면
        //@PathVariable(value = "param2") int age

        model.addAttribute("name", param1);
        return "_02_RESTAPI/preactice_res";
    }
    @GetMapping("/introduce2")
    public String getRes6(@RequestParam(value = "name") String name, @RequestParam(value = "age") Integer age, Model model)
    {
        //@RequestParam 어노테이션
        // - string query 중에서 name key 에 대한 value 를 String name을 매핑(?key = value)
        // - required = true가 기본값이므로 요청 URL에 대한 name key 값을 필수로 보내야함.
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "_02_RESTAPI/preactice_res";

    }

    //===============POST 요청 ===============
    //- Post 로 전달할 때 controller 에서 받은 방법은 @RequsetParam
    @PostMapping("/post/res1")
    public String postRes1(@RequestParam String name, @RequestParam int age, Model model)
    {
        //Requset = true
      model.addAttribute("name", name);
      model.addAttribute("age", age);
      return "_02_RESTAPI/res";
    }

    @PostMapping("/post/res2")
    public String postRes2(@RequestParam String name, @RequestParam(required = false) Integer age, Model model)
    {
        //Requset = true
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "_02_RESTAPI/res";
    }

    //=> @ResponseBody 사용
    @PostMapping("/post/res3")
    @ResponseBody  //json  데이터 받을 때만
    public String postRes3(@RequestParam String name, @RequestParam int age, Model model)
    {
        //Requset = true
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return name + "  " + age;
    }
    // ㄴ 여기까지 코드는 return이 항상 Temlate Time~ 만약에 api에서 자료를 응답하고 싶다면?

    //Requset = true
    @PostMapping("/interesting")
    public String postRes4(@RequestParam String name, @RequestParam String gender, @RequestParam String date, @RequestParam String interest,  Model model)
    {

        //Requset = true
        model.addAttribute("name", name);
        model.addAttribute("gender", gender);
        model.addAttribute("date", date);
        model.addAttribute("interest", interest);
        //name, gender, date, interest
        return "_02_RESTAPI/preactice_res";
    }

    ///=========================== DTO 이용 =======================
    // 1. GET 요청 처리

   @ResponseBody
   @GetMapping("/dto/res1")
   public String dtoRes1(@ModelAttribute userDTO UserDTO)
   {
     //변수로 값을 하나씩 가져오는 게 아니라 DTO 객체에 담아서 가져오기
     //-> 매핑 : setter 함수 실행
     return UserDTO.getName() + " " + UserDTO.getAge();
   }

   //2. POST 요청
    @PostMapping("/dto/res2")
    @ResponseBody
    public String dtoRes2(userDTO UserDTO)
    {
        //변수로 값을 하나씩 가져오는 게 아니라 DTO 객체에 담아서 가져오기
        //-> 매핑 : setter 함수 실행
        return UserDTO.getName() + " " + UserDTO.getAge();
    }

    @PostMapping("/dto/res3")
    @ResponseBody
    public String dtoRes3(@RequestBody userDTO UserDTO)
    {
        //변수로 값을 하나씩 가져오는 게 아니라 DTO 객체에 담아서 가져오기
        //-> 매핑 : setter 함수 실행
        //@RequestBody 이노테이션
        // - 요청의 본문에 있는 데이터(req.body) 를 읽어와서 객체에 매핑
        // - 여기서 매핑? 필드값에 값을 주입
        // - 전달받은 요청의 형식이 json or xml 타입일 때만 가능
        // "일반 폼 전송" (Context-Type "application/x-www-form-urlencoded; charset-UTF-8)
        return UserDTO.getName() + " " + UserDTO.getAge();
    }

    // =====================VO 요청 처리 =========================
    // : GET 요청
    // VO : NULL,(modelattribute => setter 함수 실행)
    @GetMapping("/vo/res1")
    @ResponseBody
    //@ModelAttoribute에서 Setter 실행
    public String VORes1(@ModelAttribute userVO userVO)
    {
        return userVO.getName() + " " + userVO.getAge();//null 0
    } //에러는 안나지만 NULl과 0이라는 값으로 출력됨(Setter 없음)

    @PostMapping("/vo/res2")
    @ResponseBody
    public String VORes2(userVO userVO)
    {
        return userVO.getName() + " " + userVO.getAge();//null 0
    } //에러는 안나지만 NULl과 0이라는 값으로 출력됨(Setter 없음)

    @PostMapping("/vo/res3")
    @ResponseBody
    public String VORes3(@RequestBody userVO userVO)
    {
        return userVO.getName() + " " + userVO.getAge();//null 0
    } //에러는 안나지만 NULl과 0이라는 값으로 출력됨(Setter 없음)
      // = (type = Unsupported Media Type


    // ========== DTO 이용 with. axios =============
    @ResponseBody
    @GetMapping("/axios/res")
    public String axiosRes1(@RequestParam(value = "name") String name, @RequestParam(value = "age") int age) {
       return "이름 : " + name + "나이 : " + age;
    }

    @GetMapping("/axios/res2")
    @ResponseBody
    public String axiosRes2(userDTO userDTO) {
        return "이름 : " + userDTO.getName() + "나이 : " + userDTO.getAge();
    }

    @PostMapping("/axios/res3")
    @ResponseBody
    //axios로 값을 전달하게 될 경우, Post로 값을 보내면 파라미터로 값이 들어오지 않음.
    //@RequestParam 은 required true 에러
    public String axiosRes3(@RequestParam String name, @RequestParam int age) {
        return "이름 : " + name + "나이 : " + age;
    }
    //error

    @PostMapping("/axios/res4")
    @ResponseBody
    // Axios로 Post 요청을 보일 경우, 본문에 데이터가 들어가기 때문에 @ModelAttribute로는 확인 불가 => 기본 값 null
    public String axiosRes4(userDTO userDTO)
    {
        return "이름 : " + userDTO.getName() + "나이 : " + userDTO.getAge();
    }
    // = null, 0

    @PostMapping("/axios/res5")
    @ResponseBody
    public String axiosRes5(@RequestBody userDTO userDTO) {
        return "이름 : " + userDTO.getName() + "나이 : " + userDTO.getAge();
    }

    ///axios/vo/res5
    // ========== VO 이용 with. axios =============
    @ResponseBody
    @GetMapping("/axios/vo/res")
    public String axiosvoRes1(@RequestParam(value = "name") String name, @RequestParam(value = "age") int age) {
        return "이름 : " + name + "나이 : " + age;
    }

    @GetMapping("/axios/vo/res2")
    @ResponseBody
    public String axiosvoRes2(userVO UserVO) {
        // @ModelAttribute -> setter 이용해야 하는데, vo 또는 setter 가 없어도 null
        return "이름 : " + UserVO.getName() + "나이 : " + UserVO.getAge();
    }


    @PostMapping("/axios/vo/res3")
    @ResponseBody
    //axios로 값을 전달하게 될 경우, Post로 값을 보내면 파라미터로 값이 들어오지 않음.
    //@RequestParam 은 required true 에러
    public String axiosvoRes3(@RequestParam String name, @RequestParam int age) {
        return "이름 : " + name + "나이 : " + age;
    }
    //error

    @PostMapping("/axios/vo/res4")
    @ResponseBody
    // Axios로 Post 요청을 보일 경우, 본문에 데이터가 들어가기 때문에 @ModelAttribute로는 확인 불가 => 기본 값 null
    public String axiosvoRes4(userVO UserVO)
    {
        return "이름 : " + UserVO.getName() + "나이 : " + UserVO.getAge();
    }
    // = null, 0

    @PostMapping("/axios/vo/res5")
    @ResponseBody
    //@RequestBody로 값을 전달할 때는 Setter 없이도 값이 들어감.
    // setter 함수 실행이 아니라 각각의 필드 변수에 직접 값을 주입하면서 매핑
    public String axiosvoRes5(@RequestBody userVO UserVO) {
        return "이름 : " + UserVO.getName() + "나이 : " + UserVO.getAge();
    }


    @PostMapping("/interesting2")
    @ResponseBody
    public String axiospostRes4(@RequestBody listDTO ListDTO)
    {
        //name, gender, date, interest
        return "이름 : " + ListDTO.getName() + "성별 : " + ListDTO.getGender() + "날짜 :" + ListDTO.getDate() + "흥미 : " + ListDTO.getInterest();
    }

    @GetMapping("/profile")
    public String getlist(Model model)
    {
        model.addAttribute("id", "yyy1459");
        model.addAttribute("pw", "qazqaz@369");
        model.addAttribute("name", "최연철");
        model.addAttribute("phone", "01046501459");
        model.addAttribute("gender", "male");
        model.addAttribute("email", "yyy1459@naver.com");
        model.addAttribute("hobbies", "travel");

        return "_02_RESTAPI/Profile";
    }
    @PostMapping("/interestingC")
    @ResponseBody
    public String interestingRes5(@RequestBody userDTO2 ListDTO2)
    {
        return "아이디 : " + ListDTO2.getId() + "비밀번호 : "
               + ListDTO2.getPw() + "이름 :" + ListDTO2.getName()
               + "휴대전화 : " + ListDTO2.getPhone() + "이메일 :" + ListDTO2.getEmail() + "생년월일 :" + ListDTO2.getDate()
               + "성별 :" + ListDTO2.getGender() + "관심사 :" + ListDTO2.getHobbies();
    }
    @PostMapping("/interestingR")
    @ResponseBody
    public String interestingRes6(@RequestParam(value = "id") String id, @RequestParam(value = "pw") String pw)
    {
        userDTO2 user = new userDTO2();
        user.setId("아나바다");
        user.setPw("asdzxc@123");
        if(user.getId() == id && user.getPw() == pw)
        {
            return "로그인이 되었습니다.";
        }
        else
        {
            return "아이디나 패스워드가 틀렸습니다.";
        }
    }
    @PostMapping("/interestingU")
    @ResponseBody
    public String interestingRes7(@RequestBody userDTO2 ListDTO2)
    {
        userDTO2 user = new userDTO2();
        user.setId("yyy1459");
        user.setPw("qazqaz@369");
        user.setName("최연철");
        user.setGender("male");
        user.setPhone("01046501459");
        user.setEmail("yyy1459@naver.com");
        user.setHobbies("travel");

        user = ListDTO2;
        return user.getId() + "님의 정보가 수정되었습니다.";
    }

    @PostMapping("/interestingD")
    @ResponseBody
    public String interestingRes8(@RequestParam(value = "id") String id, @RequestParam(value = "pw") String pw)
    {
        userDTO2 user = new userDTO2();
        user.setId("yyy1459");
        user.setPw("qazqaz@369");
        if(user.getId() == id && user.getPw() == pw)
        {
            return "회원님의 앞길을 응원하겠습니다.";
        }
        else
        {
            return "회원정보가 틀려 삭제할 수 없습니다.";
        }
    }



}


