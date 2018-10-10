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
  selectedEmployee: Employee;
  onSelect(employee: Employee): void {
    this.selectedEmployee = employee;
  }
  getEmployees(): void {
    this.service.getEmployees().subscribe(employees => this.employees = employees);
  }
  constructor(private service: EmployeeService) { }

  ngOnInit() {
    this.getEmployees();
  }

}
