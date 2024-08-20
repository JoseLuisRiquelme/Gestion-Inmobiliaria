package cl.praxis.ReporteInmobiliario.model.service;

import cl.praxis.ReporteInmobiliario.model.repositories.ReportRepository;
import cl.praxis.ReporteInmobiliario.model.entities.Report;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    private final ReportRepository rRepository;

    public ReportServiceImpl(ReportRepository rRepository) {
        this.rRepository = rRepository;
    }

    @Override
    public List<Report> findAll() {
        return rRepository.findAll();
    }

    @Override
    public Report findOne(int id) {
        return rRepository.findById(id).orElse(null);
    }

    @Override
    public boolean create(Report r) {
        Report report = rRepository.save(r);
        return report!=null;
    }

    @Override
    public boolean update(Report r) {
        Report report = rRepository.save(r);
        return report!=null;
    }

    @Override
    public boolean delete(int id) {
        boolean exist=rRepository.existsById(id);
        if(exist){
            rRepository.deleteById(id);
        }
        return exist;
    }
}
