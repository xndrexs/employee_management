import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule} from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeesComponent } from './employees/employees.component';
import { EmployeeDetailComponent } from './employee-detail/employee-detail.component';
import { HttpClientModule} from '@angular/common/http';
import { EmployeeService} from './services/employee.service';
import { EmployeeMgmtComponent } from './employee-mgmt/employee-mgmt.component';
import { QualificationService } from './services/qualification.service';

@NgModule({
  declarations: [
    AppComponent,
    EmployeesComponent,
    EmployeeDetailComponent,
    EmployeeMgmtComponent
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
