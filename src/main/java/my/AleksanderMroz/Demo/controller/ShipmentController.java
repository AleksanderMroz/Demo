package my.AleksanderMroz.Demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shipments")
public class ShipmentController {

    @GetMapping()
    public String showBookList(Model model) {
        return "shipments";
    }
}
