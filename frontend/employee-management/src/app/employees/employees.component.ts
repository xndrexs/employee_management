import { Component, OnInit } from '@angular/core';
import { Employee } from '../models/employee';
import { EmployeeService} from '../services/employee.service';

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.scss']
})
export class EmployeesComponent implements OnInit {
  employees: Employee[];

  constructor(
    private service: EmployeeService
  ) { }

  ngOnInit() {
    this.initEmployees();
  }

  initEmployees(): void {
    this.service.getEmployees().subscribe(employees => this.employees = employees);
  }
}
