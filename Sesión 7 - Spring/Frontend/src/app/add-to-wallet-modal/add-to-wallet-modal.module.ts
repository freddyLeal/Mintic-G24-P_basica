import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { AddToWalletModalPageRoutingModule } from './add-to-wallet-modal-routing.module';

import { AddToWalletModalPage } from './add-to-wallet-modal.page';
import { Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    component: AddToWalletModalPage
  }
];


@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule
  ],
  declarations: [AddToWalletModalPage]
})
export class AddToWalletModalPageModule {}
