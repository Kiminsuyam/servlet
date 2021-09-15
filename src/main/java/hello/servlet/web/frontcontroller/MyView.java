package hello.servlet.web.frontcontroller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Key;
import java.util.Map;

public class MyView {
    private String viewPath;    //"WEB-INF/views/new-form.jsp"

    //command + n
    public MyView(String viewPath) {
        this.viewPath = viewPath;
    }

    //View만든다는 거 자체가 렌더링한다라는 뜻
    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request,response); //forward하게되면 실제 렌더링 끝난다

    }

    public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        modelToRequestAttribute(model, request); // 모델에있는 데이터를 forEach 로 다 꺼내야 함.
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request,response);
    }

    private void modelToRequestAttribute(Map<String, Object> model, HttpServletRequest request) {
        model.forEach((key, value) -> request.setAttribute(key, value));    //JSP는 request.getAttribute()로 데이터를 조회하기 때문에, 모델의 데이터를 꺼내 request.setAttribute()로 담아둔다.
    }       //forEach = Model에있는 data 다 꺼내야함.
}
