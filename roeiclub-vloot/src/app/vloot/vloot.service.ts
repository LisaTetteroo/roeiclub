import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})

export class VlootService {
  baseurl: string = "http://localhost:8082";

  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({
        'Content-Type': 'application/json'
    })
  }

  //GET
  getVloot(): Observable<any> {
    return this.http.get<any>(this.baseurl + "/botenInzien");
  }

}
