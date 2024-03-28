import { CommonModule } from '@angular/common';
import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { cards } from "fab-cards";
import { FabDbService } from '../service/fabDb.service';

@Component({
  selector: 'app-card-select',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './card-select.component.html',
  styleUrl: './card-select.component.scss'
})
export class CardSelectComponent implements OnInit{
  @Input() cardLimiters: any;
  @Output() quit = new EventEmitter<string>();
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
      if(response.types.includes("Equipment") && !response.types.includes("Action")) {
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
        let isClass = card.talents? card.talents.length > 0 : false;
        card.talents?.forEach(talents => { 
          if(this.cardLimiters.hero.keywords.includes(talents.toLowerCase())) {
            isClass = true;
          } else {
            isClass = false;
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
          if(isHeroType && isClass){
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

  public returnHome(){
    this.quit.emit('quit');
  }
}
