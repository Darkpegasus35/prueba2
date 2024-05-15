package Medias;

import java.util.ArrayList;
import java.util.List;

public class Profesor {
	private List<Alumno> alumnos;

	//Constructor profesor que inicializa la nueva lista de alumnos
	public Profesor() {
		alumnos = new ArrayList<>();
	}

	//Método para crear alumnos nuevos con nombre y DNI
	public void crearAlumno(String nombre, String dni) {
		alumnos.add(new Alumno(nombre, dni));
	}

	//Método para agregar la nota a los alumnos
	public void agregarNota(String dni, double nota, boolean esTarea) {
		Alumno alumno = obtenerAlumno(dni);
		if (alumno != null) {
			if (esTarea) {
				alumno.agregarNotaTarea(nota);
			} else {
				alumno.agregarNotaExamen(nota);
			}
		}
	}

	//Método para calcular la media del alumno llamando a un método que calcula la
	//media desde la clase alumno.
	public double calcularMediaAlumno(String dni) {
		Alumno alumno = obtenerAlumno(dni);
		return alumno != null ? alumno.calcularMedia() : 0;
	}

	//Método para calcular la media de la clase.
	public double calcularMediaClase() {
		if (alumnos.isEmpty()) {
			return 0;
		}

		double totalNotas = 0;
		int totalAlumnos = 0;

		for (Alumno alumno : alumnos) {
			totalNotas += alumno.calcularMedia();
			totalAlumnos++;
		}

		return totalNotas / totalAlumnos;
	}

	//Métpdp que obtiene los datos de un objeto de la clase alumno através de su DNI
	public Alumno obtenerAlumno(String dni) {
		for (Alumno alumno : alumnos) {
			if (alumno.getDni().equals(dni)) {
				return alumno;
			}
		}
		return null;
	}
}
