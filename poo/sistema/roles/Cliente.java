package poo.sistema.roles;

import java.util.Scanner;

public class Cliente extends Persona {

    public Cliente(){
        super("2020");
    }

    @Override //Carrito de compra
    public void accion1(){
        System.out.println("Carrito de compras");
    }
    @Override
    public void opciones(){ 
        System.out.println("\n-USUARIO-");
        System.out.println("1. CARRITO DE COMPRA");
        System.out.println("2. CAJA");
        System.out.println("3. CERRAR SESION\n");
        System.out.print("ELIGE UNA OPCION: ");
    }
    @Override
    public void menu(Scanner leer){
        String op;
        do {
            opciones();
            op=leer.nextLine();
            switch (op) {
                case "1":
                    System.out.println("opcion 1");
                    accion1();
                    break;
                case "2":
                    System.out.println("opcion 2");
                    break;
                default:
                    break;
            }
        } while (op.equals("1")||op.equals("2"));
    }
}
