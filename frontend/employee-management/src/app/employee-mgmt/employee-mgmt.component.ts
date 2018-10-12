import { Component, OnInit } from '@angular/core';
import { Qualification } from '../models/qualification';
import { QualificationService } from '../services/qualification.service';

@Component({
  selector: 'app-employee-mgmt',
  templateUrl: './employee-mgmt.component.html',
  styleUrls: ['./employee-mgmt.component.scss']
})
export class EmployeeMgmtComponent implements OnInit {
  qualifications: Qualification[];
  firstName: string;
  lastName: string;
  position: string;
  citizensip: string;
  degree: string;
  getQualifications(): void {
    this.qualificationService.getQualifications().subscribe(qualifications => this.qualifications = qualifications);
  }
  constructor(
    private qualificationService: QualificationService
  ) { }

  ngOnInit() {
    this.getQualifications();
  }

}
