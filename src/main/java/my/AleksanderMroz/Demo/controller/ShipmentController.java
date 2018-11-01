package my.AleksanderMroz.Demo.controller;


import my.AleksanderMroz.Demo.enumeration.ShipmentStatus;
import my.AleksanderMroz.Demo.service.CourierService;
import my.AleksanderMroz.Demo.service.CustomerService;
import my.AleksanderMroz.Demo.service.ShipmentService;
import my.AleksanderMroz.Demo.to.CourierTo;
import my.AleksanderMroz.Demo.to.ShipmentTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/shipments")
public class ShipmentController {
    @Autowired
    ShipmentService shipmentService;
    @Autowired
    CustomerService customerService;
    @Autowired
    CourierService courierService;

    @GetMapping()
    public String showBookList(Model model) {
        model.addAttribute("shipmentList", customerService.findAllShipments(customerService.findCustomerByName("Aleksander").get(0)));
        return "shipments";
    }

    @GetMapping("/order")
    public String showOrderPage(Model model) {


        model.addAttribute("newShipment", new ShipmentTo());
        return "orderpage";
    }

    @GetMapping("/shipment")
    public String showShwipmentDetails(Model model, @RequestParam("id") Long id) {
        ShipmentTo shipmentTo = shipmentService.findAll().stream().filter(shipment -> shipment.getId().equals(id)).findFirst().orElse(null);
        model.addAttribute("shipment",shipmentTo);
        List<CourierTo>courierList2 = courierService.findAllCouriersThatCarriedShipment(shipmentTo);
        model.addAttribute("courierList",courierList2);
        return "shipment";
    }

    @GetMapping("/delete")
    public String shouldDelete(Model model, @RequestParam("id") Long id) {
        ShipmentTo shipmentTo = shipmentService.findAll().stream().filter(shipment -> shipment.getId().equals(id)).findFirst().orElse(null);
        shipmentService.deleteShipment(id);
        return "welcome";
    }

    @PostMapping("/new_shipment")
    public String createNewShipment(Model model,@ModelAttribute("newShipment") ShipmentTo shipmentTo) {
        shipmentService.saveShipment(shipmentTo);
        return "welcome";
    }



}
