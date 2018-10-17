import { Component, OnInit } from '@angular/core';
import { Qualification } from '../models/qualification';
import { QualificationService } from '../services/qualification.service';
import { EmployeeService } from '../services/employee.service';
import { Employee } from '../models/employee';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-employee-mgmt',
  templateUrl: './employee-mgmt.component.html',
  styleUrls: ['./employee-mgmt.component.scss']
})
export class EmployeeMgmtEditComponent implements OnInit {

  title = 'Bearbeiten';
  id: number;
  qualifications: Qualification[];
  employee = new Employee();

  getQualifications(): void {
    this.qualificationService.getQualifications().subscribe(qualifications => {
      this.qualifications = qualifications;
      this.qualifications.forEach((qualification) => {
        const index  = this.employee.qualifications.findIndex(q => qualification.id === q.id );
        qualification.selected = index > -1;
      });
    });
  }

  select(qualification: Qualification) {
    if (!qualification.selected) {
      this.employee.qualifications.push(qualification);
    } else {
      this.employee.qualifications = this.employee.qualifications.filter((q) => q.id !== qualification.id);
    }
  }

  onSubmit() {
    this.employeeService.putEmployee(this.employee, this.employee.id).subscribe(() => {
      return this.router.navigate(['/employees']);
    });
  }

  getEmployee(): void {
    this.id = +this.route.snapshot.paramMap.get('id');
    this.employeeService.getEmployee(this.id).subscribe(employee => this.employee = employee);
  }

  constructor(
    private qualificationService: QualificationService,
    private employeeService: EmployeeService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit() {
    this.getEmployee();
    this.getQualifications();
  }
}
