package poo.sistema.roles;
import java.util.Scanner;

public class Empleado extends Persona{
    @Override
    public void opciones(){
        System.out.println("\n-PERSONAL-"); 
        System.out.println("1. Inventario");
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
                    break;
                default:
                    break;
            }
        } while (op.equals("1"));
    }
}
