package com.funapp.app.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.funapp.app.api.carsApi;

@Controller
public class MainController {
    @GetMapping("/")
    public String index(Model model) throws IOException {
        carsApi temp = new carsApi();

        model.addAttribute("eventName", "FIFA 2018");
        //model.addAttribute("cars", temp.getRandomCar());

        return "index";
    }

    @GetMapping("/car")
    public String cars(Model model) throws IOException {
        carsApi temp = new carsApi();
        model.addAttribute("cars", temp.getRandomCar());

        return temp.getRandomCar();
    }
}
