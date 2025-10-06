package com.example.hotel_app.controller;


import com.example.hotel_app.dto.UserDto;
import com.example.hotel_app.feign.UserServiceClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserControllerMvc {

    private final UserServiceClient userClient;

    public UserControllerMvc(UserServiceClient userClient) {
        this.userClient = userClient;
    }

    @GetMapping("/all")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userClient.getAllUsers());
        return "users/list";
    }

    @GetMapping("/add")
    public String addUserForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "users/add";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") UserDto user) {
        userClient.createUser(user);
        return "redirect:/users/all";
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model) {
        model.addAttribute("user", userClient.getUser(id));
        return "users/edit";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute("user") UserDto user) {
        userClient.updateUser(id, user);
        return "redirect:/users/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userClient.deleteUser(id);
        return "redirect:/users/all";
    }
}
