package Spring_Server.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Spring_ServerController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "gel");
        return "index";
    }
}
