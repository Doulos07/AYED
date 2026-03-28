package tp1.punto7;

import java.util.ArrayList;
import java.util.List;
import tp1.punto3.Estudiante;

public class TestArrayList {

	public TestArrayList() {
		// TODO Auto-generated constructor stub
	}
	
	public static void imprimirEstudiantes (List<Estudiante>arg) {
		for (Estudiante estudiante : arg) {
			System.out.println(estudiante.tusDatos());
		}
		System.out.println("-----------------------------------------");
	}
	
	public static void multiplesProcesos () {
		List <Estudiante> estudiantes = new ArrayList<>();

		estudiantes.add(new Estudiante("Juan", "Perez", "Comision A", "juan@gmail.com", "Calle 123"));
		estudiantes.add(new Estudiante("Ana", "Gomez", "Comision B", "ana@gmail.com", "Calle 456"));
		estudiantes.add(new Estudiante("Luis", "Lopez", "Comision C", "luis@gmail.com", "Calle 789"));
		
		//Formas de copiar un ArrayList
		//1- Pasar la lista como parametro del constructor
		List<Estudiante> copiaEstudiantes = new ArrayList<>(estudiantes);
		
		TestArrayList.imprimirEstudiantes(estudiantes);
		TestArrayList.imprimirEstudiantes(copiaEstudiantes);
		
		Estudiante estu = copiaEstudiantes.get(0);
		
		estu.setNombre("Santiago");
		estu.setApellido("Alvarez");
		
		TestArrayList.imprimirEstudiantes(estudiantes);
		TestArrayList.imprimirEstudiantes(copiaEstudiantes);
		
		
		/*Al imprimir ambas listas veo que la lista origin imprime lo mismo que la copia aunque haya
		 * modifico un Estudiante
		 * 
		 * Esto me da a enteder que ambas listas tienen referencia a la misma instancia del objeto
		 * */
		

		//Otras formas de copias listas
		
		/*
		 * 2- Utilizar el metodo addAll
		 * permite agregar elementos a una lista ya existente, brindando mayor flexibilidad.
		 * 
		 * */

		List<Estudiante> copiaEstudiantes2 = new ArrayList<Estudiante>();
		copiaEstudiantes2.addAll(estudiantes);
		
		
		/*3- Utilizar el metodo clone 
		 * Duplica la lista completa
		 * Devuelve Object → necesita cast
		 * 
		 * En este caso Doble Cast por ser implementacion <LIST>
		 */
		@SuppressWarnings("unchecked")
		ArrayList<Estudiante> copiaEstudiantes3 = (ArrayList<Estudiante>) ((ArrayList<Estudiante>) estudiantes).clone();
		
		//7.e
		Estudiante nuevoEstudiante = new Estudiante("Marcos", "Pissani", "Comision B", "marcps@gmail.com", "Calle 456");
		if (!estudiantes.contains(nuevoEstudiante)) {
		    estudiantes.add(nuevoEstudiante);
		}
		
		TestArrayList.imprimirEstudiantes(estudiantes);
	}

	public static void main(String[] args) {
		if (args.length > 1) {
			System.out.println("Punto A");
			List <Integer> numeros = new ArrayList <>();
			
			for (String num : args) {
				numeros.add(Integer.valueOf(num));
			}
			
			System.out.println(numeros);
		}
		else {
			System.out.println("no se paso parametro a la clase main");
		}
		
		/*
		 * Punto B
		 * La implementacion en este caso seria cambiar el new "ArrayList" por "linkedList"
		 * ya que estoy usando como tipo la interface List el cual utilizan ambas clases
		 * 
		 * Si hubiera usado ArrayList en vez de List hubiera tenido que cambiar tambien eso ya que no
		 * podria usar la clase LinkedList
		 * 
		 * La interfaz List me da mas flexibilidad
		 * 	
		 *Despues con el resto de la implementacion serian exactamente lo mismo ya que ambas clases utilizan
		 *los mismo metodos "pero con diferente implementacion"
		 *
		 * */
		
		/*
		 * Mi implementacion: for-each 
		 * 	-recorre automaticamente todos los elementos
		 * 	-Devuelve el elemento pero no los indices
		 * 	-Internamente usa un `Interador`
		 * 
		 * For-each tradicion
		 * para haceder a los elementos de utiliza el metodo .get(indice)
		 * 
		 * for (int i = 0; i < numeros.size(); i++) {
		 * 		System.out.println(numeros.get(i));
		 * }
		 * 
		 * Iterator (explícito) -> Sirve mucho si eliminás elementos
		 * Iterator<Integer> it = numeros.iterator();
		 * while (it.hasNext()) {
		 * 	 	System.out.println(it.next());
		 * }
		 * 
		 * */
		
		TestArrayList.multiplesProcesos();
	}

}
