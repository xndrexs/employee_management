package de.detim.employeemanagement.qualification;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/qualifications")
@RestController
public class QualificationController {

    private final QualificationService qualificationService;

    public QualificationController(QualificationService service){
        this.qualificationService = service;
    }

    @GetMapping("/")
    public List<Qualification> findAll(){
        return qualificationService.findAll();
    }

    @GetMapping("/{id}")
    public Qualification findEntity(@PathVariable Long id){
        return qualificationService.findEntity(id);
    }

    @PostMapping("/")
    public Qualification createEntity(@RequestBody Qualification qualification){
        return qualificationService.createEntity(qualification);
    }

    @PutMapping("/{id}")
    public Qualification updateEntity(@RequestBody Qualification qualification, @PathVariable Long id){
        return qualificationService.updateEntity(qualification, id);
    }

    @DeleteMapping("/{id}")
    public Long deleteEntity(@PathVariable Long id) {
        return qualificationService.deleteEntityById(id);
    }
}