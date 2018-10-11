import {Qualification} from './qualification';

export class Employee {
  id: number;
  firstName: string;
  lastName: string;
  position: string;
  degree: string;
  qualifications: Qualification[];
}
