import { Component, OnInit } from '@angular/core';
import {CartService,book} from '../../services/cart.service';
import {HttpService} from '../../services/http.service';
import { LoadingController } from '@ionic/angular';
import { NavController,AlertController } from '@ionic/angular';



@Component({
  selector: 'app-cart',
  templateUrl: './cart.page.html',
  styleUrls: ['./cart.page.scss'],
})
export class CartPage implements OnInit {

        // arrays that hold cart products
        cart: book[] = [];
        selectedItems = [];
        today;
        bookData: any = {};
        userdata:any = {};
        selected;


            // order number
    orderNumber:number = Math.floor(Math.random() * 100);

  constructor(public alertController: AlertController,public cartservice:CartService,public http:HttpService,public loadingController: LoadingController,public navCtr : NavController) 
  {
        // user local storage information
        if (localStorage.getItem('bookData') !== undefined) {
          this.bookData = JSON.parse(localStorage.getItem('bookData'));
        }

        // user local storage information
          if (localStorage.getItem('userData') !== undefined) {
            this.userdata = JSON.parse(localStorage.getItem('userData'));
        }
  }

  ngOnInit() {
    this.cart = this.cartservice.getCart();
    console.log(this.cart);
  }

  removeCartItem (product) {
    this.cartservice.removeProduct(product);
  }

  requestBook()
  {
    if(this.selected == null)
    {
      this.dropLocation();
    }
    else
    {
      const now = new Date();
      this.today = now.toISOString();
      for(let book of this.cart)
      {
        let requestDetails = {
   
          ordernumber:this.orderNumber,
          library:book.library,
          date:this.today,
          item:"title: " + book.booktitle + " des: " + book.description + " author: " + book.author,
          name:this.userdata.username,
          surname:this.userdata.usersurname,
          email:this.userdata.email,
          contact:this.userdata.usercell,
          droplocation:this.selected,
          amountdue:0
        }
          // console.log(requestDetails);
        this.presentLoading();
        this.http.postOrder(requestDetails,requestDetails.email,requestDetails.ordernumber,requestDetails.library,requestDetails.item).subscribe((response)=>{
        })
      }
      this.presentAlert();
      this.cartservice.getCart().length = 0;
    }

  }

      // pop up model to tell you that your order is done
      async presentAlert() {
        const alert = await this.alertController.create({
          header: 'All done',
          subHeader: 'Your order is completed',
          message: '<strong>You will recieve an email containing your order details and the restaurant details.!</strong>',
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

      async dropLocation() {
        const alert = await this.alertController.create({
          header: 'Oops',
          subHeader: 'Seems like there is something wrong',
          message: '<strong>Please enter a drop location.!</strong>',
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
                // let goTo = '/folder/Inbox';
                // this.navCtr.navigateBack(goTo);
              }
            }
          ]
        });
        await alert.present();
      }
  
      // ionic loader
      async presentLoading() {
        const loading = await this.loadingController.create({
          message: 'Please wait...',
          duration: 5000
        });
        await loading.present();
    
        const { role, data } = await loading.onDidDismiss();
        console.log('Loading dismissed!');
      }

}
