import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { OrderComponent } from './components/order/order.component';
import { ListProductComponent } from './components/Product_component/list/list.component';
import { RegisterComponent } from './components/user/register/register.component';
import { LoginComponent } from './components/user/login/login.component';
import { LoginsuccessComponent } from './components/user/loginsuccess/loginsuccess.component';
import { AddAddressComponent } from './components/Address_component/add/add.component';
import { ListAddressComponent } from './components/Address_component/search/search.component';
import { ProductSearchComponent } from './components/Product_component/product-search/product-search.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AdminpanelComponent } from './components/user/adminpanel/adminpanel.component';
import { ViewComponent } from './components/Cart_component/view/view.component';
import { CheckoutComponent } from './components/Cart_component/checkout/checkout.component';
import { AddCouponComponent } from './components/Coupon_component/add/add.component';
import { ListCouponComponent } from './components/Coupon_component/list/list.component';
import { AddProductComponent } from './components/Product_component/add/add.component';
import { HomeComponent } from './components/Home_component/home/home.component';
import { DetailComponent } from './components/order/detail/detail.component';
import { ForgotPasswordComponent } from './components/user/forgot-password/forgot-password.component';
import { AfterforgotComponent } from './components/user/afterforgot/afterforgot.component';
import { UpdateComponent } from './components/Product_component/update/update.component';

@NgModule({
  declarations: [
    AppComponent,
    OrderComponent,
    AddProductComponent,
    ListProductComponent,
    RegisterComponent,
    LoginComponent,
    LoginsuccessComponent,
    AddAddressComponent,
    ListAddressComponent,
    ProductSearchComponent,
    AdminpanelComponent,
    ViewComponent,
    CheckoutComponent,
    AddCouponComponent,
    ListCouponComponent,
    HomeComponent,
    DetailComponent,
    ForgotPasswordComponent,
    AfterforgotComponent,
    UpdateComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
