import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';


export class book { 
  b_id:number;
	booktitle:string;
	author:string;
	field:string;
	version:string;
	quantity:number;
	description:string;
	library:string;
	count:number;
}

@Injectable({
  providedIn: 'root'
})
export class CartService {
  data: book[] = []
  private cart = [];
  private cartItemCount = new BehaviorSubject(0);

  constructor() { }


  addProduct (book: book) {
    let added = false;
    for (let b of this.cart) {
      if (b.b_id === book.b_id) {
        b.count += 1;
        added = true;
        break;
      }
    }
    if (!added) {
      this.cart.push(book);
    }
    this.cartItemCount.next(this.cartItemCount.value + 1);
    console.log(this.cart);
  }

  getCart () {
    return this.cart;
  }

  getProducts () {
    return this.data;
  }


  removeProduct (book) {
    for (let [index, b] of this.cart.entries()) {
      if (b.b_id === book.b_id) {
        this.cartItemCount.next(this.cartItemCount.value - b.count);
        this.cart.splice(index, 1);
      }
    }
  }
}
