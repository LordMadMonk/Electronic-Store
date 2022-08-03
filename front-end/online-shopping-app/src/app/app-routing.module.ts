import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/user/login/login.component';
import { ListProductComponent } from './components/Product_component/list/list.component';
import { RegisterComponent } from './components/user/register/register.component';
import { LoginsuccessComponent } from './components/user/loginsuccess/loginsuccess.component';
import { ListAddressComponent } from './components/Address_component/search/search.component';
import { ProductSearchComponent } from './components/Product_component/product-search/product-search.component';
import { AdminpanelComponent } from './components/user/adminpanel/adminpanel.component';
import { AddCouponComponent } from './components/Coupon_component/add/add.component';
import { ListCouponComponent } from './components/Coupon_component/list/list.component';
import { ViewComponent } from './components/Cart_component/view/view.component';
import { AddProductComponent } from './components/Product_component/add/add.component';
import { AddAddressComponent } from './components/Address_component/add/add.component';
import { CheckoutComponent } from './components/Cart_component/checkout/checkout.component';
import { OrderComponent } from './components/order/order.component';
import { HomeComponent } from './components/Home_component/home/home.component';
import { DetailComponent } from './components/order/detail/detail.component';
import { ForgotPasswordComponent } from './components/user/forgot-password/forgot-password.component';
import { AfterforgotComponent } from './components/user/afterforgot/afterforgot.component';
import { UpdateComponent } from './components/Product_component/update/update.component';
const routes: Routes = [
  {path : '',component:HomeComponent},
  {path:'login',component : LoginComponent},
  {path:'loginsuccess',component: LoginsuccessComponent},
  {path:'adminpanel',component: AdminpanelComponent},
  {path:'register',component : RegisterComponent},
  {path:'addProduct',component:AddProductComponent},
  {path:'list',component: ListProductComponent},
  {path:'updateProduct',component:UpdateComponent},
  {path:'addCoupon',component : AddCouponComponent},
  {path:'listCoupon',component : ListCouponComponent},
  {path:'viewCart',component:ViewComponent},
  {path:'addAddress',component:AddAddressComponent},
  {path:'listAddresses',component:ListAddressComponent},
  { path: 'search' , component:ProductSearchComponent },
  { path :'checkout', component:CheckoutComponent},
  {path : 'order', component:OrderComponent},
  {path:'checkout',component:CheckoutComponent},
  {path: 'orderitem', component:DetailComponent},
  {path: 'login/forgotpassword', component:ForgotPasswordComponent},
  {path:'afterforgot', component:AfterforgotComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
