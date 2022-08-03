import { User } from "./user.model";

export class Coupon{
    public coup_user : User[] = [];
    constructor(
        public cid : number,
        public cname : string,
        public discount : number
    ){}
}