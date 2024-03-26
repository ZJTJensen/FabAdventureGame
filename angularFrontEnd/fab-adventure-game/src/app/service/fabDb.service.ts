import { Injectable } from '@angular/core';
import { Deck } from '../models/fabDbDecks';
import { HttpClient } from '@angular/common/http';
import { Observable, map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FabDbService {
  private http: HttpClient;
  constructor(http: HttpClient) { 
    this.http = http;
  }

  configUrl = 'https://api.fabdb.net/decks/';

getDeck(deckUrl: string): Observable<Deck> {
  return this.http.get<Deck>(this.configUrl + deckUrl);
}
}
