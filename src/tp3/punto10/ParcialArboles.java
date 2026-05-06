package tp3.punto10;

import java.util.LinkedList;
import java.util.List;
import tp3.punto1.GeneralTree;

public class ParcialArboles {

	public static List<Integer> resolver(GeneralTree<Integer> arbol){
		List<Integer> resultado = new LinkedList<Integer>();
		if (arbol != null && !arbol.isEmpty()) recorridoMasLargo(arbol, resultado, new LinkedList<Integer>());
		valoresValidos(resultado);
		return resultado;
	}
	
	
	private static void recorridoMasLargo(GeneralTree<Integer> arbol, List<Integer> resultado, List<Integer> recorridoActual ){
		recorridoActual.add(arbol.getData());
		if (arbol.isLeaf()) {
			if(sizeValido(recorridoActual) > sizeValido(resultado)) {
				resultado.removeAll(resultado);
				resultado.addAll(recorridoActual);
			}

		}
		
		for (GeneralTree<Integer> child : arbol.getChildren()) {
			recorridoMasLargo(child, resultado, recorridoActual);
			
			//System.out.println("validar: \n Resultado:" + sizeValido(resultado) + "\n RecorridoActual:"+ sizeValido(recorridoActual) );
		}
		
		recorridoActual.remove(recorridoActual.size()-1);
		
	}
	
	private static int sizeValido (List<Integer>list) {
		int cantidad = 0;
		for (Integer integer : list) {
			if (integer == 1) cantidad += 1;
		}
		return cantidad;
	}
	
	private static void valoresValidos (List<Integer>list) {
		int valorTotal = 0;
		List<Integer> listaLimpia = new LinkedList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == 1) {
				valorTotal += 1 * i;
				listaLimpia.add(list.get(i));
			}
		}
		System.out.println("valor total: " + valorTotal);
		
		list.removeAll(list);
		list.addAll(listaLimpia);
	}
	
	public static void main(String[] args) {
		/*
				1
		      / | \
		     0  1  1
		    /|  |\  \
		   1 1  1 0  0
		  /|\     |   \
		 0 0 1    0    0
		          |   / \
		          1  0   0
	    */
	
		// Nivel 4
		GeneralTree<Integer> n_4_1  = new GeneralTree<Integer>(1); // hijo de n8 (bajo rama izq)
		GeneralTree<Integer> n_4_hoja1 = new GeneralTree<Integer>(1); // hijo del 0 de nivel 3 (rama central)
		GeneralTree<Integer> n_4_hoja2 = new GeneralTree<Integer>(0); // hijos del 0 de nivel 3 (rama der)
		GeneralTree<Integer> n_4_hoja3 = new GeneralTree<Integer>(0);

		// Nivel 3
		GeneralTree<Integer> n7 = new GeneralTree<Integer>(0); // hoja
		GeneralTree<Integer> n8 = new GeneralTree<Integer>(0); // hoja
		GeneralTree<Integer> n9 = new GeneralTree<Integer>(1); // hoja, tercer hijo de n3
		n8.addChild(n_4_1);

		GeneralTree<Integer> n_3_central = new GeneralTree<Integer>(0); // bajo n5 (rama central)
		n_3_central.addChild(n_4_hoja1);

		GeneralTree<Integer> n_3_der = new GeneralTree<Integer>(0); // bajo n6 (rama derecha)
		n_3_der.addChild(n_4_hoja2);
		n_3_der.addChild(n_4_hoja3);

		// Nivel 2
		GeneralTree<Integer> n3 = new GeneralTree<Integer>(1); // hijo izq de n1
		n3.addChild(n7);
		n3.addChild(n8);
		n3.addChild(n9); // ← los tres hijos: 0, 0, 1

		GeneralTree<Integer> n4b = new GeneralTree<Integer>(1); // primer hijo de n2a — SIN hijos
		GeneralTree<Integer> n5  = new GeneralTree<Integer>(0); // segundo hijo de n2a
		n5.addChild(n_3_central);

		GeneralTree<Integer> n6 = new GeneralTree<Integer>(0); // hijo de n2b
		n6.addChild(n_3_der);

		// Nivel 1
		GeneralTree<Integer> n1 = new GeneralTree<Integer>(0);
		n1.addChild(n3);       // solo UN hijo: el 1 de nivel 2

		GeneralTree<Integer> n2a = new GeneralTree<Integer>(1);
		n2a.addChild(n4b);     // hijo 1 (hoja)
		n2a.addChild(n5);      // hijo 0 → tiene descendencia

		GeneralTree<Integer> n2b = new GeneralTree<Integer>(1);
		n2b.addChild(n6);      // solo el 0 que tiene descendencia

		// Raíz
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
