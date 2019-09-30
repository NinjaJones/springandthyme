package ninagruppe.dings;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/front")
public class FrontController
{
    @GetMapping
    public String getFrontForm(Model model)
    {
        return "front";
    }

    @PostMapping
    public String eintraegeAnsehen()
    {
        return "hello";
    }

}