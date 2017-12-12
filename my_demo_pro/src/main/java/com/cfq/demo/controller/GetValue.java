package com.cfq.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/get")
public class GetValue {
    @RequestMapping("/getValue")
    public String getValue(@ModelAttribute(value = "result") String result) {
        System.out.println(result);
        return "/myTest";
    }

}
