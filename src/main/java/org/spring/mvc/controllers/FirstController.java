package org.spring.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request, Model model){
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
//        System.out.println("Hello, " + name + " " + surname);
        model.addAttribute("massage", "Hello " + name + " " + surname);
        return "first/hello";
    }
    @GetMapping("/goodbye")
    public String goodbyePage(@RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "surname", required = false) String surname) {
        System.out.println("Bye, " + name + " " + surname);
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam("a") int a, @RequestParam("b") int b,
                                 @RequestParam("action") String action, Model model){
        double result = 0;
        switch (action) {
            case "multiplication":
                result = a * b;
                break;
            case "addition":
                result = a + b;
                break;
            case "subtraction":
                result = a - b;
                break;
            case "division":
                result = a * 1.00 / b;
                break;
        }
        model.addAttribute("calculate", "Result: " + result);
        return"third/calculator";
    }
}
