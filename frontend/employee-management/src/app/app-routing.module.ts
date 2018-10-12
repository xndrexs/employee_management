import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeesComponent} from './employees/employees.component';
import { EmployeeDetailComponent} from './employee-detail/employee-detail.component';
import {EmployeeMgmtComponent} from './employee-mgmt/employee-mgmt.component';

const routes: Routes = [
  { path: '', redirectTo: 'employees', pathMatch: 'full'},
  { path: 'employees', component: EmployeesComponent },
  { path: 'employees/:id', component: EmployeeDetailComponent},
  { path: 'new', component: EmployeeMgmtComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
