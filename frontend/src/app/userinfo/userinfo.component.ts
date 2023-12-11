import { Component, OnInit, Inject } from '@angular/core';
import { UserServices } from '../services/user.service';
import { user } from '../modules/user/user';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { NgxSpinnerService } from 'ngx-spinner';
interface UserSupport {
  url: string;
  text: string;
}

@Component({
  selector: 'app-userinfo',
  templateUrl: './userinfo.component.html',
  styleUrls: ['./userinfo.component.css']
})
export class UserinfoComponent implements OnInit {
  router: Router;
  user!: user;
  support!: UserSupport;
  userId!: number;
  notFound: boolean = false;

  constructor(
    private route: ActivatedRoute,
    private userData: UserServices,
    private http: HttpClient,
    @Inject(Router) router: Router,
    private spinner: NgxSpinnerService
  ) {
    this.router = router;
  }

  ngOnInit(): void {

    this.route.params.subscribe(params => {
      this.userId = +params['id'];
    });

    if (this.userId) {
      this.user = { id: this.userId } as user;
      this.getUser();

    } else {
      this.userData.getData().subscribe(data => {
        this.user = data;
        this.getUser();
        if (!this.user) {
          this.router.navigate(['']);
        }
      });

    }
  }

  getUser() {
    this.spinner.show();
    const url = `https://reqres.in/api/users/${this.user.id}`;
    this.http.get<any>(url).subscribe(
      response => {
        this.support = response.support;
        this.user = response.data;
        this.notFound = false;
        this.spinner.hide();
      },
      error => {
        this.notFound = true;
        this.spinner.hide();
      }
    );
  }
}
