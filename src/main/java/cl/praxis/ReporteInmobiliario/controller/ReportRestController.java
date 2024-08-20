package cl.praxis.ReporteInmobiliario.controller;

import cl.praxis.ReporteInmobiliario.model.entities.Report;
import cl.praxis.ReporteInmobiliario.model.service.ReportService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportRestController {
    private final ReportService rService;

    public ReportRestController(ReportService rService) {
        this.rService = rService;
    }
    @GetMapping
    public List<Report> findAll(){

        return  rService.findAll();
    }
}
