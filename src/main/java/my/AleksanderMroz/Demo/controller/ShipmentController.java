package my.AleksanderMroz.Demo.controller;


import my.AleksanderMroz.Demo.enumeration.ShipmentStatus;
import my.AleksanderMroz.Demo.service.CustomerService;
import my.AleksanderMroz.Demo.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shipments")
public class ShipmentController {
    @Autowired
    ShipmentService shipmentService;
    @Autowired
    CustomerService customerService;

    @GetMapping()
    public String showBookList(Model model) {
        model.addAttribute("shipmentList", customerService.findCustomerByName("Aleksander"));
        return "shipments";
    }

    @GetMapping("/order")
    public String showOrderPage(Model model) {
        return "orderpage";
    }


}
