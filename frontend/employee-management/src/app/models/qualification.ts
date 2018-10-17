import {Employee} from './employee';

export class Qualification {
  id: number;
  name: string;
  img: string;
  employees: Employee[];
  selected?: boolean;
}
