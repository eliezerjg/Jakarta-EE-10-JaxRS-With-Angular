import {Component} from '@angular/core';
import {FormsModule} from "@angular/forms";
import {LoginService} from "../_service/login.service";

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  loginService = new LoginService();

  email: string = '';
  password: string = '';

  async onSubmit() {
    const response = await this.loginService.doLogin(this.email, this.password);

    response.text().then((result) => {
      alert(result);
    });

  }
}
