import { Component, OnInit } from '@angular/core';
import {HttpService} from '../../services/http.service';


@Component({
  selector: 'app-user',
  templateUrl: './user.page.html',
  styleUrls: ['./user.page.scss'],
})
export class UserPage implements OnInit {


      // local storage variable
      userData: any = {};
      data:any;


  constructor(private http:HttpService) 
  {
              // get user local storage information
              if (localStorage.getItem('userData') !== undefined) {
                this.userData = JSON.parse(localStorage.getItem('userData'));
              }
  }

  ngOnInit() {
    this.http.viewUserById(this.userData.uid).subscribe(http=>{
      this.data = http;
      console.log(this.data);
    })
  }

}
