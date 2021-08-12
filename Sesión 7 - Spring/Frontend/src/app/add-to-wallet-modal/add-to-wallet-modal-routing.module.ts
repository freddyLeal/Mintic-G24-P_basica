import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AddToWalletModalPage } from './add-to-wallet-modal.page';

const routes: Routes = [
  {
    path: '',
    component: AddToWalletModalPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AddToWalletModalPageRoutingModule {}
