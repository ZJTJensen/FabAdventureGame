import { Component, NgModule } from '@angular/core';
import { FabDbService } from '../service/fabDb.service';
import { UserService } from '../service/user.service';
import { Deck, Card } from '../models/fabDbDecks'; 
import { Card as FabCard } from "fab-cards";
import { CommonModule } from '@angular/common';
import { Observable, mergeMap, switchMap, tap } from 'rxjs';
import { CardSelectComponent } from '../card-select/card-select.component';
@Component({
  selector: 'app-fab-main',
  standalone: true,
  imports: [CommonModule, CardSelectComponent],
  templateUrl: './fab-main.component.html',
  styleUrl: './fab-main.component.scss'
})
export class FabMainComponent {

  public deckService: FabDbService;
  public userService: UserService;
  constructor(deckService: FabDbService, userService: UserService){
    this.deckService = deckService,
    this.userService = userService;
  }
  public response: any = new Object() as Deck;
  public deckUrl: string = "";
  public cardList: Array<Card> = new Array<Card>();
  public limiters: any = new Object();
  public isDeckValid: boolean = false;
  public userInfo: any;

  public login() {
    this.getUser().pipe(
      tap(user => console.log('User:', user)),
      switchMap(() => {
        return this.getDeck();
      })
    ).subscribe(
      () => {},
      error => console.error('Error:', error)
    );
    this.checkValidity();
  }
  

  public getUser(): Observable<string>{
    return this.userService.getUserInfo(this.deckUrl);
  }

  public getDeck(): Observable<Deck> {
    return this.deckService.getDeck(this.deckUrl).pipe(
      tap((data: Deck) => {
        this.response = data;
        this.cardList = this.response.cards;
        this.limiters = {
          hero: this.response.cards.find((card: Card) => card.keywords.includes('hero'))
        }
      })
    );
  }
  
  public onKey(event: any){
    this.deckUrl = event.target.value.substring(event.target.value.lastIndexOf('/') + 1)
  }

  public quit(event: string){
    this.response = new Object() as Deck;
    this.isDeckValid = false;
  }
  public cardSelected(event: FabCard){
    this.response = new Object() as FabCard;
  }

  public checkValidity() {
    // this.userInfo.level = 1
    let userLevel = 1;
    let rareCardCount = 0;
    let majesticCount = 0;
    for (let card of this.cardList){
      if(!card.keywords.includes("Hero")){

        if (card.rarity === 'Rare'){
          rareCardCount++;
        }
        if (card.rarity === 'Majestic' || card.rarity === 'Super Rare'){
          majesticCount++;
        }
      }
    }
    if ((rareCardCount +  majesticCount) <= userLevel) {
      this.isDeckValid = true;
    }
  }

}
