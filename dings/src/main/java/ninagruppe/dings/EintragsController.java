package ninagruppe.dings;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/eintraege")
public class EintragsController
{
    //    private List<Eintrag> eintraege;
    private EintragsRepository repository;

    public EintragsController(EintragsRepository repository)
    {
        this.repository = repository;

        repository.save(new Eintrag("Erster Eintrag!"));
        repository.save(new Eintrag("Zweiter Eintrag!"));
        repository.save(new Eintrag("Dritter Eintrag!"));
    }

    @GetMapping
    public String getEintraege(Model model)
    {
        model.addAttribute("eintrag", "Eintrag");
        model.addAttribute("tage", "Tage");
        model.addAttribute("minuten", "Minuten");

        model.addAttribute("alleEintraege", repository.findAll());

        return "hello";
    }

    @PostMapping
    public String addEintrag(@ModelAttribute Eintrag eintrag, Model model)
    {
        repository.save(eintrag);
        System.out.println("Anzahl Einträge: " + repository.count());
        return "redirect:eintraege";
    }

    //
    //    @PostMapping
    //    public Iterable<Eintrag> postEintrag(@RequestBody Eintrag eintrag)
    //    {
    //        eintraege.add(eintrag);
    //        return eintraege;
    //    }

}
