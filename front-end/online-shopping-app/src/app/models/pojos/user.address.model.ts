export class UserAddress {
    constructor(
        public aid : number,
        public uid : number,
        public houseno : number,
        public street : string,
        public city : string,
        public state : string,
        public pin : number,
    ){}
}