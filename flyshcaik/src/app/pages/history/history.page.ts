import { Component, OnInit } from '@angular/core';
import {HttpService} from '../../services/http.service';
import { NavController,AlertController } from '@ionic/angular';


@Component({
  selector: 'app-history',
  templateUrl: './history.page.html',
  styleUrls: ['./history.page.scss'],
})
export class HistoryPage implements OnInit {

    // local storage variable
    userData: any = {};
    history:any;

  constructor(private http:HttpService,public alertController: AlertController) 
  
  {
          // get user local storage information
          if (localStorage.getItem('userData') !== undefined) {
            this.userData = JSON.parse(localStorage.getItem('userData'));
          }
  }


  ngOnInit() {
    this.http.viewPastOrder(this.userData.email).subscribe(http=>{
      this.history = http;
    })
  }

  cancelRequest(id)
  {
    this.http.cancelRequest(id).subscribe(http=>{
      this.ngOnInit();
    })
  }

  async presentAlert(id) {
    const alert = await this.alertController.create({
      header: 'Attention',
      subHeader: 'Please confitm this action!',
      message: '<strong>You are about to cancel your reques,Please confirm this action or cancel.</strong>',
      buttons: [
        {
          text: 'Cancel',
          role: 'cancel',
          cssClass: 'secondary',
          handler: (blah) => {
            console.log('Confirm Cancel: blah');
          }
        }, {
          text: 'Okay',
          handler: () => {
            this.cancelRequest(id);
          }
        }
      ]
    });
    await alert.present();
  }

}
