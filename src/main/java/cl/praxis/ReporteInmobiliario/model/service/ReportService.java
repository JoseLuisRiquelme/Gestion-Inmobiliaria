package cl.praxis.ReporteInmobiliario.model.service;

import cl.praxis.ReporteInmobiliario.model.entities.Report;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ReportService {
    List<Report> findAll();
    Report findOne(int id);
    boolean create(Report r);
    boolean update(Report r);
    boolean delete(int id);
}
