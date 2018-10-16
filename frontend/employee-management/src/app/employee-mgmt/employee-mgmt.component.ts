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
export class EmployeeMgmtComponent implements OnInit {
  id: number;
  qualifications: Qualification[];
  employee = new Employee();
  getQualifications(): void {
    this.qualificationService.getQualifications().subscribe(qualifications => this.qualifications = qualifications);
  }
  // TODO: Remove this when we're done
  get diagnostic() { return JSON.stringify(this.employee); }
  select(qualification: Qualification) {
    console.log(qualification.name)
    this.employee.qualifications.push(qualification);
  }
  onSubmit() {
    if (!this.employee.id) {
      this.employeeService.postEmployee(this.employee).subscribe(() => {
        return this.router.navigate(['/employees']);
      });
    } else {
      this.employeeService.putEmployee(this.employee, this.employee.id).subscribe(() => {
        return this.router.navigate(['/employees']);
      });
    }
  }
  getEmployee(): void {
    this.id = +this.route.snapshot.paramMap.get('id');
    if (this.id) {
      this.employeeService.getEmployee(this.id).subscribe(employee => this.employee = employee);
    }
  }
  constructor(
    private qualificationService: QualificationService,
    private employeeService: EmployeeService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit() {
    this.getQualifications();
    this.getEmployee();
  }
}
