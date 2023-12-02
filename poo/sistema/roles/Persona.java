package poo.sistema.roles;
import java.util.ArrayList;
import java.util.List;
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

    public abstract void mostrar();

    public abstract void agregar(Scanner leer);

    public abstract void borrar(Scanner leer);

    public final void login(Scanner leer){
        List<Articulo> inventario = new ArrayList<>();
        inventario.add(new Articulo("HUEVO", 45));
        inventario.add(new Articulo("LECHE", 20));
        inventario.add(new Articulo("PAN", 15));
        inventario.add(new Articulo("JAMON", 100));

        inventario.get(0).setCantidad(1);
        inventario.get(1).setCantidad(2);
        inventario.get(2).setCantidad(3);
        inventario.get(3).setCantidad(0);

        Cliente consumidor = new Cliente(inventario); 
        Empleado esclavo = new Empleado(inventario); 
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