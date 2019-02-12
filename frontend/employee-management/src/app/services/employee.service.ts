import { Injectable } from '@angular/core';
import { Employee } from '../models/employee';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AppConfig } from '../app-config';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Injectable()
export class EmployeeService {

  private employeesUrl = 'employees/';
  private url = AppConfig.getUrl(this.employeesUrl);

  constructor(
    private httpClient: HttpClient,
  ) { }

  getEmployees(): Observable<Employee[]> {
    return this.httpClient.get(this.url) as Observable<Employee[]>;
  }

  getEmployee(id: number): Observable<Employee> {
    return this.httpClient.get(this.url + id) as Observable<Employee>;
  }

  postEmployee(employee: Employee): Observable<Employee> {
    return this.httpClient.post(this.url, employee, httpOptions) as Observable<Employee>;
  }

  putEmployee(employee: Employee, id: number): Observable<Employee> {
    return this.httpClient.put(this.url + id, employee, httpOptions) as Observable<Employee>;
  }

  deleteEmployee(id: number): Observable<number> {
    return this.httpClient.delete(this.url + id) as Observable<number>;
  }
}
