package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {

    ModelView process(Map<String, String> paramMap); //v2랑 비교 해보자. //프로그램에 종속적인 것이지, 서블릿에 종속적이지 않음.
}
