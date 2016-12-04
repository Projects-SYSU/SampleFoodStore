package thymeleafexamples.sfs.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;

import thymeleafexamples.sfs.business.entities.Cuisine;
import thymeleafexamples.sfs.business.services.CuisineService;

/**
 * Created by shower on 16-11-6.
 */
@Controller
@RequestMapping("/cuisine_detail")
public class CuisineDetailController {
    public CuisineDetailController() {
        super();
    }

    @Autowired
    private CuisineService cuisineService;

    @ModelAttribute
    public Cuisine getCuisine(@RequestParam(value = "cuisineName") String name) {
        return cuisineService.findByName(name);
    }

    @RequestMapping(method=RequestMethod.GET)
    public String showCuisineDetail() {
        return "cuisine_detail";
    }
}
