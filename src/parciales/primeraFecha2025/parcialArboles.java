package parciales.primeraFecha2025;
import java.util.LinkedList;
import java.util.List;
import tp3.punto1.GeneralTree;

public class parcialArboles {

	public static List<Integer> caminoParidadAlternante (GeneralTree<Integer> arbol){
		List<Integer> resultado = new LinkedList<Integer>();
		if (arbol != null && !arbol.isEmpty()) {
			caminoParidadAlternante(arbol, resultado, new LinkedList<Integer>());
		}
		
		return resultado;
	}
	
	private static void caminoParidadAlternante (GeneralTree<Integer> arbol, List<Integer> resultado, List<Integer> recorridoActual){
		recorridoActual.add(arbol.getData());
		
		if (arbol.isLeaf()) {
			if (recorridoActual.size() > resultado.size()) {
				resultado.removeAll(resultado);
				resultado.addAll(recorridoActual);
			}
		}
		int valorArbol = arbol.getData() % 2;
		for (GeneralTree<Integer> child : arbol.getChildren()) {
			int valorArbolHijo = child.getData() % 2;
			System.out.println(valorArbol + " " + valorArbolHijo);
			if (valorArbol != valorArbolHijo) {
				caminoParidadAlternante(child, resultado, recorridoActual);
			}
		}
		recorridoActual.remove(recorridoActual.size()-1);
	}
	
	public static void main(String[] args) {
		// nivel 0
		GeneralTree<Integer> n2 = new GeneralTree<Integer>(2);
		
		// nivel 1
		GeneralTree<Integer> n3 = new GeneralTree<Integer>(3);
		GeneralTree<Integer> n5 = new GeneralTree<Integer>(5);
		
		// nivel 2
		GeneralTree<Integer> n1 = new GeneralTree<Integer>(1);
		GeneralTree<Integer> n4 = new GeneralTree<Integer>(4);
		GeneralTree<Integer> n6a = new GeneralTree<Integer>(6);
		GeneralTree<Integer> n6b = new GeneralTree<Integer>(6);
		
		// nivel 3
		GeneralTree<Integer> n8 = new GeneralTree<Integer>(8);

		n2.addChild(n3);
		n2.addChild(n5);
		
		n3.addChild(n1);
		n3.addChild(n4);
		n3.addChild(n6a);
		n5.addChild(n6b);
		
		n6a.addChild(n8);
		
		List<Integer> resultado = parcialArboles.caminoParidadAlternante(n2);
		
		for (Integer integer : resultado) {
			System.out.println(integer);
		}
	}

}
