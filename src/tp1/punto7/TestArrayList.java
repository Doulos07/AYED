package tp1.punto7;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

import tp1.punto3.Estudiante;

public class TestArrayList {

	public TestArrayList() {
		// TODO Auto-generated constructor stub
	}
	
	
	public boolean esCapicua(List<Integer> lista) {
		boolean esCapicua = true;
		List<Integer> listaInversa = new ArrayList<>(lista);
		Collections.reverse(listaInversa);
		
		/* Compara por referencia en memoria en este caso esta bien ya que son los mismo objetos 
		 * Si fuera otro objeto tendria que usar equal ya que no compara por referencia en memoria sino 
		 * por el valor del contenido
		 */
		for (int i = 0; i < lista.size(); i++) {
			if ( lista.get(i) != listaInversa.get(i)) esCapicua = false;
		}

		return esCapicua;
	}
	
	public static void imprimirEstudiantes (List<Estudiante>arg) {
		for (Estudiante estudiante : arg) {
			System.out.println(estudiante.tusDatos());
		}
		System.out.println("-----------------------------------------");
	}
	
	// Preguntar como hacer en un solo metodo
	public void invertirArrayList(ArrayList<Integer> lista) {
		this.invertirRec(lista, 0, lista.size() - 1);
	}
	
	public void invertirRec (ArrayList<Integer> lista, int inicio, int fin) {
		if (inicio >= fin) {
			return;
		}
		
		Integer temp = lista.get(inicio);
		lista.set(inicio, lista.get(fin));
		lista.set(fin, temp);
		
		this.invertirRec(lista, inicio + 1, fin - 1);
	}
	

	public int sumarLinkedList(LinkedList<Integer> lista) {
		if (lista.isEmpty()) {
			return 0;
		}
		int primero = lista.removeFirst();
		return primero + this.sumarLinkedList(lista);
	}
	
	public ArrayList<Integer> combinarOrdenado(ArrayList<Integer> lista1, ArrayList<Integer> lista2){
		lista1.addAll(lista2);
		//lista1.sort((a, b) -> a - b);
		lista1.sort(Comparator.naturalOrder());
		return lista1;
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
			
			TestArrayList.multiplesProcesos();
			
			TestArrayList test = new TestArrayList();
			System.out.println(test.esCapicua(numeros) ? "La lista es Capicua" : "La lista no es Capicua");
			
			int num = 6;
			EjerciconSucesion sucesion = new EjerciconSucesion();
			numeros = sucesion.calcularSucesion(num);
			for (Integer integer : numeros) {
				System.out.print(integer + " ");
			}
		
			
			System.out.println("\n -----------------------------------------");
			ArrayList<Integer>list = new ArrayList<Integer>();
			list.add(10);
			list.add(20);
			list.add(30);
			list.add(40);
			list.add(50);
			
			for (Integer integer2 : list) {
				System.out.print(integer2 + " ");
			}
			
			test.invertirArrayList(list);
			
			System.out.println("\n -----------------------------------------");
			for (Integer integer2 : list) {
				System.out.print(integer2 + " ");
			}
			
			System.out.println("\n -----------------------------------------");
			LinkedList<Integer> linked = new LinkedList<>();
			linked.add(10);
			linked.add(20);
			linked.add(30);
			linked.add(40);
			linked.add(50);
			
			for (Integer integer2 : linked) {
				System.out.print(integer2 + " ");
			}
			
			System.out.println();
			System.out.println("suma de los elementos LinkedLink: "+ test.sumarLinkedList(linked));
			
			ArrayList<Integer>list2 = new ArrayList<Integer>();
			list2.add(5);
			list2.add(15);
			list2.add(25);
			list2.add(35);
			list2.add(45);
			
			list = test.combinarOrdenado(list, list2);
			System.out.println(list);
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
		
	}

}
