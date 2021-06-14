package com.example.myapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.*;


@Controller
class MyMainController {

    @Autowired
    private UserRepository repo;

    @Autowired
    private ItemRepository repoItems;

    @Autowired
    private BasketRepository repoBasket;

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
    public String loggingToShop(Model model)
    {
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = null;
        String firstName = null;
        boolean admin = false;
        if(user instanceof CustomUserDetails)
        {
            username = ((CustomUserDetails)user).getUsername();
            firstName = ((CustomUserDetails)user).getFirstName();
            admin = ((CustomUserDetails)user).getAdmin();
        }
        model.addAttribute("username",username);
        model.addAttribute("firstName",firstName);
        model.addAttribute("admin",admin);
        if(admin) return "admin_main_page_layout";
        return "shop_main_page_layout";
    }

    @PostMapping("/shopMainPage/ogrod")
    public String shopUserGarden(Model model)
    {
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String firstName = ((CustomUserDetails)user).getFirstName();
        List<Item> list = repoItems.findItemByCategory("Ogród");
        model.addAttribute("firstName",firstName);
        model.addAttribute("items",list);
        return "shop_category_page_layout";
    }

    @PostMapping("/shopMainPage/gaming")
    public String shopUserGaming(Model model)
    {
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String firstName = ((CustomUserDetails)user).getFirstName();
        List<Item> list = repoItems.findItemByCategory("Gaming");
        model.addAttribute("firstName",firstName);
        model.addAttribute("items",list);
        return "shop_category_page_layout";
    }

    @PostMapping("/shopMainPage/krzesla")
    public String shopUserChair(Model model)
    {
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String firstName = ((CustomUserDetails)user).getFirstName();
        List<Item> list = repoItems.findItemByCategory("Krzesła");
        model.addAttribute("firstName",firstName);
        model.addAttribute("items",list);
        return "shop_category_page_layout";
    }

    @PostMapping("/shopMainPage/koszyk")
    public String shopUserBasket(Model model)
    {
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String firstName = ((CustomUserDetails)user).getFirstName();
        Long id_client = ((CustomUserDetails)user).getId();
        List<Basket> listBasket = repoBasket.findItemsByClientId(id_client);
        //List<Item> list = new ArrayList<>();
        List<BasketItemDisplay> list = new ArrayList<>();
        for(Basket b:listBasket)
        {
           Item item = repoItems.findItemById(b.getIdItem());
           BasketItemDisplay temp = new BasketItemDisplay(item,b);
           list.add(temp);
        }
        model.addAttribute("firstName",firstName);
        model.addAttribute("items",list);
        model.addAttribute("rows",list.isEmpty());
        return "shop_basket_page_layout";
    }

    @PostMapping("/shopMainPage/new_admin")
    public String addingNewAdmin(Model model)
    {
        model.addAttribute("user",new User());
        return "admin_register_new_admin_layout";

    }
    @PostMapping("/shopMainPage/new_admin_adding")
    public String addingNewAdminProcess(@RequestParam(name ="password") String pass,@RequestParam(name ="haslo2") String pass2,User user)
    {
        try
        {
            if(!pass.equals(pass2))
            {
                return "admin_register_password_error";
            }
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String encodedPassword = encoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            user.setAdmin(true);
            repo.save(user);
        }
        catch(Exception e)
        {
            return "admin_register_error";
        }
        return "admin_register_success";
    }

    @PostMapping("/shopMainPage/addToBasket")
    public String addItemToUserBasket(@RequestParam(name ="ilosc") int count, @RequestParam(name ="id_produktu") Long idItem, Basket basket, Model model)
    {
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long idClient = ((CustomUserDetails)user).getId();
        String firstName = ((CustomUserDetails)user).getFirstName();
        Basket doesItExistInBasket = repoBasket.findItemByClientIdAndItemId(idItem,idClient);
        if(doesItExistInBasket!=null)
        {
            int oldCount = doesItExistInBasket.getItemCountered();
            int newCount = oldCount+count;
            repoBasket.updateCounterInDatabaseBasketUser(newCount,idClient,idItem);

        }
        else
        {
            basket.setItemCountered(count);
            basket.setIdClient(idClient);
            basket.setIdItem(idItem);
            repoBasket.save(basket);
        }
        model.addAttribute("firstName",firstName);
        return "shop_category_success_added";
    }

    @PostMapping("/shopMainPage/deleteBasket")
    public String deleteWholeBasket(Model model)
    {
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long idClient = ((CustomUserDetails)user).getId();
        repoBasket.deleteEverythingFromUserBasket(idClient);
        String firstName = ((CustomUserDetails)user).getFirstName();
        List<Basket> listBasket = repoBasket.findItemsByClientId(idClient);
        List<Item> list = new ArrayList<>();
        for(Basket b:listBasket)
        {
            Item item = repoItems.findItemById(b.getIdItem());
            list.add(item);
        }

        model.addAttribute("firstName",firstName);
        model.addAttribute("items",list);
        model.addAttribute("rows",list.isEmpty());
        return "shop_basket_page_layout";
    }

    @PostMapping("/shopMainPage/acceptBasket")
    public String acceptBasket(Model model)
    {
        return "shop_basket_page_layout";
    }
}
