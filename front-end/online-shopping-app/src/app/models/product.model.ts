import { ShoppingCart } from "./cart.model";
import { Order } from "./order.model";

export class Product{
    public prod_cart : ShoppingCart[] = [];
    public prod_ord : Order[] = [];

    constructor(
        public pid:number,
        public pname:string,
        public price:number,
        public stock:number,
        public category:string
    ){}
}