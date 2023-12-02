package poo.sistema.roles;

public class Articulo {
    private String nombre;
    private int precio;
    private int cantidad;

    public Articulo(String nombre, int precio){
        this.nombre=nombre;
        this.precio=precio;
        this.cantidad=0;
    }

    public int getCantidad(){
        return cantidad;
    }

    public void setCantidad(int cantidad){
        this.cantidad = this. cantidad + cantidad;
    }

    public int getPrecio(){
        return precio;
    }

    public String getNombre(){
        return nombre;
    }

}
