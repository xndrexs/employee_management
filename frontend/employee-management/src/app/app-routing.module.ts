import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeesComponent} from './employees/employees.component';
import { EmployeeDetailComponent} from './employee-detail/employee-detail.component';
import { EmployeeMgmtNewComponent } from './employee-mgmt/employee-mgmt-new.component';
import { EmployeeMgmtEditComponent } from './employee-mgmt/employee-mgmt-edit.component';

const routes: Routes = [
  { path: '', redirectTo: 'employees', pathMatch: 'full'},
  { path: 'employees', component: EmployeesComponent },
  { path: 'employees/create', component: EmployeeMgmtNewComponent },
  { path: 'employees/:id', component: EmployeeDetailComponent },
  { path: 'employees/:id/edit', component: EmployeeMgmtEditComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
