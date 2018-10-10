import { Injectable } from '@angular/core';
import { Employee } from '../models/employee';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class EmployeeService {
  private employeesUrl = 'http://localhost:8083/employees/';
  constructor(
    private httpClient: HttpClient
  ) { }
  getEmployees(): Observable<Employee[]> {
    return this.httpClient.get<Employee[]>(this.employeesUrl);
  }
  getEmployee(id: number): Observable<Employee> {
    return this.httpClient.get<Employee>(this.employeesUrl + id);
  }
}
