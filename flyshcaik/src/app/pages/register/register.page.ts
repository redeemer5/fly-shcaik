import { Component, OnInit } from '@angular/core';
import { NavController,AlertController } from '@ionic/angular';
import {HttpService} from '../../services/http.service';


@Component({
  selector: 'app-register',
  templateUrl: './register.page.html',
  styleUrls: ['./register.page.scss'],
})
export class RegisterPage implements OnInit {

  name:string;
  surname:string;
  cell:number;
  email:string;
  password:string;

  user$: any[];


  constructor( public alertController: AlertController,public navCtr : NavController,public http:HttpService) { }

  ngOnInit() {
  }

  Register()
  {

    let userInfo=
    {

      username: this.name,
      usersurname: this.surname,
      email: this.email,
      usercell: this.cell,
      password: this.password
    }

          // this.hideLoader();
          this.http.registerUser(userInfo).subscribe((response) =>{
          // this.hideLoader();
          this.presentAlertConfirm();
        });

        // saves user data on the local storage
        localStorage.setItem('userData', JSON.stringify(this.user$[0]));
      }

      async presentAlertConfirm() {
        const alert = await this.alertController.create({
          header: 'All done',
          subHeader: 'Thank you for your time',
          message: '<strong>Your registration is completed, You will proceed to the home page!</strong>!!!',
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
                // console.log('Confirm Okay');
                let goTo = '/folder/Inbox';
                this.navCtr.navigateBack(goTo);
              }
            }
          ]
        });
    
        await alert.present();
      }


}
