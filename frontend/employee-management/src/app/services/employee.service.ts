import { Injectable } from '@angular/core';
import { Employee } from '../models/employee';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AppConfig } from '../app-config';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Authorization': 'my-auth-token'
  })
};

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
  postEmployee(employee: Employee): Observable<Employee> {
    return this.httpClient.post<Employee>(AppConfig.getUrl(this.employeesUrl), employee, httpOptions);
  }
  putEmployee(employee: Employee, id: number): Observable<Employee> {
    return this.httpClient.put<Employee>(AppConfig.getUrl(this.employeesUrl + id), employee, httpOptions);
  }
  deleteEmployee(id: number): Observable<number> {
    return this.httpClient.delete<number>(AppConfig.getUrl(this.employeesUrl) + id);
  }
}
