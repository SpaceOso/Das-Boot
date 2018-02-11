package tech.spaceoso.dasboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController labels this class as a REST controller.
 * Methods inside this class will relate to REST verbs GET, PUT, PATCH, DELETE
 */
@RestController
public class HomeController {

    /**
     * @RequestMapping tells this method to catch url requests at the base path
     * @return {string}
     */
    @RequestMapping("/")
    public String home(){
        return "Das Boot, reporting for duty!";
    }

}
