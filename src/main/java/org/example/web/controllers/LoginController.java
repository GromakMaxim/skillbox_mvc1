package org.example.web.controllers;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class LoginController {
    Logger logger = Logger.getLogger(this.getClass());

    @GetMapping(value = "/login")
    public ModelAndView home(){
        logger.info("GET /home returns login_page.html");
        return new ModelAndView("login_page");
    }
}
