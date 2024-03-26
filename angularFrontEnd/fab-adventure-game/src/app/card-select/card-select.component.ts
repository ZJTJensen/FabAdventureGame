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

  ngOnInit(): void{
   cards.forEach(card => {
    card.keywords?.forEach(keyword => {
      if(card.classes.find(cls => cls === keyword.toString())){
        this.validCards.push(card);
      } else if(card.classes.find(cls => cls === "Generic")) {
        this.validCards.push(card);
      }
      });
    });
  }


}
