import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute} from '@angular/router';
import { Location} from '@angular/common';
import { Employee} from '../models/employee';
import { EmployeeService} from '../services/employee.service';

@Component({
  selector: 'app-employee-detail',
  templateUrl: './employee-detail.component.html',
  styleUrls: ['./employee-detail.component.scss']
})

export class EmployeeDetailComponent implements OnInit {
  @Input() employee: Employee;
  getEmployee(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.service.getEmployee(id).subscribe(employee => this.employee = employee);
  }
  goBack(): void {
    this.location.back();
  }
  constructor(
    private service: EmployeeService,
    private location: Location,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.getEmployee();
  }
}
