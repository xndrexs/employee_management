import { Component, OnInit } from '@angular/core';
import { Qualification } from '../models/qualification';
import { QualificationService } from '../services/qualification.service';
import { EmployeeService } from '../services/employee.service';
import { Employee } from '../models/employee';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-employee-mgmt',
  templateUrl: './employee-mgmt.component.html',
  styleUrls: ['./employee-mgmt.component.scss']
})
export class EmployeeMgmtComponent implements OnInit {
  id: number;
  employees: Employee[];
  qualifications: Qualification[];
  employee = new Employee();
  getQualifications(): void {
    this.qualificationService.getQualifications().subscribe(qualifications => this.qualifications = qualifications);
  }
  getEmployees(): void {
    this.employeeService.getEmployees().subscribe(employees => this.employees = employees);
  }
  postEmployee(): void {
    this.employeeService.postEmployee(this.employee).subscribe(employee => this.employees.push(employee));
  }
  putEmployee(): void {
    this.employeeService.putEmployee(this.employee, this.employee.id).subscribe(employee => this.employees.push(employee));
  }
  getEmployee(): void {
    this.id = +this.route.snapshot.paramMap.get('id');
    this.employeeService.getEmployee(this.id).subscribe(employee => this.employee = employee);
  }
  constructor(
    private qualificationService: QualificationService,
    private employeeService: EmployeeService,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    this.getQualifications();
    this.getEmployees();
    this.getEmployee();
  }
}