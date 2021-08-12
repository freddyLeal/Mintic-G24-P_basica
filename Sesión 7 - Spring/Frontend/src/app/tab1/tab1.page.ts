import { Component, OnInit } from '@angular/core';
import { SendRequestService } from '../services/send-request.service';

@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss']
})
export class Tab1Page implements OnInit {

  userInfo: any = {};

  constructor(private sendRequestService: SendRequestService) {}


  ngOnInit(){
    this.getUserInfo();
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

}
