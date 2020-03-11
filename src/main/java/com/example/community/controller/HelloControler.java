package com.example.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Project: community
 * @ClassName: HelloControler
 * @Company: JIT Northeast R & D
 * @Description:
 * @author: zheng_wang
 * @date: 2020年03月10日
 */
@Controller
public class HelloControler {
    @GetMapping("/hello")
    public String hello(@RequestParam(name="name")String name, Model model){
        model.addAttribute("name",name);
        return "hello";
    }
}
