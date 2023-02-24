package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("/add")
    public String displayAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user/add";
    }

    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute @Valid User user, String verify, Errors errors) {
        model.addAttribute("user", user);
        model.addAttribute("verify", verify);

//        if (user.getPassword().equals(verify)) {
//            return "user/index";
//        } else if (errors.hasErrors()) {
//            return "user/add";
//        } else {
//            model.addAttribute("error", "Passwords do not match");
//            return "user/add";
//        }
        if (errors.hasErrors()) {
            model.addAttribute("errorMsg", "Bad data!");
            return "user/add";
        } else return "user/index";

    }


}
