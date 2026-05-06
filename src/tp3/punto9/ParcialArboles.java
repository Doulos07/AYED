package tp3.punto9;

import tp3.punto1.GeneralTree;
import java.util.List;
public class ParcialArboles {

	public static boolean esDeSeleccion (GeneralTree<Integer> arbol) {
		if (arbol.isEmpty()) {
			return false;
		}
		if (arbol.isLeaf()) {
			return true;
		}
		
		int hijoMenor = obtenerHijoMenor(arbol.getChildren());
		
		//System.out.println("padre: " + arbol.getData() + "<=  Hijo" + hijoMenor);
		if (arbol.getData() <= hijoMenor) {
			for (GeneralTree<Integer> child: arbol.getChildren()) {
				if (!esDeSeleccion(child)) {
					return false;
				}
			}
		}else {
			return false;
		}
		
		return true;
	}
	
	private static int obtenerHijoMenor (List<GeneralTree<Integer>>children){
		
		int menor = Integer.MAX_VALUE;
		for (GeneralTree<Integer> child : children) {
			if (child.getData() <= menor) {
				menor = child.getData();
			}
		}
		
		return menor;
	}


	public static void main(String[] args) {
		
		GeneralTree<Integer> O = new GeneralTree<Integer>(33);
		GeneralTree<Integer> N = new GeneralTree<Integer>(90);
		GeneralTree<Integer> M = new GeneralTree<Integer>(83);
		GeneralTree<Integer> L = new GeneralTree<Integer>(35);
		GeneralTree<Integer> K = new GeneralTree<Integer>(35);
		
		GeneralTree<Integer> J = new GeneralTree<Integer>(33);
		J.addChild(L);
		J.addChild(M);
		J.addChild(N);
		J.addChild(O);
		GeneralTree<Integer> I = new GeneralTree<Integer>(18);
		GeneralTree<Integer> H = new GeneralTree<Integer>(14);
		GeneralTree<Integer> G = new GeneralTree<Integer>(35);
		G.addChild(K);
		
		GeneralTree<Integer> F = new GeneralTree<Integer>(25);
		//GeneralTree<Integer> E = new GeneralTree<Integer>(14); // true
		GeneralTree<Integer> E = new GeneralTree<Integer>(18);	// false
		E.addChild(H);
		E.addChild(I);
		E.addChild(J);
		GeneralTree<Integer> D = new GeneralTree<Integer>(35);
		D.addChild(G);
		
		
		GeneralTree<Integer> C = new GeneralTree<Integer>(25);
		C.addChild(F);
		GeneralTree<Integer> B = new GeneralTree<Integer>(12);
		B.addChild(D); 
		B.addChild(E);
		
		GeneralTree<Integer> A = new GeneralTree<Integer>(12);
		A.addChild(B);
		A.addChild(C);
		
		System.out.println(ParcialArboles.esDeSeleccion(A) ? "Es de selecicon" : "no es de seleccion");

	}

	
}
