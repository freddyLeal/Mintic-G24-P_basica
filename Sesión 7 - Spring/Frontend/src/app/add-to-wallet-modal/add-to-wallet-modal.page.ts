import { Component, Input, OnInit } from '@angular/core';
import { ModalController } from '@ionic/angular';
import { SendRequestService } from '../services/send-request.service';

@Component({
  selector: 'app-add-to-wallet-modal',
  templateUrl: './add-to-wallet-modal.page.html',
  styleUrls: ['./add-to-wallet-modal.page.scss'],
})
export class AddToWalletModalPage implements OnInit {

  @Input() id;
  itemForm : any = {};
  reloadType : any[] = [];

  constructor(private modalController: ModalController,
    private sendRequestService: SendRequestService) { }

  ngOnInit() {
    this.getReloadTypeList();
  }

  closeModal(){
    this.modalController.dismiss();
  }

  save(){
    if( !this.itemForm.amount ){
      this.sendRequestService.presentMessage("Info!", "Amount is mandatory");
      return;
    }

    if( !this.itemForm.type ){
      this.sendRequestService.presentMessage("Info!", "Type is mandatory");
      return;
    }

    this.sendRequestService.sendRequest('http://localhost:8080/app/set_reload_wallet', {id:this.id, type: this.itemForm.type, amount: this.itemForm.amount}).subscribe(
      data => {
        this.modalController.dismiss( true );
      },
      error => {
        this.sendRequestService.processError(error);
      }
    )
  }

  getReloadTypeList(){
    this.sendRequestService.sendRequestGet("http://localhost:8080/app/get_transaction_type_not_debit").subscribe(
      data => {
        this.reloadType = <any[]> data;
      },
      error => {
        this.sendRequestService.processError(error);
      }
    )
  }

}
