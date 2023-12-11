import { Component, OnInit, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { user } from '../modules/user/user';
import { Router } from '@angular/router';
import { UserServices } from '../services/user.service';
import { NgxSpinnerService } from 'ngx-spinner';
@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit{
  router: Router = inject(Router);
  users:user[]=[]
  page = 1
  perPage = 6;
  totalPage = 1;
  constructor(private http : HttpClient,private userData: UserServices ,private spinner: NgxSpinnerService){}
  ngOnInit(): void {
    this.getUsers();
  }
  getUsers(): void {
    this.spinner.show();
    const url = `https://reqres.in/api/users?page=${this.page}`;

    this.http.get<any>(url).subscribe(response => {
      this.users = response.data;
      this.totalPage = response.total_pages;
      this.spinner.hide(); // Hide the loading spinner
    },
    error => {
      this.spinner.hide(); // Hide the loading spinner

    });

  }

  gatePageCount(start: number): number[] {

    return Array.from({ length: this.totalPage - start + 1 }, (_, index) => index + start);
  }

  pageNow(i : number){
    return (i == this.page)?"active":"";

  }
  getUserFromPage(page : number){
    this.page = page ;
    this.getUsers();
  }
  ShowUserMore(user : user){
    this.userData.setData(user)
    this.router.navigate(['user-info']);
  }

}
