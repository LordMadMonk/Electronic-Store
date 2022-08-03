import { Product } from "./product.model";
import { User } from "./user.model";

export class ShoppingCart{
    public  shop_cart : Product[] = [];
    constructor(
        public cartid : number,
        public total_price :number,
        public user_cart : User
    ){}
}