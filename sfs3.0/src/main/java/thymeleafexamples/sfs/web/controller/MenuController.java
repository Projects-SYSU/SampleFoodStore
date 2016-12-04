package thymeleafexamples.sfs.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import thymeleafexamples.sfs.business.entities.*;
import thymeleafexamples.sfs.business.services.CityService;
import thymeleafexamples.sfs.business.services.CuisineService;
import thymeleafexamples.sfs.business.services.CustomerService;
import thymeleafexamples.sfs.business.services.OrderService;

import java.util.Set;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by shower on 16-11-6.
 */
@Controller
@RequestMapping(value = "/menu")
public class MenuController {
    @Autowired
    private CityService cityService;

    @Autowired
    private CuisineService cuisineService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private CustomerService customerService;

    private City city = null;

    public MenuController() {
        super();
    }

    @ModelAttribute("cuisines")
    public Set<Cuisine> getCuisines(@RequestParam(value = "cityId") Integer id) {
        if (id == null || this.cityService.findById(id) == null) {
            return null;
        }

        city = this.cityService.findById(id);
        return city.getCuisines();
    }

    @RequestMapping(method=RequestMethod.GET)
    public String showMenu(Model model) {
        model.addAttribute("city", city);
        Customer customer = customerService.findByName((String) SecurityUtils.getSubject().getPrincipal());
        if (customer.getVip()) model.addAttribute("vip", "You are VIP");
        return "menu";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addOrder(@RequestParam("cuisineId") int[] cuisines, @RequestParam("amount") Integer[] amount) {
        String name = (String) SecurityUtils.getSubject().getPrincipal();
        System.out.println(name);
        Customer customer = customerService.findByName(name);
        Order order = new Order(city, customer);
        for (int i = 0; i < amount.length; i++) {
            if (amount[i] > 0) {
                Cuisine cuisine = cuisineService.findById(cuisines[i]);
                OrderLine orderLine = new OrderLine(cuisine, amount[i]);
                double price;
                if (customer.getVip()) {
                    price = cuisine.getDiscount() * cuisine.getPrice() * amount[i];
                } else {
                    price = cuisine.getPrice() * amount[i];
                }
                orderLine.setPurchasePrice(price);
                order.getOrderLines().add(orderLine);
            }
        }
        int orderId = orderService.addOrder(order);
        return "redirect:/order?orderId=" + orderId;
    }
}
