import { Component, OnInit } from '@angular/core';
import {HttpService} from '../../services/http.service';
import { LoadingController } from '@ionic/angular';


@Component({
  selector: 'app-search',
  templateUrl: './search.page.html',
  styleUrls: ['./search.page.scss'],
})
export class SearchPage implements OnInit {

  books:any;
  books$:any;
  constructor(public http:HttpService,public loadingController: LoadingController) { }

  ngOnInit() {
    this.showLoader();
    this.http.viewAllBooks().subscribe(http=>{
      this.hideLoader();
      this.books$ = http;
    })
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
    // this.ngOnInit();
  }

  doRefresh(event) {
    console.log('Begin async operation');
    this.ngOnInit();
    setTimeout(() => {
      console.log('Async operation has ended');
      event.target.complete();
    }, 2000);
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
