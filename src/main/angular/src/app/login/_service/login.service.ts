import {Injectable} from '@angular/core';


/*
*  SRC: br.com.jax.ws.rs.controller.login
*/
@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor() {
  }


   doLogin = async (email: String, password: String) : Promise<Response> => {
     return await fetch('http://localhost:8080/api/login', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        email: email,
        password: password
      })
    });
  }




}
