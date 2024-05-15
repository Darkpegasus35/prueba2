package Medias;

import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static Profesor profesor = new Profesor();

    public static void main(String[] args) {
        mostrarMenu();
    }

    private static void mostrarMenu() {
        while (true) {
            System.out.println("1. Crear alumno\n2. Introducir nota a alumno\n3. Obtener medias\n4. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    crearAlumno();
                    break;
                case 2:
                    introducirNota();
                    break;
                case 3:
                    obtenerMedias();
                    break;
                case 4:
                    salir();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void crearAlumno() {
        System.out.print("Nombre del Alumno: ");
        String nombre = scanner.next();
        System.out.print("DNI del Alumno: ");
        String dni = scanner.next();
        profesor.crearAlumno(nombre, dni);
    }

    private static void introducirNota() {
        System.out.print("DNI del Alumno: ");
        String dni = scanner.next();
        System.out.print("Nota: ");
        double nota = scanner.nextDouble();
        System.out.print("Es nota de tarea? (si/no): ");
        boolean esTarea = scanner.next().equalsIgnoreCase("si");
        profesor.agregarNota(dni, nota, esTarea);
    }

    private static void obtenerMedias() {
        System.out.print("Pulsa 1 para calcular la media del alumno o 2 para la clase ");
        int tipoMedia = scanner.nextInt();
        if (tipoMedia == 1) {
            calcularMediaAlumno();
        } else if (tipoMedia == 2) {
            double mediaClase = profesor.calcularMediaClase();
            System.out.println("Media de la Clase: " + mediaClase);
        } else {
            System.out.println("Opción incorrecta.");
        }
    }

    private static void calcularMediaAlumno() {
        System.out.print("DNI del Alumno: ");
        String dni = scanner.next();
        double media = profesor.calcularMediaAlumno(dni);
        System.out.println("Media del Alumno: " + media);
    }

    private static void salir() {
        System.out.println("Saliendo del programa...");
        scanner.close();
        System.exit(0);
    }
}
