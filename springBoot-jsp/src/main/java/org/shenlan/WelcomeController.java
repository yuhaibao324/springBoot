package org.shenlan;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;

/**
 * Created by wangwei on 2016/9/19.
 */
@Controller
@RequestMapping("/jsp")
public class WelcomeController {

    @Value("${application.message:Hello World}")
    private String message = "Hello World";

    @RequestMapping("/")
    public String welcome(Map<String,Object> model){
        model.put("time",new Date());
        model.put("message",this.message);
        return "welcome";
    }

    @RequestMapping("/foo")
    public String foo(Map<String,Object> model){
        throw new RuntimeException("Foo");
    }
}
