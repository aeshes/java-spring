package app.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = GET)
    public String home() {
        return "home";
    }
}
