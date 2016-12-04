package thymeleafexamples.sfs.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import thymeleafexamples.sfs.business.entities.Customer;
import thymeleafexamples.sfs.business.services.CustomerService;

/**
 * Created by shower on 16-12-2.
 */
@Controller
public class SigninController {
    @Autowired
    private CustomerService customerService;

    public SigninController() {
        super();
    }

    @RequestMapping(path = {"/", "/signin"}, method = RequestMethod.GET)
    public String showSignin() {
        return "signin";
    }

    @RequestMapping(path = "/signin", method = RequestMethod.POST)
    public String addCustomer(@RequestParam("signInUsername") String name, @RequestParam("signInPassword") String password, Model model) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        String msg = null;
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            msg = "Wrong username";
        } catch (IncorrectCredentialsException e) {
            msg = "Wrong password";
        } catch (AuthenticationException e) {
            msg = "other errors";
        }

        if (msg == null) {
            return "redirect:/index";
        } else {
            model.addAttribute("msg", msg);
            return "signin";
        }
    }

    @RequestMapping("/signout")
    public String signout() {
        SecurityUtils.getSubject().logout();
        return "signin";
    }
}
