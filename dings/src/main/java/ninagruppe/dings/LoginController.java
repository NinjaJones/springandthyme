package ninagruppe.dings;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController
{
    @GetMapping
    public String getLoginForm()
    {
        return "login";
    }

    @PostMapping
    public String login(@ModelAttribute(name = "loginform") LoginForm loginForm,
            Model model)
    {
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();

        // wenn username und pw korrekt, weiter zur front-Seite
        if ("admin".equals(username) && "password".equals(password))
        {
            return "redirect:front";
        }

        // wenn username und password nicht korrekt waren, wieder login-Seite
        model.addAttribute("invalidCredentials", true);
        return "redirect:login";//&invalidCredentials";
    }

}
