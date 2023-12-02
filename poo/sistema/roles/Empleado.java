package poo.sistema.roles;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Empleado extends Persona{
    private List<Articulo> inventario = new ArrayList<>();

    public Empleado(List<Articulo> lista){
        super("3030");
        this.inventario = lista;
    }

    public void setInventario(Articulo a){this.inventario.add(a);}

    public void ordenarInventario(List<Articulo> inventario){ //mergesort con hilos
            if (inventario.size() <= 1) {
                return;
            }
            int medio = inventario.size() / 2;
        List<Articulo> L = new ArrayList<>(inventario.subList(0, medio));
        List<Articulo> R = new ArrayList<>(inventario.subList(medio, inventario.size()));

        Thread hiloIzquierdo = new Thread(() -> ordenarInventario(L));
        Thread hiloDerecho = new Thread(() -> ordenarInventario(R));

        hiloIzquierdo.start();
        hiloDerecho.start();

        try {
            hiloIzquierdo.join();
            hiloDerecho.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        merge(inventario, L, R);
    }

    private static void merge(List<Articulo> lista, List<Articulo> izquierda, List<Articulo> derecha) {
        int i = 0, j = 0, k = 0;

        while (i < izquierda.size() && j < derecha.size()) {
            if (izquierda.get(i).getPrecio() <= derecha.get(j).getPrecio()) {
                lista.set(k++, izquierda.get(i++));
            } else {
                lista.set(k++, derecha.get(j++));
            }
        }

        while (i < izquierda.size()) {
            lista.set(k++, izquierda.get(i++));
        }

        while (j < derecha.size()) {
            lista.set(k++, derecha.get(j++));
        }
    }

    @Override//INVENTARIO
    public void accion1(Scanner leer){
        String op;
        do {
            System.out.println("\nINVENTARIO");
            System.out.println("1. REGISTRAR UN ARTICULO");
            System.out.println("2. BORRAR UN ARTICULO");
            System.out.println("3. ORDENAR INVENTARIO");
            System.out.println("4. MOSTRAR INVENTARIO");
            System.out.println("0. SALIR");
            System.out.print("ELIGE UNA OPCION: ");
            op=leer.nextLine();
            switch (op) {
                case "1":
                    this.agregar(leer);
                    break;
                case "2":
                    this.borrar(leer);
                case "3":
                    this.ordenarInventario(this.inventario);
                    break;
                case "4":
                    this.mostrar();
                    break;
                default:
                    break;
            }
        } while (!op.equals("0"));
    }

    @Override
    public void agregar(Scanner leer){
        this.mostrar();
        System.out.print("INGRESE EL NOMBRE DEL PRODUCTO: ");
        String name = leer.nextLine();
        System.out.print("INGRESE SU PRECIO: ");
        int costo = leer.nextInt();
        this.inventario.add(new Articulo(name,costo));
        leer.nextLine();
    }

    @Override
    public void borrar(Scanner leer){
        mostrar();
        System.out.print("QUE ELEMENTO DESEAS BORRAR: ");
        int eliminar = leer.nextInt();
        leer.nextLine();
        this.inventario.remove(eliminar-1);
    }

    @Override
    public void mostrar(){
        System.out.println("\nPRODUCTOS:");
        for (int i = 0; i < this.inventario.size(); i++) {
            System.out.println("#"+(i+1)+" NOMBRE: "+this.inventario.get(i).getNombre()+
            " PRECIO: $"+this.inventario.get(i).getPrecio());
        }
        System.out.println();
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
                    accion1(leer);
                    break;
                default:
                    break;
            }
        } while (op.equals("1"));
    }
}
