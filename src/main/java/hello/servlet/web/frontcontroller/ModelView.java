package hello.servlet.web.frontcontroller;

import java.util.HashMap;
import java.util.Map;

public class ModelView {
    private String viewName;        //뷰에 대한 것
    private Map<String, Object> model = new HashMap<>();    //모델에 대한 것

    public ModelView(String viewName) {
        this.viewName = viewName;
    }

    //lombok써도 된다.

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public void setModel(Map<String, Object> model) {
        this.model = model;
    }
}
