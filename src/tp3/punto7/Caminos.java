package tp3.punto7;

import java.util.LinkedList;
import java.util.List;

import tp3.punto1.GeneralTree;

public class Caminos {

	private GeneralTree<Integer> numeros;
	
	public Caminos(GeneralTree<Integer> numeros) {
		this.numeros = numeros;
	}

	public List<Integer> caminoAHojaMasLejana (){
		List<Integer> resultado = new LinkedList<Integer>();
		if ( numeros != null && !numeros.isEmpty() ) {
			return null;
		}
		
		return resultado;
	}
	
	private void caminoAHojaMasLejana() {
		
	}
	
	public static void main(String[] args) {
		
		GeneralTree<Integer> n1 = new GeneralTree<Integer>();
		GeneralTree<Integer> n16 = new GeneralTree<Integer>();
		GeneralTree<Integer> n7 = new GeneralTree<Integer>();
		
		GeneralTree<Integer> n10 = new GeneralTree<Integer>();
		GeneralTree<Integer> n6 = new GeneralTree<Integer>();
		n6.addChild(n1);
		GeneralTree<Integer> n8 = new GeneralTree<Integer>();
		GeneralTree<Integer> n14 = new GeneralTree<Integer>();
		n14.addChild(n16);
		n14.addChild(n7);
		GeneralTree<Integer> n18 = new GeneralTree<Integer>();
		
		GeneralTree<Integer> n17 = new GeneralTree<Integer>();
		n17.addChild(n10);
		n17.addChild(n6);
		GeneralTree<Integer> n9 = new GeneralTree<Integer>();
		n9.addChild(n8);
		GeneralTree<Integer> n15 = new GeneralTree<Integer>();
		n15.addChild(n14);
		n15.addChild(n18);
		
		GeneralTree<Integer> n12 = new GeneralTree<Integer>(12);
		n12.addChild(n17);
		n12.addChild(n9);
		n12.addChild(n15);
		
		Caminos camino = new Caminos(n12);
		List<Integer> lista = camino.caminoAHojaMasLejana();
		
		for (Integer item: lista) {
			System.out.println(item);
		}

	}

}
