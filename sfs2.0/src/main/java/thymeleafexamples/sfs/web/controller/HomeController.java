package thymeleafexamples.sfs.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import thymeleafexamples.sfs.business.services.CityService;
import thymeleafexamples.sfs.business.entities.City;

import java.util.List;
import java.util.Arrays;

/**
 * Created by shower on 16-11-7.
 */
@Controller
public class HomeController {

    @Autowired
    private CityService cityService;

    public HomeController() {
        super();
    }

    @ModelAttribute("cities")
    public List<City> getCities() {
    	return this.cityService.findAll();
    }

    @RequestMapping({"/", "/index"})
    public String showHome(final City c) {
        return "index";
    }
}
