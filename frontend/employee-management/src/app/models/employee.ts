import {Qualification} from './qualification';

export class Employee {
  id: number;
  firstName: string;
  lastName: string;
  position: string;
  degree: string;
  citizenship: string;
  qualifications: Qualification[];

  constructor() {
    this.qualifications = [];
  }
}
