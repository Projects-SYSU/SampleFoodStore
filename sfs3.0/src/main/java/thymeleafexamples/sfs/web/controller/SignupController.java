package thymeleafexamples.sfs.web.controller;

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
public class SignupController {
    @Autowired
    private CustomerService customerService;

    public SignupController() {
        super();
    }

    @RequestMapping(path = "/signup", method = RequestMethod.GET)
    public String showSignup() {
        return "signup";
    }

    @RequestMapping(path = "/signup", method = RequestMethod.POST)
    public String addCustomer(@RequestParam("signUpUsername") String name,
                              @RequestParam("signUpPassword") String password,
                              @RequestParam("isVip") boolean isVip, Model model) {
        if (customerService.findByName(name) == null) {
            Customer customer = new Customer(name, password);
            customer.setVip(isVip);
            customerService.create(customer);
            return "redirect:/signin";
        } else {
            model.addAttribute("msg", "existed username!");
            return "signup";
        }
    }
}
