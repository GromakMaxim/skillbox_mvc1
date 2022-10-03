package org.example.app.services;

import org.apache.log4j.Logger;
import org.example.web.dto.LoginForm;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    Logger logger = Logger.getLogger(this.getClass());

    public boolean authenticate(LoginForm loginForm) {
        logger.info("try to auth with: " + loginForm.getUsername() + " -- " + loginForm.getPassword());
        return loginForm.getUsername().equals("root") && loginForm.getPassword().equals("123");
    }
}
