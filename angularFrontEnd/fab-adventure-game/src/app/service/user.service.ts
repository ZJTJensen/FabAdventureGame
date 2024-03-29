import { Injectable } from '@angular/core';
import { Deck } from '../models/fabDbDecks';
import { HttpClient } from '@angular/common/http';
import { Observable, map } from 'rxjs';
import { Card } from 'fab-cards';

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
    public setUserInfo(userKey: string, phoneNumber: number, deck: Deck): Observable<any> {
      let userRequest = {
        user: userKey,
        phoneNumber: phoneNumber,
        deck: deck
      }
      return this.http.post<any>('http://localhost:8080/user/create', userRequest, {responseType: 'string' as 'json'})
    }

  
    public addCard(userKey: string, card: Card): Observable<any> {
      let userRequest = {
        user: userKey,
        card: card
      }
      return this.http.post<any>('http://localhost:8080/user/card', userRequest, {responseType: 'string' as 'json'})
    }
}