package pl.b2bnetwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import pl.b2bnetwork.domain.RepoMaker;
import pl.b2bnetwork.domain.User;
import pl.b2bnetwork.domain.UserMaker;
import pl.b2bnetwork.service.UserService;

import javax.validation.Valid;

@RequestMapping("/users")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    private UserMaker userMaker = new UserMaker();

    private RepoMaker repoMaker = new RepoMaker();

    @RequestMapping(value = {"", "/", "home"})
    public String getHome(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        return "userHome";
    }

    @RequestMapping("/form")
    public String getForm(Model model) {
        model.addAttribute("user", new User());
        //model.addAttribute("users", userService.findAllUsers());
        return "userForm";
    }

    @RequestMapping("/saveUser")
    public String saveUser(Model model, @ModelAttribute @Valid User user, BindingResult bind) {
        if (bind.hasErrors()) {
            model.addAttribute("message", "It cannot be that login");
            return "userForm";
        } else {
            user = userMaker.makeUser(user.getLogin());
            userService.saveUser(user);
            model.addAttribute("users", userService.findAllUsers());
            model.addAttribute("message", "User added: " + user.getLogin());
            return "userHome";
        }
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(Model model, @RequestParam Long idDb) {
        String login = userService.findOne(idDb).getLogin();
        userService.deleteUser(idDb);
        model.addAttribute("users", userService.findAllUsers());
        model.addAttribute("message", "User deleted: " + login);
        return "userHome";
    }

    @RequestMapping("/deleteAll")
    public String deleteAll(Model model) {
        userService.deleteAll();
        model.addAttribute("users", userService.findAllUsers());
        model.addAttribute("message", "Deleted all Users from Database :(");
        return "userHome";
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public String findAllUsers(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        return "userForm";
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
    public void updateUser(String login) {
        User user = userMaker.makeUser(login);
        userService.updateUser(user);
    }

}
