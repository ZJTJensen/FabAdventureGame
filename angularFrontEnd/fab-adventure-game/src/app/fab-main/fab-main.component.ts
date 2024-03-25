import { Component } from '@angular/core';
import { AdventureServiceService } from '../service/adventure-service.service';
import { Deck, Card } from '../models/decks'; 
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-fab-main',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './fab-main.component.html',
  styleUrl: './fab-main.component.scss'
})
export class FabMainComponent {

  public deckService: AdventureServiceService;
  constructor(deckService: AdventureServiceService){
    this.deckService = deckService
  }
  public response: Deck = new Object() as Deck;
  public deckUrl: string = 'https://api.fabdb.net/decks/';
  public cardList: Array<Card> = new Array<Card>();

  public callService (){
   this.deckService.getDeck(this.deckUrl).subscribe((data) => {
      this.response = data;
    });
    this.cardList = this.response.cards;

  }
  public onKey(event: any){
    this.deckUrl = event.target.value;
  }
}
