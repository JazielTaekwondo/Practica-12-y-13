package poo.sistema.roles;
import java.util.Scanner;

public abstract class Persona {
    public abstract void menu(Scanner leer);
    public abstract void opciones();
    public final void login(Scanner leer){
        Cliente consumidor = new Cliente(); 
        Empleado esclavo = new Empleado(); 
        String op;
        do {
            System.err.println("\n--LOGIN--");
            System.out.println("0. INGRESAR COMO CLIENTE");
            System.out.println("1. INGRESAR COMO EMPLEADO");
            System.out.println("2. SALIR");
            System.out.print("ELIGE UNA OPCION: ");
            op=leer.nextLine();
            switch (op) { 
                case "0":
                    consumidor.menu(leer);
                    break;
                case "1":
                    esclavo.menu(leer);
                    break;
            }
        } while (!op.equals("2"));
    }
}