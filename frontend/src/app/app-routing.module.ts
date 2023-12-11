import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserListComponent } from './user-list/user-list.component';
import { UserinfoComponent } from './userinfo/userinfo.component';

const routes: Routes = [
   {path: '', component:UserListComponent},
   {path: 'users', component: UserListComponent},
   {path: 'user-info', component:UserinfoComponent},
   {path: 'user-info/:id', component:UserinfoComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
