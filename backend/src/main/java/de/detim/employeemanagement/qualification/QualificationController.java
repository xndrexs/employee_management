package de.detim.employeemanagement.qualification;

import org.springframework.data.jpa.domain.QAbstractAuditable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QualificationController {

    private final QualificationService service;

    public QualificationController(QualificationService service){
        this.service = service;
    }

    @GetMapping("/qualifications")
    public List<Qualification> listQualifications(){
        return service.getEntities();
    }

    @GetMapping("/qualifications/{id}")
    public Qualification getQualification(@PathVariable Long id){
        return service.findEntity(id);
    }

    @PostMapping("/qualifications")
    public Qualification newQualification(@RequestBody Qualification qualification){
        return service.createEntity(qualification);
    }

    @PutMapping("/qualifications/{id}")
    public Qualification editQualification(@RequestBody Qualification qualification, @PathVariable Long id){
        return service.updateEntity(qualification, id);
    }

    @DeleteMapping("/qualifications/{id}")
    public Long deleteQualification(@PathVariable Long id) {
        return service.deleteEntityById(id);
    }
}