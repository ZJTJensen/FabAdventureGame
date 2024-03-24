import { Injectable } from '@angular/core';
import { deck } from '../models/decks';
import { HttpClient } from '@angular/common/http';
import { Head, Observable, map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdventureServiceService {
  private http: HttpClient;
  constructor(http: HttpClient) { 
    this.http = http;
  }

  configUrl = 'https://umiv3r4ar5azlhtlitvy7jozqu.appsync-api.us-east-2.amazonaws.com/graphql';
decks: any;

getDeck(): Observable<any> {
  let data = {"query":"query getDeck($deckId: ID!) {\n  getDeck(deckId: $deckId) {\n    deckId\n    author {\n      userId\n      patreon {\n        status\n      }\n      patreonPreferences {\n        nameFoiling\n        profilePicture\n      }\n      publicProfile {\n        isPrivate\n        nickname\n      }\n    }\n    deckCards {\n      cardIdentifier\n      deckId\n      card {\n        ...DatabaseCard\n      }\n      blocked\n      pitched\n      played\n      matchupQuantities {\n        matchupId\n        quantity\n        sideboardQuantity\n      }\n      quantity\n      sideboardQuantity\n      maybeQuantity\n    }\n    format\n    hero {\n      ...DatabaseCard\n      heroInformation {\n        livingLegendStart\n      }\n    }\n    heroIdentifier\n    isUsersFavorite {\n      userId\n      deckId\n      favoritedAt\n    }\n    name\n    notes\n    originalDeckId\n    originalDeck {\n      name\n      author {\n        userId\n        publicProfile {\n          isPrivate\n          nickname\n        }\n      }\n    }\n    proxyAuthor\n    tags\n    tournament\n    matchups {\n      matchupId\n      goFirst\n      name\n      notes\n      preferredTurnOrder\n    }\n    plays\n    preferredTurnOrder\n    userId\n    versions {\n      deckId\n      deckVersionId\n      deckCards {\n        card {\n          ...FullCard\n        }\n        cardIdentifier\n        quantity\n        sideboardQuantity\n        maybeQuantity\n      }\n      matchups {\n        matchupId\n      }\n      notes\n      version\n      youtube {\n        id\n      }\n      createdAt\n    }\n    visibility\n    wins\n    youtube {\n      author\n      id\n      title\n    }\n    createdAt\n    updatedAt\n  }\n}\n\nfragment DatabaseCard on Card {\n  ...CardCollection\n  ...CardPricing\n  ...FullCard\n}\n\nfragment CardCollection on Card {\n  collection {\n    have\n  }\n}\n\nfragment CardPricing on Card {\n  printingsWithPrices {\n    ...PrintingWithPrices\n  }\n}\n\nfragment PrintingWithPrices on PrintingWithPrices {\n  artist\n  edition\n  foiling\n  identifier\n  image\n  print\n  set\n  treatment\n  flukeAndBox {\n    ...PricesFragment\n  }\n  minMax {\n    ...PricesFragment\n  }\n  tcgplayer {\n    ...PricesFragment\n  }\n}\n\nfragment PricesFragment on Pricing {\n  name\n  prices {\n    currency\n    price\n  }\n  productId\n  quantity\n  url\n}\n\nfragment FullCard on Card {\n  ...CardMatchingPrinting\n  ...FullOneSidedCard\n  oppositeSideCard {\n    ...FullOneSidedCard\n  }\n}\n\nfragment CardMatchingPrinting on Card {\n  matchingPrintings {\n    edition\n    foiling\n    identifier\n    image\n    set\n    treatment\n  }\n}\n\nfragment FullOneSidedCard on Card {\n  artists\n  bannedFormats\n  cardIdentifier\n  classes\n  cost\n  defaultImage\n  defense\n  functionalText\n  fusions\n  hero\n  isActive\n  isCardBack\n  keywords\n  name\n  oppositeSideCardIdentifier\n  rarity\n  restrictedFormats\n  specialCost\n  specialDefense\n  specialImage\n  specializations\n  specialPower\n  subtypes\n  types\n  pitch\n  power\n  rarities\n  sets\n  setIdentifiers\n  talents\n  typeText\n  young\n  ...CardPrinting\n}\n\nfragment CardPrinting on Card {\n  printings {\n    edition\n    foiling\n    identifier\n    image\n    set\n    treatment\n  }\n}\n","variables":{"deckId":"01HNN74AQMMR37M1Z328T32ACD"}}
  let headers = {headers: {
    authorization: 'eyJraWQiOiJYZ2VmbVZaalA0N2ttNzM3VDlVOTIwTnl3bkRNTFYyMW5WN3cxREFHSFwvcz0iLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiI0ZWM3NThlNC1mNDgwLTQ3MzItYjY1Yi03MzBhMWEwM2ZlNzQiLCJpc3MiOiJodHRwczpcL1wvY29nbml0by1pZHAudXMtZWFzdC0yLmFtYXpvbmF3cy5jb21cL3VzLWVhc3QtMl9acVJCWG1nZWEiLCJjbGllbnRfaWQiOiI4YjhwbTI4YTZrMjVwZGxnYnA2YzhlcTRlIiwib3JpZ2luX2p0aSI6ImI4ZGE4N2Q3LTM1OGItNDYzZS05OTZiLTE5MGFmODlmODgyZiIsImV2ZW50X2lkIjoiMTViY2QxMDMtMGIyNC00ZDZmLWJiZGItMzkyNjk5ZjNiNzk1IiwidG9rZW5fdXNlIjoiYWNjZXNzIiwic2NvcGUiOiJhd3MuY29nbml0by5zaWduaW4udXNlci5hZG1pbiIsImF1dGhfdGltZSI6MTcxMDg3NTQ3MywiZXhwIjoxNzExMzA4NDcyLCJpYXQiOjE3MTEzMDQ4NzIsImp0aSI6IjljZDcwM2UyLWQ2NGMtNGI2ZC05NjBlLTY0ZWRmOGJhOGJhMyIsInVzZXJuYW1lIjoiNGVjNzU4ZTQtZjQ4MC00NzMyLWI2NWItNzMwYTFhMDNmZTc0In0.lxI9q3Eal3WC_u-N_OR1GvVseohQ5qmtzjQGu6HYjGL05h5TpPcvCZiHrUm2eLCkOoqyrxtJiAcA1AXg3rIgqH6TIBWt7AtuY8xKZnTXiwdT9J1-Jpk71ao_5JhFLh0hZVB1ugE0eCKN29xJibAZbyls4toumHnujtQVokG15dlpTS5KKaBz0XJ7UJFbW4BT5Zb22gw0OhLhyTUY-wBpMYtfHr2uG6atFKirRWflWl4b_QVRc5a46sBvc5AHiIOpJQNvKNMngz9opp8rwkQmT9lXQrUQH-uX-lbzGOT1RCSPmQ1MgohqpBR2Rxgs_80d46WVV71X_fJT5OrT_BNLeA'}
  }
  return this.http.post<any>(this.configUrl, data, headers).pipe(
    map(decks=> decks) );

}
}
