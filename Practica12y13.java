import poo.sistema.roles.Articulo;
import poo.sistema.roles.Empleado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Practica12y13{
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        List<Articulo> inventario = new ArrayList<>();

        Empleado sistema = new Empleado(inventario);
        System.out.println("Binvenido");
        System.out.println("CLAVE CLIENTE 2020");
        System.out.println("CLAVE EMPLEADO 3030");
        sistema.login(leer);

        leer.close();
    }
}
