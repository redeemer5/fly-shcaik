import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import {HttpService} from '../../services/http.service';
import * as _ from 'lodash' ;
import { NavController } from '@ionic/angular';
import {CartService} from '../../services/cart.service';
import { LoadingController } from '@ionic/angular';






@Component({
  selector: 'app-field',
  templateUrl: './field.page.html',
  styleUrls: ['./field.page.scss'],
})

export class FieldPage implements OnInit {

  
  field;
  books:any;
  books$:any;
  cart = [];
  items = [];

  constructor(public loadingController: LoadingController,public route: ActivatedRoute,public http:HttpService,public navCtrl:NavController,public cartservice:CartService) 
  {
    this.field = this.route.snapshot.paramMap.get('field');
  }

  ngOnInit() {
    this.cart = this.cartservice.getCart();
    this.items = this.cartservice.getProducts();

    this.showLoader();
    this.http.viewbooksbyfield(this.field).subscribe(http=>{
      this.hideLoader();
      this.books$ = http;
    })

  }

  doRefresh(event) {
    console.log('Begin async operation');
    this.ngOnInit();
    setTimeout(() => {
      console.log('Async operation has ended');
      event.target.complete();
    }, 2000);
  }

  filterJsonData(ev:any)
  {
    // this.initializeJsonData();
    const val= ev.target.value;
    if(val && val.trim() != '')
    {
      this.books$ = this.books$.filter((item)=>{
        return (item.author.toLowerCase().indexOf(val.toLowerCase())> -1 || item.booktitle.toLowerCase().indexOf(val.toLowerCase())> -1)
      })
    }
  }

  refresh()
  {
    this.ngOnInit();
  }

  addToCart(book)
  {
    this.cartservice.addProduct(book);
  }

  openCart()
  {
    this.navCtrl.navigateForward('/cart');
  }

  clearCart()
  {
    this.cartservice.getCart().length = 0;
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
