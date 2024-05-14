package database.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/basic/introduce")
    public String departmentIntroduce() {
        return "basic/departmentintro";
    }
}
