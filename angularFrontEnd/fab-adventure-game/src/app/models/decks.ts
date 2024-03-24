export class users {
    id!: number 
    username!: string
    wins!: string
    level!: number
    deckLink!: string
    created_at!: string
}

export class decks {
    fabrary_link!: string
    user_id!: number
    current_deck_list!: Array<deck>
}

export class deck {
    cardName!: string
    cardPrice!: string
    armorFlag!: string
    cardRarity!: string
  
}