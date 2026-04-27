package tp3.punto2;
import tp3.punto1.GeneralTree;

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
		
		List<Integer> resultado = null;
		if (a != null) {
			if (a.isEmpty()) {
				return resultado;
			}
			else if (a.isLeaf()) {
				if (((a.getData() % 2) != 0) && a.getData() > n) {
					resultado.add(a.getData());
				}
				return resultado;
			}
			else {
				for (GeneralTree<Integer> child : a.getChildren()) {
					List<Integer> aux = this.numerosImparesMayoresQueInOrden(child, n);
					if (aux != null) {
						// Aux puede traer mas de un elemento que seria sus hijos
						resultado.addAll(aux);
					}
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
		return null;
	}
	
	/*
	 * Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
	 * pasados como parámetros, recorrido en postorden.
	 */
	public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a, Integer n){
		return null;
	}
	
	/*
	 * Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
	 * pasados como parámetros, recorrido por niveles.
	 */
	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a, Integer n) {
		return null;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
