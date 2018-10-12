import { Injectable } from '@angular/core';
import { Employee } from '../models/employee';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AppConfig } from '../app-config';

@Injectable()
export class EmployeeService {
  private employeesUrl = 'employees/';
  constructor(
    private httpClient: HttpClient
  ) { }
  getEmployees(): Observable<Employee[]> {
    return this.httpClient.get<Employee[]>(AppConfig.getUrl(this.employeesUrl));
  }
  getEmployee(id: number): Observable<Employee> {
    return this.httpClient.get<Employee>(AppConfig.getUrl(this.employeesUrl) + id);
  }
}
