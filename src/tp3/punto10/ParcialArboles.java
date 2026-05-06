package tp3.punto10;

import java.util.LinkedList;
import java.util.List;
import tp3.punto1.GeneralTree;

public class ParcialArboles {

	public static List<Integer> resolver(GeneralTree<Integer> arbol){
		List<Integer> resultado = new LinkedList<Integer>();
		if (arbol != null && !arbol.isEmpty()) recorridoMasLargo(arbol, resultado, new LinkedList<Integer>());
		return resultado;
	}
	
	
	private static void recorridoMasLargo(GeneralTree<Integer> arbol, List<Integer> resultado, List<Integer> recorridoActual ){
		recorridoActual.add(arbol.getData());
		if (arbol.isLeaf()) {
			resultado.removeAll(resultado);
			resultado.addAll(recorridoActual);
		}
		for (GeneralTree<Integer> child : arbol.getChildren()) {
			recorridoMasLargo(child, resultado, recorridoActual);
			if (sizeValido(recorridoActual) > sizeValido(resultado)) {
				recorridoActual = new LinkedList<Integer>(recorridoActual);
			}
		}
		
	}
	
	private static int sizeValido (List<Integer>list) {
		int cantidad = 0;
		for (Integer integer : list) {
			if (integer == 1) cantidad += 1;
		}
		return cantidad;
	}
	
	public static void main(String[] args) {
		/*
				 1
		      / | \
		     0  1  1
		    /|  |\ \
		   1  1 1 0 0
		  /|      |   \
		 0  0 1   0    0
		        |     / \
		        1    0   0
	    */
	
		// Nivel 4
	    GeneralTree<Integer> n14 = new GeneralTree<Integer>(1);
	    GeneralTree<Integer> n15 = new GeneralTree<Integer>(0);
	    GeneralTree<Integer> n16 = new GeneralTree<Integer>(0);

	    // Nivel 3
	    GeneralTree<Integer> n7 = new GeneralTree<Integer>(0);
	    GeneralTree<Integer> n8 = new GeneralTree<Integer>(0);
	    n8.addChild(n14);

	    GeneralTree<Integer> n9 = new GeneralTree<Integer>(1);
	    GeneralTree<Integer> n10 = new GeneralTree<Integer>(0);
	    n10.addChild(n15);
	    n10.addChild(n16);

	    // Nivel 2
	    GeneralTree<Integer> n3 = new GeneralTree<Integer>(1);
	    n3.addChild(n7);
	    n3.addChild(n8);

	    GeneralTree<Integer> n4 = new GeneralTree<Integer>(1);
	    n4.addChild(n9);

	    GeneralTree<Integer> n5 = new GeneralTree<Integer>(0);

	    GeneralTree<Integer> n6 = new GeneralTree<Integer>(0);
	    n6.addChild(n10);

	    // Nivel 1
	    GeneralTree<Integer> n1 = new GeneralTree<Integer>(0);
	    n1.addChild(n3);
	    n1.addChild(n4);  // el 1 suelto de nivel 2

	    GeneralTree<Integer> n2a = new GeneralTree<Integer>(1);
	    n2a.addChild(n4); // ojo, ver nota abajo

	    GeneralTree<Integer> n2b = new GeneralTree<Integer>(1);
	    n2b.addChild(n5);
	    n2b.addChild(n6);

	    // Nivel 0 (raíz)
	    GeneralTree<Integer> root = new GeneralTree<Integer>(1);
	    root.addChild(n1);
	    root.addChild(n2a);
	    root.addChild(n2b);

	    List<Integer> recorrido = ParcialArboles.resolver(root);
	    for (Integer valor : recorrido) {
			System.out.println(valor);
		}
	}

}
