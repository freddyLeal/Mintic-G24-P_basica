import { Component, OnInit } from '@angular/core';
import { ModalController } from '@ionic/angular';
import { AddToWalletModalPage } from '../add-to-wallet-modal/add-to-wallet-modal.page';
import { SendRequestService } from '../services/send-request.service';

@Component({
  selector: 'app-tab2',
  templateUrl: 'tab2.page.html',
  styleUrls: ['tab2.page.scss']
})
export class Tab2Page implements OnInit {

  userInfo : any = {};
  walletLog: any[] = [];

  constructor(private sendRequestService: SendRequestService, private modalController: ModalController) {}

  ngOnInit(){
    this.getUserInfo();
    this.getWalletLog();
  }


  getUserInfo(){
    this.sendRequestService.sendRequestGet("http://localhost:8080/app/get_user_by_id/1").subscribe(
      data => {
        this.userInfo = data;
        console.log( this.userInfo)
      },
      error => {
        this.sendRequestService.processError( error );
      }
    )
  }


  getWalletLog(){
    this.sendRequestService.sendRequestGet("http://localhost:8080/app/get_wallet_log_by_wallet/1").subscribe(
      data => {
        this.walletLog = <any[]> data;
        console.log( this.userInfo)
      },
      error => {
        this.sendRequestService.processError( error );
      }
    )
  }


  async prepareAddToWallet(){
    const modal = await this.modalController.create({
      component: AddToWalletModalPage,
      componentProps: {id: this.userInfo.wallet.id}
    });
    await modal.present();

    const { data } = await modal.onDidDismiss();

    if( data === true){
      this.getUserInfo();
      this.getWalletLog();
    }
  }


  prepareRetireToWallet(){
    alert("Por hacer");
  }


}
