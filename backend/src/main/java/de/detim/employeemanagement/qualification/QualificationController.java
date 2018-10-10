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

    @GetMapping("/{qualificationId}")
    public Qualification findEntity(@PathVariable Long qualificationId){
        return qualificationService.findEntity(qualificationId);
    }

    @PostMapping("/")
    public Qualification createEntity(@RequestBody Qualification qualification){
        return qualificationService.createEntity(qualification);
    }

    @PutMapping("/{qualificationId}")
    public Qualification updateEntity(@RequestBody Qualification qualification, @PathVariable Long qualificationId){
        return qualificationService.updateEntity(qualification, qualificationId);
    }

    @DeleteMapping("/{qualificationId}")
    public Long deleteEntity(@PathVariable Long qualificationId) {
        return qualificationService.deleteEntityById(qualificationId);
    }
}