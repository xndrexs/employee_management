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
  id: number;
  qualifications: Qualification[];
  employee = new Employee();
  getQualifications(): void {
    this.qualificationService.getQualifications().subscribe(qualifications => this.qualifications = qualifications);
  }
  // TODO: Remove this when we're done
  get diagnostic() {
    return JSON.stringify(this.employee);
  }
  select(qualification: Qualification, checked: Boolean) {
    console.log(qualification.name);
    if (!this.employee.qualifications) {
      this.employee.qualifications = [];
    }
    if (checked) {
      this.employee.qualifications.push(qualification);
    } else {
      this.employee.qualifications.pop();
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
    this.getQualifications();
    this.getEmployee();
  }
}