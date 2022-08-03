import { Order } from "./order.model";
import { User } from "./user.model";

export class Address {
    public ads_orders : Order[] = [];
    constructor(
        public addressId : number,
        public houseNo : number,
        public street : string,
        public city : string,
        public state : string,
        public pincode : number,
        public useradd : User
    ){}
}