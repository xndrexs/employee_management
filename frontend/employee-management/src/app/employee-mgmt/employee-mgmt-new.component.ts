import { Component, OnInit } from '@angular/core';
import { Qualification } from '../models/qualification';
import { QualificationService } from '../services/qualification.service';
import { EmployeeService } from '../services/employee.service';
import { Employee } from '../models/employee';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-employee-mgmt-new',
  templateUrl: './employee-mgmt.component.html',
  styleUrls: ['./employee-mgmt.component.scss']
})
export class EmployeeMgmtNewComponent implements OnInit {
  title = 'Neu';
  qualifications: Qualification[];
  employee: Employee;
  getQualifications(): void {
    this.qualificationService.getQualifications().subscribe(qualifications => {
      this.qualifications = qualifications;
      this.qualifications.forEach(function (qualification) {
        qualification.selected = false;
      });
    });
  }
  // TODO: Remove this when we're done
  get diagnostic() {
    return JSON.stringify(this.employee);
  }
  select(qualification: Qualification) {
    if (!qualification.selected) {
      this.employee.qualifications.push(qualification);
    } else {
      this.employee.qualifications = this.employee.qualifications.filter((q) => qualification.id !== q.id);
    }
  }
  onSubmit() {
    this.employeeService.postEmployee(this.employee).subscribe(() => {
      return this.router.navigate(['/employees']);
    });
  }
  constructor(
    private qualificationService: QualificationService,
    private employeeService: EmployeeService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit() {
    this.getQualifications();
    this.employee = new Employee();
    this.employee.qualifications = [];
  }
}
