package hello.servlet.web.springmvc.old;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Spring Bean의 이름
@Component("/springmvc/old-controller")
public class OldController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldController.handleRequest");

        //view를 못찾으면 오류 페이지가 나온다. -> ViewResolver를 만들어줘야 한다. -> applicaiton.properties로
        return new ModelAndView("new-form"); //논리적 이름이니까 new-form의 물리적 이름으로 바꿔야 함
    }
}
