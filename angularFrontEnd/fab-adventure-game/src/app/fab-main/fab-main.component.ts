import { Component } from '@angular/core';
import { AdventureServiceService } from '../service/adventure-service.service';
import { map } from 'rxjs';

@Component({
  selector: 'app-fab-main',
  standalone: true,
  imports: [],
  templateUrl: './fab-main.component.html',
  styleUrl: './fab-main.component.scss'
})
export class FabMainComponent {

  public deckService: AdventureServiceService;
  constructor(deckService: AdventureServiceService){
    this.deckService = deckService
  }
  public response: any = 'true'

  public callService (){
   this.response = this.deckService.getDeck().subscribe(decks => console.log(decks));
  }
}
