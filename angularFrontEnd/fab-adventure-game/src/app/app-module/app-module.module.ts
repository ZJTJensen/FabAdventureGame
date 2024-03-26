import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FabMainComponent } from '../fab-main/fab-main.component';
import { CardSelectComponent } from '../card-select/card-select.component';



@NgModule({
  declarations: [FabMainComponent, CardSelectComponent],
  imports: [
    CommonModule
  ]
})
export class AppModuleModule { }
