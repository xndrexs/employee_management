import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule} from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeesComponent } from './employees/employees.component';
import { EmployeeDetailComponent } from './employee-detail/employee-detail.component';
import { HttpClientModule} from '@angular/common/http';
import { EmployeeService} from './services/employee.service';
import { EmployeeMgmtNewComponent } from './employee-mgmt/employee-mgmt-new.component';
import { QualificationService } from './services/qualification.service';
import { EmployeeMgmtEditComponent } from './employee-mgmt/employee-mgmt-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    EmployeesComponent,
    EmployeeDetailComponent,
    EmployeeMgmtNewComponent,
    EmployeeMgmtEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    EmployeeService,
    QualificationService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
