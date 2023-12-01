package poo.sistema.roles;
import java.util.Scanner;

public class Empleado extends Persona{

    public Empleado(){
        super("3030");
    }

    @Override//INVENTARIO
    public void accion1(Scanner leer){
        String op;
        do {
            System.out.println("INVENTARIO");
            System.out.println("0. SALIR");
            System.out.println("1. REGISTRAR ");
            System.out.println("2. BORRAR");
            System.out.println("3. ORDENAR");
            System.out.println("5. INVENTARIO");
            System.out.print("ELIGE UNA OPCION: ");
            op=leer.nextLine();
            switch (op) {
                case "1":
                    System.out.println();
                    break;
                default:
                    break;
            }
        } while (!op.equals("0"));
    }
    @Override
    public void opciones(){
        System.out.println("\n-PERSONAL-"); 
        System.out.println("1. INVENTARIO");
        System.out.println("2. CERRAR SESION\n");
        System.out.print ("ELIGE UNA OPCION: ");
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
                default:
                    break;
            }
        } while (op.equals("1"));
    }
}
