package ap;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        menu();
    }

    private static void menu() {
        ArrayList<Asignatura> asignaturas = (ArrayList<Asignatura>)LeerCSV.leerCSV("C:\\Users\\domin\\OneDrive\\Escritorio\\AD\\exa\\ex\\asignatura (1)");
        ArrayList<Ciclo> ciclos = (ArrayList<Ciclo>)LeerCSV.leerCSV("C:\\Users\\domin\\OneDrive\\Escritorio\\AD\\exa\\ex\\ciclo (1)");
        Scanner sc = new Scanner(System.in);
        int opcion;
        boolean salir = false;
        while (!salir){
            System.out.println("Menú principal:");
            System.out.println("1.JDBC");
            System.out.println("2.XML");
            System.out.println("3.HIBERNATE");
            System.out.println("4.SALIR");

            try {
                System.out.println("Escoge una opción: ");
                opcion= sc.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado JDBC");
                        JDBC.insertA(asignaturas);
                        JDBC.insertC(ciclos);
                        break;
                    case 2:
                        System.out.println("Has seleccionado XML");
                        break;
                    case 3:
                        System.out.println("Has seleccionado Hibernate");
                        break;
                    case 4:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 4");
                }
                } catch (InputMismatchException e) {
                    System.out.println("Debes insertar un número");
                    sc.next();
            }
    }}
}
