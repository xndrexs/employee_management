import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router} from '@angular/router';
import { Location } from '@angular/common';
import { Employee } from '../models/employee';
import { EmployeeService } from '../services/employee.service';

@Component({
  selector: 'app-employee-detail',
  templateUrl: './employee-detail.component.html',
  styleUrls: ['./employee-detail.component.scss']
})
export class EmployeeDetailComponent implements OnInit {
  employee: Employee;
  id: number;

  constructor(
    private service: EmployeeService,
    private location: Location,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    this.initEmployee();
  }

  initEmployee(): void {
    this.id = +this.route.snapshot.paramMap.get('id');
    this.service.getEmployee(this.id).subscribe(employee => this.employee = employee);
  }

  goBack(): void {
    this.location.back();
  }

  deleteEmployee(): void {
    this.service.deleteEmployee(this.id).subscribe(() => {
      return this.router.navigate(['/employees']);
    });
  }
}
