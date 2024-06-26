import { CommonModule } from '@angular/common';
import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { Card, cards } from "fab-cards";
import { FabDbService } from '../service/fabDb.service';
import { Card as FabCard } from "fab-cards";
import { map } from 'rxjs';

@Component({
  selector: 'app-card-select',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './card-select.component.html',
  styleUrl: './card-select.component.scss'
})
export class CardSelectComponent implements OnInit{
  @Input() cardLimiters: any;
  @Input() cardList: Array<any> = [];
  @Output() quit = new EventEmitter<string>();
  @Output() selectedCard = new EventEmitter<Card>();
  private fabDbService: FabDbService;
  constructor(fabDbService: FabDbService){
    this.fabDbService = fabDbService;
  }
  public validCards: any = new Array();
  public validRareCards: any = new Array();
  public validMajesticCards: any = new Array();
  public cardsToShow: any = new Array();
  ngOnInit(): void{
    this.cresteCardList();
    for (let i =0;i < 3;) {
      let response = this.pullCard();
      if(this.cardList.some(card => card.identifier === response.identifier)){
        console.log("Card already in deck")
    }
      else if((response.types.includes("Equipment") && !response.types.includes("Action")) || response.types.includes('Weapon')) {
        console.log("Invalid card pulled")
      } else {
        i++;
        if(!response.defaultImage.includes('.png')) {
          let cardLocation = response.defaultImage.split('.');
          response.defaultImage = this.fabDbService.getImageUrl(cardLocation[0]);
        }else {
          console.log("Image already in correct format")
        }
        this.cardsToShow.push(response);
      }
      
    }
  }

  public cresteCardList(){
    cards.forEach(card => {
      card.keywords?.forEach(keyword => {
        const text = card.functionalText;
        let rarity: String = card.rarity;
        let isHeroType = false
        let isClass = false;
        card.talents?.forEach(talents => { 
          if(this.cardLimiters.hero.keywords.includes(talents.toLowerCase())) {
            isClass = true;
          }
        });
        card.classes.find(cls => this.cardLimiters.hero.keywords.forEach((keyword: string) => {
          if(cls.toLowerCase() === keyword.toLowerCase()) {
            isHeroType = true;
          }
        }));

        if((card.rarity === "Majestic" || card.rarity === "Super Rare" ||
            card.rarity === "Rare")){
          if(rarity === "Super Rare") {
            rarity = "Majestic";
          } 
          if((isHeroType && !isClass) || (isHeroType || (isHeroType && isClass) || (isClass && card.classes.find(cls => cls === "Generic")))){
            
            if(text?.includes("Specialization")) {
              let cardSpec= card.specializations;
              if(cardSpec != undefined && this.cardLimiters.hero.name.includes(cardSpec[0])) {
                (this as any)["valid" + rarity + "Cards"].push(card);
              }
            }else { 
              (this as any)["valid" + rarity + "Cards"].push(card);
            }
          } else if(card.classes.find(cls => cls === "Generic")) {
            (this as any)["valid" + rarity + "Cards"].push(card);
          }
        }
        });
      });
  }

  public pullCard() {
    const randomNumber = Math.random(); 
    let card;
    if (randomNumber < 0.9 && this.validRareCards.length > 0) {
      card = this.validRareCards[Math.floor(Math.random() * this.validRareCards.length)];
    } else if (this.validMajesticCards.length > 0) {
      card = this.validMajesticCards[Math.floor(Math.random() * this.validMajesticCards.length)];
    }
    return card;
  }

  public choseCard(card: Card){
  // this.fabDbService.getCardData(card.setIdentifiers[0]).subscribe((data: Card) => {
    this.selectedCard.emit(card);
  // });
  }

  public returnHome(){
    this.quit.emit('quit');
  }
}
