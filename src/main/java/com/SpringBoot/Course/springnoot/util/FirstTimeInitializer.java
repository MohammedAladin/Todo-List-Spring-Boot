package com.SpringBoot.Course.springnoot.util;

import com.SpringBoot.Course.springnoot.security.AppUser;
import com.SpringBoot.Course.springnoot.security.UserService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FirstTimeInitializer implements CommandLineRunner {

    private final Log logger = LogFactory.getLog(FirstTimeInitializer.class);
    @Autowired
    private UserService userService;
    @Override
    public void run(String... args) throws Exception {
        if(userService.getAll().isEmpty())
        {
            logger.info("No users are found");
            AppUser user = new AppUser("Mohammed", "Mohammed@.com","Password");
            userService.AddUser(user);

        }
    }
}
