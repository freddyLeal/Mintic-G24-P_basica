import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AlertController } from '@ionic/angular';
import { tap } from 'rxjs/operators';


@Injectable({
	providedIn: 'root'
})
export class SendRequestService {

	loadingModalCount = 0;
	userInformationSended = false;

	constructor(private http: HttpClient,
		private alertController: AlertController) {
	}
	


	sendRequest(method: string, params: any) {
		return this.http.post(method, params);
	}


	sendRequestGet(method: string) {
		return this.http.get(method);
	}


	processError( error: any ) {
		if ( error.status === 400 ) {
			this.presentError( error.error.detail );
		} else if ( error.status === 401 ) {
			this.presentError('Upsss!!! something went wrong.');
		} else if ( error.status === 405 || error.status === 403 ) {
			this.presentError('You do not have the necessary permits to perform this action.');
		} else if ( error.status === 500 ) {
			this.presentError('Upsss!!! something went wrong.');
		} else {
			console.log( error );
			this.presentError('Unexpected error. We are trying to solve the problem.');
		}
	}


	async presentError(text) {
		const alert = await this.alertController.create({
			header: 'Error',
			subHeader: '',
			message: text,
			buttons: ['Ok']
		});

		await alert.present();
	}


	async presentMessage(headerText,text) {
		const alert = await this.alertController.create({
			header: headerText,
			subHeader: '',
			message: text,
			buttons: ['Ok']
		});

		await alert.present();
	}


}
