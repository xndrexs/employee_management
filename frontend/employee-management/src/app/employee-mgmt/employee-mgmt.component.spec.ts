import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeMgmtNewComponent } from './employee-mgmt-new.component';

describe('EmployeeMgmtNewComponent', () => {
  let component: EmployeeMgmtNewComponent;
  let fixture: ComponentFixture<EmployeeMgmtNewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeMgmtNewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeMgmtNewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
