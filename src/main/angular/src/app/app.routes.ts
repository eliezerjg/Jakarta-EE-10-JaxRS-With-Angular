import { Routes } from '@angular/router';
import {LoginComponent} from "./login/_component/login.component";
import {HomeComponent} from "./home/home.component";

export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: '', component: HomeComponent},
];
