package com.example.myapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
class MyMainController {

    @Autowired
    private UserRepository repo;

    @GetMapping("")
    public String loginHomePage() {
        return "login";
    }
    @GetMapping("/rejestracja")
    public String registerHomePage(Model model) {
        model.addAttribute("user",new User());
        return "register";
    }
    @PostMapping("/process_register")
    public String processRegistration(@RequestParam(name ="password") String pass,@RequestParam(name ="haslo2") String pass2,User user)
    {
        try
        {
            if(!pass.equals(pass2))
            {
                return "register_password_error";
            }
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String encodedPassword = encoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            repo.save(user);
        }
        catch(Exception e)
        {
            return "register_error";
        }
        return "register_success";
    }
    @GetMapping("/shopMainPage")
    public String loggingToShop()
    {

        return "shop_main_page_layout";
    }
}
