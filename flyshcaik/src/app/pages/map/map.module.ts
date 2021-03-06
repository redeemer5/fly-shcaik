import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';
import { MapPageRoutingModule } from './map-routing.module';
import { RouterModule } from '@angular/router';


import { MapPage } from './map.page';


@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    MapPageRoutingModule,
    RouterModule.forChild([
      {
        path: '',
        component: MapPage
      }
    ])
  ],
  declarations: [MapPage]
})
export class MapPageModule {}
