package com.bms.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorPageController {

    @RequestMapping("/error400Page")
    public String error400Page() {
        return "error/400";
    }

    @RequestMapping("/error401Page")
    public String error401Page() {
        return "error/401";
    }

    @RequestMapping("/error404Page")
    public String error404Page() {
        return "error/404";
    }

    @RequestMapping("/error500Page")
    public String error500Page() {
        return "error/500";
    }
}
