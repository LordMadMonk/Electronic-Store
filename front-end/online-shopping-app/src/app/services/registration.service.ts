import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { User } from '../models/user.model';
import { firstValueFrom, Observable } from 'rxjs';
import { Login } from '../models/pojos/login.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private static url : string = "http://localhost:8880/User";
  constructor(private _http: HttpClient) { }

  async loginUserFromRemote(login : Login){
    const user$ = this._http.post<User>(UserService.url+"/login",login);
    return await firstValueFrom(user$);
  }

  registerUserFromRemote(user: User){
    this._http.post(UserService.url+"/signup",user).subscribe(data => {
      data = user;
    });
  }

  async findall(){
    const u$ = this._http.get<User[]>(UserService.url+"/listuser");
    return await firstValueFrom(u$);
  }
  forgotpassword(email:String){
    this._http.post(UserService.url+"/forgot_password/"+email,User).subscribe(data => data = email);
  }
}
