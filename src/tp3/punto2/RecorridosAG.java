package tp3.punto2;
import tp3.punto1.GeneralTree;
import tp1.punto8.Queue;

import java.util.LinkedList;
import java.util.List;
public class RecorridosAG {

	public RecorridosAG() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 *	Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
	 *	pasados como parámetros, recorrido en preorden.
	 */
	public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a, Integer n){
		
		List<Integer> resultado = new LinkedList<Integer>();
		if (a.isEmpty()) {
			return resultado;
		}
		else {
			if (((a.getData() % 2) != 0) && a.getData() > n) {
				resultado.add(a.getData());
			}
			for (GeneralTree<Integer> child : a.getChildren()) {
				List<Integer> aux = this.numerosImparesMayoresQuePreOrden(child, n);
				if (!aux.isEmpty()) {
					// Aux puede traer mas de un elemento que seria sus hijos
					resultado.addAll(aux);
				}
			}
		}
		return resultado;
	}
	
	/*
	 * Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
	 * pasados como parámetros, recorrido en inorden.
	 */
	public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a, Integer n){

		List<Integer> resultado = new LinkedList<Integer>();
		if (a.isEmpty()) {
			return resultado;
		}
		else {
			//List<GeneralTree<Integer>> children = a.getChildren();
			List<GeneralTree<Integer>> children = new LinkedList<>(a.getChildren());
			List<Integer> aux = new LinkedList<Integer>();
			if (!children.isEmpty()) {
				aux = this.numerosImparesMayoresQueInOrden(children.removeFirst(), n);
				if (!aux.isEmpty()) {
					resultado.addAll(aux);
				}
			}
			if (((a.getData() % 2) != 0) && a.getData() > n) {
				resultado.add(a.getData());
			}
			for (GeneralTree<Integer> child : children) {
				aux = this.numerosImparesMayoresQueInOrden(child, n);
				if (!aux.isEmpty()) {
					// Aux puede traer mas de un elemento que seria sus hijos
					resultado.addAll(aux);
				}
			}
			
		}
		return resultado;
	}
	
	/*
	 * Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
	 * pasados como parámetros, recorrido en postorden.
	 */
	public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a, Integer n){

		List<Integer> resultado = new LinkedList<Integer>();
		if (a.isEmpty()) {
			return resultado;
		}
		else {
			for (GeneralTree<Integer> child : a.getChildren()) {
				List<Integer> aux = this.numerosImparesMayoresQuePostOrden(child, n);
				if (!aux.isEmpty()) {
					// Aux puede traer mas de un elemento que seria sus hijos
					resultado.addAll(aux);
				}
				
			}
			if (((a.getData() % 2) != 0) && a.getData() > n) {
				resultado.add(a.getData());
			}
		}
		return resultado;
	}
	
	/*
	 * Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
	 * pasados como parámetros, recorrido por niveles.
	 */
	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a, Integer n) {
		List<Integer> resultado = new LinkedList<Integer>();
		Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
		GeneralTree<Integer> aux = null;
		int nivel = 1;
		
		cola.enqueue(a);
		cola.enqueue(null);
		
		while (!cola.isEmpty()) {
			aux = cola.dequeue();
			
			if (aux != null) {
				if (((aux.getData()%2) != 0) && aux.getData() > n) {
					resultado.add(aux.getData());
				}
				for (GeneralTree<Integer> child: aux.getChildren()) {
					cola.enqueue(child);
				}
			}
			else {
				nivel += 1;
				if (!cola.isEmpty()) {
					cola.enqueue(null);
				}
			}
		}
		
		return resultado;
	}
	
	

	public static void main(String[] args) {
		RecorridosAG recorrido = new RecorridosAG();
		GeneralTree<Integer> ag = new GeneralTree<Integer>(10);
		
		GeneralTree<Integer> ag11 = new GeneralTree<Integer>(11);
		GeneralTree<Integer> ag30 = new GeneralTree<Integer>(30);
		GeneralTree<Integer> ag25 = new GeneralTree<Integer>(25);
		ag25.addChild(ag11);
		ag25.addChild(ag30);
		
		GeneralTree<Integer> ag21 = new GeneralTree<Integer>(21);
		GeneralTree<Integer> ag16 = new GeneralTree<Integer>(16);
		ag16.addChild(ag21);
		
		GeneralTree<Integer> ag40 = new GeneralTree<Integer>(40);
		GeneralTree<Integer> ag7 = new GeneralTree<Integer>(7);
		ag7.addChild(ag40);
		GeneralTree<Integer> ag15 = new GeneralTree<Integer>(15);
		GeneralTree<Integer> ag5 = new GeneralTree<Integer>(5);
		ag5.addChild(ag7);
		ag5.addChild(ag15);
		
		ag.addChild(ag5);
		ag.addChild(ag16);
		ag.addChild(ag25);
		
		List<Integer> imparesPreOrden =  recorrido.numerosImparesMayoresQuePreOrden(ag, 4);
		
		for (Integer impar : imparesPreOrden) {
			System.out.println(impar);
		}
		System.out.println();
		
		List<Integer> imparesInOrden =  recorrido.numerosImparesMayoresQueInOrden(ag, 4);
		
		for (Integer impar : imparesInOrden) {
			System.out.println(impar);
		}
		System.out.println();
		
		List<Integer> imparesPosOrden =  recorrido.numerosImparesMayoresQuePostOrden(ag, 4);
		
		for (Integer impar : imparesPosOrden) {
			System.out.println(impar);
		}
		System.out.println();
		
		List<Integer> imparesPorNivel =  recorrido.numerosImparesMayoresQuePorNiveles(ag, 4);
		
		for (Integer impar : imparesPorNivel) {
			System.out.println(impar);
		}
		System.out.println();
	}
	
	/*
	 * b) Si ahora tuviera que implementar estos métodos en la clase GeneralTree<T>, ¿qué modificaciones 
	 * haría tanto en la firma como en la implementación de los mismos?
	 * 
	 * Firma: Eliminaria el GeneralTree<T> a y dejaria el valor a comparar 'n'
	 * Implementacion: cambiar a por this que haria referencia al objeto GeneralTree<T> 
	 */
}
