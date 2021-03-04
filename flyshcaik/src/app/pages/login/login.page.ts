import { Component, OnInit } from '@angular/core';
import { NavController,AlertController } from '@ionic/angular';
import {HttpService} from '../../services/http.service';
import { LoadingController } from '@ionic/angular';



@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {

      // start variables //
      email;
      password;
      ErrorMessage;
      user$:any[];
      users: any;
      user: string;
      users$: Object;

  constructor(public navCtr : NavController,public http:HttpService,public loadingController: LoadingController) { }

  ngOnInit() {
  }

  Login() {

    try
    {

        this.showLoader();
        this.http.getEmailAndPassword(this.email,this.password).subscribe(async (httpCall: any) => {
          this.hideLoader();
        this.user$ = await httpCall;

        if (this.user$.length > 0) 
        {
          // navigate to the next page
          this.navCtr.navigateForward('/folder/Inbox')
  
          // saves user data on the local storage
          localStorage.setItem('userData', JSON.stringify(this.user$[0]));
        } else {
          this.ErrorMessage = 'Email/Password is invalid';
        }
  
      }
      );
    }

    catch(ex)
    {
      console.log("something wrong bro");
    }


  }

          // Show the loader for infinite time
          showLoader() {

            this.loadingController.create({
              message: 'Please wait...'
            }).then((res) => {
              res.present();
            });
        
          }
        
          // Hide the loader if already created otherwise return error
          hideLoader() {
        
            this.loadingController.dismiss().then((res) => {
              console.log('Loading dismissed!', res);
            }).catch((error) => {
              console.log('error', error);
            });
        
          }

}
