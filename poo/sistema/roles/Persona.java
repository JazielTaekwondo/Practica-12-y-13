package poo.sistema.roles;
import java.util.Scanner;

public abstract class Persona {
    private String credencial;
    public Persona(String clave){
        this.credencial=clave;
    }

    public String getCredencial(){
        return credencial;
    }

    public abstract void menu(Scanner leer);

    public abstract void opciones();

    public abstract void accion1(Scanner leer);

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
                    consumidor.contrasena(leer, consumidor.getCredencial());
                    consumidor.menu(leer);
                    break;
                case "1":
                    esclavo.contrasena(leer, esclavo.getCredencial());
                    esclavo.menu(leer);
                    break;
            }
        } while (!op.equals("2"));
    }

    public final void contrasena(Scanner leer, String c){
        String clave;
        do {
            System.out.print("INGRESE LA CLAVE DE SU CREDENCIAL: ");
            clave = leer.nextLine();
        } while (!clave.equals(c));
        System.out.println("\nBIENVENIDO");
    }
}