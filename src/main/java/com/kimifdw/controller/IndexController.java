package com.kimifdw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 主页
 * Created by kimiyu on 15/7/12.
 */
@Controller
public class IndexController {

    @RequestMapping(value={"/","home"})
    public String home(){
        return "home";
    }
}
