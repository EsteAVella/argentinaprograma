export class persona{
    id?: number;
    nombre: string;
    apellidos: string; 
    banner: string;
    imagen: string;

    constructor(nombre: string,apellidos: string,banner: string, imagen: string) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.banner = banner;
        this.imagen = imagen;
    }
}
