import { Address } from "./address.model";
import { Coupon } from "./coupon.model";
import { Order } from "./order.model";

export class User{
    public user_orders : Order[] = [];
    public user_addresses : Address[] = [];
    public user_coup : Coupon[] = [];
    constructor(
        public userId : number,
        public username : string,
        public email  : string,
        public password : string,
        public phone_number : string
    ){}

    
}