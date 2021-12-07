
package ru.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.web.model.User;
//import ru.web.service.RoleService;
import ru.web.service.UserService;
import ru.web.service.UserServiceImpl;

import java.awt.print.Printable;
import java.security.Principal;
import java.util.List;

@Controller
public class UsersController {

    private UserService userService;



    public UsersController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getUser(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "user-page";
    }

    @GetMapping("/users/{id}")
    public String show(@PathVariable(value = "id") Long id, Model model) {
        User user = userService.readUser(id);
        model.addAttribute("users", user);
        return "user-page";
    }
  /*  @GetMapping("/users")
    public String allUsers(Model model) {
        List<User> user = userService.getAllUsers();
        model.addAttribute("users", user);
        return "users";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.createUser(user);
        return "redirect:/users";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable(value = "id", required = true) Long id, Model model) {
        User user = userService.readUser(id);
        model.addAttribute("user", user);
        return "/user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }*/
}

