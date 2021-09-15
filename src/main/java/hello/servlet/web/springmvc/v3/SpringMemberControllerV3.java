package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    //GET으로만 호출되게 제약걸기.
//    @RequestMapping(value = "/new-form", method = RequestMethod.GET) //PostMan에서 GET인 경우에만 호출됨.
    @GetMapping("/new-form")
    public String newForm() {
        return "new-form";

    }

//    @RequestMapping(value = "/save", method = RequestMethod.POST) //GET은 조회할 때
    @PostMapping("/save")
    public String save(
            @RequestParam("username") String username,
            @RequestParam("age") int age,
            Model model) {

        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member", member);
        return "save-result";
    }
    // /springmvc/v2/members/members가 되기 때문에 지운다.
//    @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public String members(Model model) {

        List<Member> members = memberRepository.findAll();

        model.addAttribute("members", members);
        return "members";
    }
}
