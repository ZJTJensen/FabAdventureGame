import { CommonModule } from '@angular/common';
import { Component, Input, OnInit } from '@angular/core';
import { cards } from "fab-cards";

@Component({
  selector: 'app-card-select',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './card-select.component.html',
  styleUrl: './card-select.component.scss'
})
export class CardSelectComponent implements OnInit{
  @Input() cardLimiters: any;
  constructor(){}
  public validCards: any = new Array();
  public validSuperCards: any = new Array();
  public validRareCards: any = new Array();
  public validMajesticCards: any = new Array();
  ngOnInit(): void{
   cards.forEach(card => {
    card.keywords?.forEach(keyword => {
      const text = card.functionalText;
      let rarity: String = card.rarity;
      if((card.rarity === "Majestic" || card.rarity === "Super Rare" ||
          card.rarity === "Rare")){
        if(rarity === "Super Rare") {
          rarity = "Super";
        } 
        if(card.classes.find(cls => cls === keyword.toString())){
          if(text?.includes("Specialization")) {
            if(text?.includes(this.cardLimiters)) {
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
    this.validCards = this.validCards;
  }
}
