import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AppConfig } from '../app-config';
import { Qualification } from '../models/qualification';

@Injectable()
export class QualificationService {
  private qualificationsUrl = 'qualifications/';
  constructor(
    private httpClient: HttpClient
  ) { }
  getQualifications(): Observable<Qualification[]> {
    return this.httpClient.get<Qualification[]>(AppConfig.getUrl(this.qualificationsUrl));
  }
}
