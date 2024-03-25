import { Injectable } from '@angular/core';
import { Deck } from '../models/decks';
import { HttpClient } from '@angular/common/http';
import { Observable, map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdventureServiceService {
  private http: HttpClient;
  constructor(http: HttpClient) { 
    this.http = http;
  }

  configUrl = 'https://api.fabdb.net/decks/';

getDeck(deckUrl: string): Observable<Deck> {
  const fianlUrl = this.configUrl + deckUrl.substring(deckUrl.lastIndexOf('/') + 1);

  return this.http.get<Deck>(fianlUrl);

}
}
