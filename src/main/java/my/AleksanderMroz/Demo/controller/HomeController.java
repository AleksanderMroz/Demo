package my.AleksanderMroz.Demo.controller;




import my.AleksanderMroz.Demo.constants.ModelConstants;
import my.AleksanderMroz.Demo.constants.ViewNames;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {


    private static final String INFO_TEXT = "Here is my first my Welcome Page";
    protected static final String WELCOME = "WELCOME";


    @GetMapping(value = "/")
    public String welcome(Model model) {
        model.addAttribute(ModelConstants.MESSAGE, WELCOME);
        model.addAttribute(ModelConstants.INFO, INFO_TEXT);
        return ViewNames.WELCOME;
    }



}
