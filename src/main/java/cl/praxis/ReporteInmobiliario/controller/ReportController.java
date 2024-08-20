package cl.praxis.ReporteInmobiliario.controller;


import cl.praxis.ReporteInmobiliario.model.entities.Report;
import cl.praxis.ReporteInmobiliario.model.entities.User;
import cl.praxis.ReporteInmobiliario.model.repositories.UserRepository;
import cl.praxis.ReporteInmobiliario.model.service.ReportService;
import cl.praxis.ReporteInmobiliario.model.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/reports")
public class ReportController {

    private final ReportService rService;
    private final UserService uService;

    private final UserRepository uRepo;


    public ReportController(ReportService rService, UserService uService, UserRepository uRepo) {
        this.rService = rService;
        this.uService = uService;
        this.uRepo = uRepo;
    }
    @GetMapping
    public String reportsList(Model model){
        model.addAttribute("reports",rService.findAll());
        List<String> colors = Arrays.asList("blue", "green", "yellow", "brown", "purple", "orange");
        model.addAttribute("colors", colors);
        return "reportsList";

    }
    //new report form
    @GetMapping("/new")
    public String getCreate(Principal principal,Model model) {
        String currentUsername=principal.getName();
        User user= uRepo.findOneByEmail(currentUsername).orElse(null);
        model.addAttribute("authenticatedUserId",user.getId());
        return "newReport";
    }
    //new report creation
    @PostMapping("/new")
    public String postCreate(@ModelAttribute Report report) {
        boolean result = rService.create(report);
        return "redirect:/reports";
    }
    //delete report
    @GetMapping("/del/{id}")
    public String delete(@PathVariable("id") int id) {
        boolean result = rService.delete(id);
        return "redirect:/reports";
    }
    //read report
    @GetMapping("/{id}")
    public String getUpdate(@PathVariable("id") int id, Model model,Principal principal) {
        Report reportToUpdate = rService.findOne(id);
        model.addAttribute("report", reportToUpdate);
        String currentUsername=principal.getName();
        User user= uRepo.findOneByEmail(currentUsername).orElse(null);
        model.addAttribute("authenticatedUserId",user.getId());
        return "reportEdit";
    }
    //update report
    @PostMapping
    public  String postUpdate(@ModelAttribute Report report){
        boolean result  = rService.update(report);
        return "redirect:/reports";
    }
}
