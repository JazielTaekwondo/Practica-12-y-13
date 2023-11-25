import poo.sistema.roles.Empleado;
import java.util.Scanner;

public class Practica12y13{
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Empleado sistema = new Empleado();
        System.out.println("Binvenido");
        sistema.login(leer);
        leer.close();
    }
}
