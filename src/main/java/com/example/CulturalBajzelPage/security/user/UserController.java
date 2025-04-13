package com.example.CulturalBajzelPage.security.user;

import com.example.CulturalBajzelPage.security.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private final UserService userService;
    UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/mainAdminPage")
    String showHomePage(Model model) {
        model.addAttribute("listStudents", userService.listAll());
        return "admin/main";
    }
    @GetMapping("/mainPage")
    public String mainPage() {
        return "index";
    }
    @GetMapping("/add_user")
    String showNewStudentForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("roles", userService.listAllRoles());
        return "admin/new_user";
    }
    @PostMapping(value = "/save")
    String saveStudent(@ModelAttribute("user") User user, @RequestParam("roleId") Long roleId) {
        userService.save(user, roleId);
        return "redirect:/mainAdminPage";
    }
}