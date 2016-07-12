package ir.bmi.controller;


import ir.bmi.entity.PersonTO;
import ir.bmi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by utab on 7/5/2016.
 */
@Controller
public class MyController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/")
    public String hello() {
        return "hello";
    }

    // ba method delete moshkel dare bayad dorost beshe......
    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    public String del(ModelMap modelMap) {
        modelMap.addAttribute("message3", "salammmmmm");
        System.out.println("delete,,,,,,");
        return "delete";
    }

    @RequestMapping(value = "/sum", params = {"x", "y"}, method = RequestMethod.POST)
    public String sum(@RequestParam(value = "x") int x, @RequestParam(value = "y") int y, ModelMap modelMap) {
        int result = x + y;
        modelMap.addAttribute("SumResult", "X+Y= " + result);
        System.out.println(result);
        return "sum";
    }
     @RequestMapping(value = "/service", method = RequestMethod.GET)
    public String getAllPersons() {
        try {
            System.out.println("in controller method ..");
            PersonTO personTO =new PersonTO();

            System.out.println("Controller...");
            personTO=personService.inserted(personTO);
            System.out.println("after reg In controller"+personTO.getFamily());
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage() + "error: Exception getAllPersons");
            return null;
        }
    }
     @RequestMapping(value = "/getp", method = RequestMethod.GET)
    public String getPersons() {
        try {
            System.out.println("in controller method ..");
            PersonTO personTO=new PersonTO();
            personTO.setName("aaa");
            personTO.setFamily("bbb");
            personTO.setId(1);
            System.out.println( personService.inserted(personTO));
            System.out.println("After Controller...");
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage() + "error: Exception");
            return null;
        }
    }

}
