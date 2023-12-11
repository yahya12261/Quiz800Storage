import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { user } from '../modules/user/user';

@Injectable({
  providedIn: 'root'
})
export class UserServices {
 private u : user = {
    id : 0 ,
    email : "",
    avatar : "",
    first_name : "",
    last_name : ""
  }
  private dataSubject = new BehaviorSubject<user>(this.u);

  setData(user: user) {
    this.dataSubject.next(user);
  }

  getData() {
    return this.dataSubject.asObservable();
  }
}
