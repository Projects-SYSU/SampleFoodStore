package thymeleafexamples.sfs.web.controller;

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

import thymeleafexamples.sfs.business.entities.Cuisine;
import thymeleafexamples.sfs.business.services.CityService;
import thymeleafexamples.sfs.business.entities.City;
import thymeleafexamples.sfs.business.services.OrderService;
import thymeleafexamples.sfs.business.entities.Order;
import thymeleafexamples.sfs.business.entities.OrderLine;

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
    private OrderService orderService;

    private City city = null;

    public MenuController() {
        super();
    }

    @ModelAttribute("cuisines")
    public List<Cuisine> getCuisines(@RequestParam(value = "cityId") Integer id) {
        if (id == null || this.cityService.findById(id) == null) {
            return null;
        }

        city = this.cityService.findById(id);
        return new ArrayList<Cuisine>(city.getCuisines());
    }

    @RequestMapping(method=RequestMethod.GET)
    public String showMenu(Model model) {
        model.addAttribute("city", city);
        return "menu";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addOrder(@RequestParam("cuisineName") String[] cuisineName, @RequestParam("amount") Integer[] amount) {
        Order order = new Order();
        order.setCityId(city.getId());
        for (int i = 0; i < amount.length; i++) {
            if (amount[i] > 0)
                order.getOrderLines().add(new OrderLine(cuisineName[i], amount[i]));
        }
        int orderId = orderService.addOrder(order);
        return "redirect:/order/" + orderId;
    }
}
