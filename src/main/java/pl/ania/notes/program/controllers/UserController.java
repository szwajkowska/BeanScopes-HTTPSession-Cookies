package pl.ania.notes.program.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.ania.notes.program.UserList;
import pl.ania.notes.program.UserModel;
import pl.ania.notes.program.UserValidator;

import javax.validation.Valid;

@org.springframework.stereotype.Controller
@RequestMapping("/users")

public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);
    private UserList userList;
    private UserValidator userValidator;

    public UserController(UserList userList, UserValidator userValidator) {
        this.userList = userList;
        this.userValidator = userValidator;
    }

//    public UserController(UserList userList) {
//        this.userList = userList;
//    }

    @PostMapping
    String createNewUser(@Valid @ModelAttribute UserModel userModel, BindingResult result) {
        userList.addUser(userModel.getUsername(), userModel.getPassword());
        userValidator.validate(userModel, result);
        if (result.hasErrors()) {

            return "signIn";
        }
//        logger.info("Received new users data");
        return "redirect:/test/login?signedin";
    }

}

