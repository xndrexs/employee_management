import { Injectable } from '@angular/core';
import { Employee } from './employees/employee';
import { EMPLOYEES } from './employees/employees';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaderResponse } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private employeesUrl = 'localhost:8083/employees';
  constructor(
    private httpClient: HttpClient
  ) { }
  getEmployees(): Observable<Employee[]> {
    return this.httpClient.get<Employee[]>(this.employeesUrl);
  }
  getEmployee(id: number): Observable<Employee> {
    return of(EMPLOYEES.find(employee => employee.id === id));
  }
}
