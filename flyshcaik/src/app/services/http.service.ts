import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import {Orders} from '../interfaces/orders';



@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private http:HttpClient) { }


      // Http Options
      httpOptions = {
        headers: new HttpHeaders({
          'Content-Type': 'application/json',
          'Access-Control-Allow-Origin': '*',
          'Access-Control-Allow-Methods': 'GET, PUT, POST, OPTIONS',
          'Access-Control-Allow-Headers': '*'
        })
      }
    
        // Handle API errors
        handleError(error: HttpErrorResponse) {
          if (error.error instanceof ErrorEvent) {
            // A client-side or network error occurred. Handle it accordingly.
            console.error('An error occurred:', error.error.message);
          } else {
            // The backend returned an unsuccessful response code.
            // The response body may contain clues as to what went wrong,
            console.error(
              `Backend returned code ${error.status}, ` +
              `body was: ${error.error}`);
          }
          // return an observable with a user-facing error message
          return throwError(
            'Something bad happened; please try again later.');
        };

     viewbooksbyfield(field)
    {
      // return this.http.get('http://localhost:8080/viewbook/' + field);
      return this.http.get('https://hidden-savannah-79994.herokuapp.com/viewbook/' + field);

    }

    viewAllBooks()
    {
      // return this.http.get('http://localhost:8080/viewbooks');
      return this.http.get('https://hidden-savannah-79994.herokuapp.com/viewbooks');
    }

    viewbookbytitle(title)
    {
      // return this.http.get('http://localhost:8080/viewbooks/' + title);
      return this.http.get('https://hidden-savannah-79994.herokuapp.com/viewbooktitle/' + title);
    }

    postOrder(bookrequest,email,ordernumber,library,item): Observable<Orders> {
      return this.http
        .post<Orders>('https://hidden-savannah-79994.herokuapp.com/bookrequest/' + email + '/' +ordernumber + '/' + library + '/' + item, JSON.stringify(bookrequest), this.httpOptions)
        .pipe(
          retry(2),
          catchError(this.handleError)
        )
    }



    registerUser(user): Observable<Orders> {
      return this.http
        .post<Orders>('https://hidden-savannah-79994.herokuapp.com/adduser', JSON.stringify(user), this.httpOptions)
        .pipe(
          retry(2),
          catchError(this.handleError)
        )
    }

    getEmailAndPassword(email,password)
    {
      // return this.http.get('http://localhost:8080/getemailpassword/' + email + '/' + password);

      return this.http.get('https://hidden-savannah-79994.herokuapp.com/getemailpassword/' + email + '/' + password);
    }


    viewPastOrder(email)
    {
      return this.http.get('https://hidden-savannah-79994.herokuapp.com/viewPastRequests/' + email);
    }

    viewUserById(id)
    {
      return this.http.get('https://hidden-savannah-79994.herokuapp.com/viewuser/' + id);
    }

    updateUserDetails(id)
    {
      return this.http.get('https://hidden-savannah-79994.herokuapp.com/updateUser/' + id);
    }

    cancelRequest(id)
    {
      return this.http.delete('https://hidden-savannah-79994.herokuapp.com/cancelRequest/' + id);
    }

}
