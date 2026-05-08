package tp3.punto11;
import tp3.punto1.GeneralTree;
import tp1.punto8.Queue;

public class ParcialArboles {

	public static boolean resolver(GeneralTree<Integer> arbol) {
		GeneralTree<Integer> agAux;
		Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
		cola.enqueue(arbol);
		cola.enqueue(null);
		int cantidadNodoNivel = 0, cantidadNodoNivelAnterior = 0;
		while (!cola.isEmpty()) {
			agAux = cola.dequeue();
			
			if (agAux != null) {
				cantidadNodoNivel += 1;
				
				for (GeneralTree<Integer> child : agAux.getChildren()) {
					cola.enqueue(child);
				}
			}
			else {
				if (cantidadNodoNivel > cantidadNodoNivelAnterior) {
					cantidadNodoNivelAnterior = cantidadNodoNivel;
					cantidadNodoNivel = 0;
				}else {
					return false;
				}
				
				if (!cola.isEmpty()) {
					cola.enqueue(null);
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		GeneralTree<Integer> arbol = new GeneralTree<>(2);

		// Nivel 2
		GeneralTree<Integer> nodo1 = new GeneralTree<>(1);
		GeneralTree<Integer> nodo25 = new GeneralTree<>(25);

		// Nivel 3
		GeneralTree<Integer> nodo5 = new GeneralTree<>(5);
		GeneralTree<Integer> nodo4 = new GeneralTree<>(4);
		GeneralTree<Integer> nodo13 = new GeneralTree<>(13);

		// Nivel 4
		GeneralTree<Integer> nodo18 = new GeneralTree<>(18);
		GeneralTree<Integer> nodo7 = new GeneralTree<>(7);
		GeneralTree<Integer> nodo11 = new GeneralTree<>(11);
		GeneralTree<Integer> nodo3 = new GeneralTree<>(3);

		// Nivel 5
		GeneralTree<Integer> nodo83 = new GeneralTree<>(83);
		GeneralTree<Integer> nodo33 = new GeneralTree<>(33);
		GeneralTree<Integer> nodo12 = new GeneralTree<>(12);
		GeneralTree<Integer> nodo17 = new GeneralTree<>(17);
		GeneralTree<Integer> nodo9 = new GeneralTree<>(9);

		// Relaciones

		// 2 -> 1, 25
		arbol.addChild(nodo1);
		arbol.addChild(nodo25);

		// 1 -> 5, 4
		nodo1.addChild(nodo5);
		nodo1.addChild(nodo4);

		// 25 -> 13
		nodo25.addChild(nodo13);

		// 5 -> 18
		nodo5.addChild(nodo18);

		// 18 -> 83
		nodo18.addChild(nodo83);

		// 4 -> 7, 11, 3
		nodo4.addChild(nodo7);
		nodo4.addChild(nodo11);
		nodo4.addChild(nodo3);

		// 3 -> 33, 12, 17, 9
		nodo3.addChild(nodo33);
		nodo3.addChild(nodo12);
		nodo3.addChild(nodo17);
		nodo3.addChild(nodo9);
		
		System.out.println(ParcialArboles.resolver(arbol));
	}

}
