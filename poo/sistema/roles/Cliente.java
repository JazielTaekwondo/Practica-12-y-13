package poo.sistema.roles;

import java.util.Scanner;

public class Cliente extends Persona {

    public Cliente(){
        super("2020");
    }

    @Override //Carrito de compra
    public void accion1(Scanner leer){
        String op;
        do {
            System.out.println("CARRITO DE COMPRA");
            System.out.println("0. SALIR");
            System.out.println("1. ELEGIR ELEMENTOS ");
            System.out.println("2. BORRAR");;
            System.out.println("3. INVENTARIO");
            System.out.print("ELIGE UNA OPCION: ");
            op=leer.nextLine();
            switch (op) {
                case "1":
                    System.out.println("opcion 1");
                    break;
                case "2":
                    System.out.println("opcion 2");
                    break;
                default:
                    break;
            }
        } while (!op.equals("0"));
    }

    public void accion2(Scanner leer){
        String op;
        do {
            System.out.println("CAJA");
            System.out.println("0. SALIR");
            System.out.println("1. CONTENIDO ");
            System.out.println("2. PAGAR");
            System.out.print("ELIGE UNA OPCION: ");
            op=leer.nextLine();
            switch (op) {
                case "1":
                    System.out.println("opcion 1");
                    break;
                case "2":
                    System.out.println("opcion 2");
                    break;
                default:
                    break;
            }
        } while (!op.equals("0"));
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
                    accion1(leer);
                    break;
                case "2":
                    System.out.println("opcion 2");
                    accion2(leer);
                    break;
                default:
                    break;
            }
        } while (op.equals("1")||op.equals("2"));
    }
}
