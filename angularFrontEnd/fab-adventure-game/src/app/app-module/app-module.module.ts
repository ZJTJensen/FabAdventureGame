import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FabMainComponent } from '../fab-main/fab-main.component';
import { CardSelectComponent } from '../card-select/card-select.component';
import { NgxMaskDirective, NgxMaskPipe, provideNgxMask } from 'ngx-mask';



@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    CardSelectComponent,
    FabMainComponent,
    NgxMaskDirective, NgxMaskPipe
  ],
  providers: [provideNgxMask()],
})
export class AppModuleModule { }
