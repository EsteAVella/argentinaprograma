
export class persona {
    
    id?        :number;
    enabled?   :boolean;
    nombre     :String;
    email      :String;
    password   :String;
    apellido   :String;
    carrera    :String;
    descripcion:String;
    // domicilio:String;
    // foto:String;
    
    constructor( nombre:String, email:String, password:String, apellido:String, descripcion:String, carrera:String ){
        
        this.nombre      = nombre;
        this.password    = password;
        this.email       = email;
        this.apellido    = apellido;
        this.descripcion = descripcion;
        this.carrera     = carrera;
    
    }    
}