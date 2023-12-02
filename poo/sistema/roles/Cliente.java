package poo.sistema.roles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente extends Persona {
    private List<Articulo> inventario = new ArrayList<>();
    private int total;
    private int saldo;

    public Cliente(List<Articulo> lista){
        super("2020");
        this.inventario = lista;
        this.total=0;
        this.saldo=2000;
    }

    @Override //Carrito de compra
    public void accion1(Scanner leer){
        String op;
        do {
            System.out.println("CARRITO DE COMPRA");
            System.out.println("1. VER INVENTARIO ");
            System.out.println("2. ANIADIR AL CARRITO");;
            System.out.println("3. ELIMINAR PRODUCTO");
            System.out.println("0. SALIR");
            System.out.print("ELIGE UNA OPCION: ");
            op=leer.nextLine();
            switch (op) {
                case "1":
                    this.catalogo();
                    break;
                case "2":
                    this.agregar(leer);
                    break;
                case "3":
                    this.borrar(leer);
                    break;
                default:
                    break;
            }
        } while (!op.equals("0"));
    }

    //Caja
    public void accion2(Scanner leer){
        String op;
        do {
            System.out.println("CAJA");
            System.out.println("1. CARRITO Y TOTAL A PAGAR ");
            System.out.println("2. PAGAR");
            System.out.println("0. SALIR");
            System.out.print("ELIGE UNA OPCION: ");
            op=leer.nextLine();
            switch (op) {
                case "1":
                    this.mostrar();
                    break;
                case "2":
                    this.pagar();
                    break;
                default:
                    break;
            }
        } while (!op.equals("0"));
    }

    @Override
    public void agregar(Scanner leer){
        this.catalogo();
        System.out.print("QUE PRODUCTO DESEA ANIADIR: ");
        int producto = leer.nextInt();
        if(producto <= this.inventario.size()){
            System.out.print("CANTIDAD DE "+this.inventario.get(producto-1).getNombre()+": ");
            int cantidad = leer.nextInt(); 
            this.inventario.get(producto-1).setCantidad(cantidad);
        }
        else{
            System.out.println("NO SE ENCONTRO EL PRODUCTO...");
        }
        leer.nextLine();
    }

    @Override
    public void borrar(Scanner leer){
        this.catalogo();
        System.out.print("QUE PRODUCTO DESEA ELIMINAR: ");
        int producto = leer.nextInt();
        if(producto <= this.inventario.size()){
            System.out.print("CANTIDAD DE "+this.inventario.get(producto-1).getNombre()+": ");
            int cantidad = leer.nextInt(); 
            this.inventario.get(producto-1).setCantidad(-cantidad);
            if(this.inventario.get(producto-1).getCantidad()<0){
                this.inventario.get(producto-1).setCantidad(-this.inventario.get(producto-1).getCantidad());
            }
        }
        else{
            System.out.println("NO SE ENCONTRO EL PRODUCTO...");
        }
        leer.nextLine();
    }

    @Override
    public void opciones(){ 
        System.out.println("\n-USUARIO-");
        System.out.println("1. CARRITO DE COMPRA");
        System.out.println("2. CAJA");
        System.out.println("3. CERRAR SESION\n");
        System.out.print("ELIGE UNA OPCION: ");
    }

    @Override //Muestra el carrito y el total a pagar
    public void mostrar(){
        for (int i = 0; i < inventario.size(); i++) {
            System.out.println("CANTIDAD: "+this.inventario.get(i).getCantidad()+" #"+(i+1)+
            " PRODUCTO: "+this.inventario.get(i).getNombre()+
            " PRECIO: $"+this.inventario.get(i).getPrecio());
        }
        for (int i = 0; i < inventario.size(); i++) {
            this.total = this.total + this.inventario.get(i).getCantidad()*this.inventario.get(i).getPrecio();
        }
        System.out.println("\nTOTAL: "+ this.total);
        System.out.println();
        this.total=0;
    }

    public void pagar(){//Metodo para pagar y que reduce la cantidad de elementos del carrito a 0

        for (int i = 0; i < inventario.size(); i++) {
            this.total = this.total + this.inventario.get(i).getCantidad()*this.inventario.get(i).getPrecio();
        }
        System.out.print("SU CUENTA ES: $"+this.total+" Y SU SALDO ES DE: $"+this.saldo);
        if(this.saldo >= this.total){
            this.saldo = this.saldo - this.total;
            for (int i = 0; i < inventario.size(); i++) {
                this.inventario.get(i).setCantidad(-this.inventario.get(i).getCantidad());
            }
            System.out.println("\nSU CAMBIO ES: "+ this.saldo);
        }
        else{
            System.out.println("DINERO INSUFICIENTE...");
        }

        System.out.println();

        this.total=0;
    }

    public void catalogo(){
        System.out.println("\nPRODUCTOS:");
        for (int i = 0; i < this.inventario.size(); i++) {
            System.out.println("#"+(i+1)+" NOMBRE: "+this.inventario.get(i).getNombre()+
            " PRECIO: $"+this.inventario.get(i).getPrecio());
        }
        System.out.println();
    }

    @Override
    public void menu(Scanner leer){
        String op;
        do {
            opciones();
            op=leer.nextLine();
            switch (op) {
                case "1":
                    accion1(leer);
                    break;
                case "2":
                    accion2(leer);
                    break;
                default:
                    break;
            }
        } while (!op.equals("3"));
    }
}
