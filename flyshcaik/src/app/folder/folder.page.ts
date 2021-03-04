import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {HttpService} from '../services/http.service';
import { book } from '../services/cart.service';

@Component({
  selector: 'app-folder',
  templateUrl: './folder.page.html',
  styleUrls: ['./folder.page.scss'],
})
export class FolderPage implements OnInit {
  public folder: string;

  constructor(private activatedRoute: ActivatedRoute,public http:HttpService) { }

  books;



  ngOnInit() {
    this.folder = this.activatedRoute.snapshot.paramMap.get('id');

    this.http.viewAllBooks().subscribe(http=>{
      this.books = http;
    })
  }


  name(id)
  {
    console.log(id)
  }
}
