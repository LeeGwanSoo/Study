package kr.co.joneconsulting.myrestfulservice.controller;

import kr.co.joneconsulting.myrestfulservice.bean.HelloWorldBean;
import org.springframework.cglib.core.Local;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloController {

    private MessageSource messageSource;
    public HelloController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
    //GET
    //URI /hello-world
    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello-world");
    }

    @GetMapping(path = "/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldBeanpathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello-world %s", name));
    }

    @GetMapping(path = "/hello-world-internationalized")
    public String helloworldInternationalized(
            @RequestHeader(name = "Accept-Language", required = false) Locale locale){
        return messageSource.getMessage("greeting.message", null, locale);
    }
}
