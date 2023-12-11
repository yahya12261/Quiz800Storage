


export class user{
  id!:number
  email!:String
  first_name !:String
  last_name!:String
  avatar!:String
  constructor(id:number,email:String,first_name:String,last_name:String,avatar:String)
  {
    this.id = id ;
    this.email = email;
    this.first_name = first_name;
    this.last_name = last_name;
    this.avatar = avatar;
  }
}
