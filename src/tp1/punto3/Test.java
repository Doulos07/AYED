package tp1.punto3;

public class Test {

	public static void main(String[] args) {
		Estudiante [] estudiantes = new Estudiante [2];
		Profesor [] profesores = new Profesor [3];
		
		estudiantes[0] = new Estudiante("Santiago", "Alvarez", "santi@gmail.com", "AYED", "Informatica");
		estudiantes[1] = new Estudiante("Marcos", "Pissani", "marcos@gmail.com", "AYED", "Informatica");
		
		profesores[0] = new Profesor("Maxi", "Sosa", "maxi@gmail.com", "Ciberseguridad", "Informatica");
		profesores[1] = new Profesor("Vanina", "Liporachi", "vani@gmail.com", "Empresas", "Administracion empresas");
		profesores[2] = new Profesor("Paola", "pogio", "pogio@gmail.com", "matematicas 1", "Matematica");
		
		
		for (Estudiante estudiante : estudiantes) {
			System.out.print(estudiante.tusDatos() + "\n");
			System.out.print("");
		}
		
		for (Profesor profesor : profesores) {
			System.out.print(profesor.tusDatos() + "\n");
			System.out.print("");
		}
		
		
	}

}
