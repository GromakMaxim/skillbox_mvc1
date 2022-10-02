package org.example.web.controllers;


import org.apache.log4j.Logger;
import org.example.web.dto.LoginForm;
import org.example.web.exceptions.BookShelfLoginException;
import org.example.web.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/login")
public class LoginController {
    private final Logger logger = Logger.getLogger(this.getClass());
    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping
    public String login(Model model) {
        logger.info("GET /home returns login_page.html");
        model.addAttribute("loginForm", new LoginForm());
        return "login_page";
    }

    @PostMapping("/auth")
    public String authenticate(LoginForm loginForm) throws BookShelfLoginException {
        if (loginService.authenticate(loginForm)) {
            logger.info("login OK. Redirect to book shelf");
            return "redirect:/books/shelf";
        } else {
            logger.info("login FAILED");
            throw new BookShelfLoginException("invalid username or password");
        }
    }

    @ExceptionHandler(BookShelfLoginException.class)
    public String handle(Model model, Exception exception) {
        model.addAttribute("errorMessage", exception.getMessage());
        return "errors/404";
    }

}
