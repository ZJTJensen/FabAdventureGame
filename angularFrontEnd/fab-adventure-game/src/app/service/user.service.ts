import { Injectable } from '@angular/core';
import { Deck } from '../models/fabDbDecks';
import { HttpClient } from '@angular/common/http';
import { Observable, map } from 'rxjs';

@Injectable({
    providedIn: 'root'
  })
  export class UserService {
    private http: HttpClient;
    constructor(http: HttpClient) { 
      this.http = http;
    }

    public getUserInfo(userKey: string): Observable<any> {
      let userRequest = {
        user: userKey
      }
      return this.http.post<any>('http://localhost:8080/user/fetch', userRequest, {responseType: 'string' as 'json'})
    }
}