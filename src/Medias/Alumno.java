package Medias;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private String nombre;
    private String dni;
    private List<Double> notasTareas;
    private List<Double> notasExamenes;

    //Constructor Alumno
    public Alumno(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        notasTareas = new ArrayList<>();
        notasExamenes = new ArrayList<>();
    }

    public void agregarNotaTarea(double nota) {
        notasTareas.add(nota);
    }

    public void agregarNotaExamen(double nota) {
        notasExamenes.add(nota);
    }

    // Método para calcular la media del alumno
    public double calcularMedia() {
        double mediaTareas = calcularMedia(notasTareas);
        double mediaExamenes = calcularMedia(notasExamenes);
        return mediaTareas * 0.25 + mediaExamenes * 0.75;
    }

    // Método privado para calcular la media de una lista de notas
    private double calcularMedia(List<Double> notas) {
        if (notas.isEmpty()) {
            return 0;
        }
        double total = 0;
        for (double nota : notas) {
            total += nota;
        }
        return total / notas.size();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }
}
