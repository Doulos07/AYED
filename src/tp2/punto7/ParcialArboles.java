package tp2.punto7;

import tp2.punto2.BinaryTree;

public class ParcialArboles {

	BinaryTree<Integer> arbol = null;
	
	public ParcialArboles(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}

	
	
	public BinaryTree<Integer> getArbol() {
		return arbol;
	}



	public boolean isLeftTree (int num) {
		if (arbol.isEmpty()) {
			return false;
		}
		BinaryTree<Integer> ab = this.buscarArbol(arbol, num);
		if (ab != null) {
			return this.procesarSubArbol(ab);
		}
		return false;
	}
	
	
	public BinaryTree<Integer> buscarArbol(BinaryTree<Integer> ab, int num) {
		if (ab.isEmpty()) {
			return null;
		}
		if (ab.getData() == num) {
			return ab;
		}
		else {
			BinaryTree<Integer> abAux = null;
			if (ab.hasLeftChild()) {
				abAux = this.buscarArbol(ab.getLeftChild(), num);
			}
			if (ab.hasRightChild() && abAux == null) {
				abAux = this.buscarArbol(ab.getRightChild(), num);
			}
			return abAux;
		}
	}

	public boolean procesarSubArbol(BinaryTree<Integer> ab) {
		int izq = 0, der = 0;
		
		if (ab.hasLeftChild()) {
			izq = this.contarHojas(ab.getLeftChild());
		}else {
			izq = -1;
		}
		
		if (ab.hasRightChild()) {
			der = this.contarHojas(ab.getRightChild());
		}else {
			der = -1;
		}

		return izq > der;
	}
	
	public int contarHojas (BinaryTree<Integer> ab) {
		int totalHijos = 0;
		
		if (ab.hasLeftChild()) {
			totalHijos += this.contarHojas(ab.getLeftChild());
		}
		
		if (ab.hasRightChild()) {
			totalHijos += this.contarHojas(ab.getRightChild());
		}
		
		if ( (ab.hasLeftChild() && !ab.hasRightChild()) || (!ab.hasLeftChild() && ab.hasRightChild()) ) {
			return totalHijos += 1;
		}
		
		return totalHijos;
		
	}
	
	public static void main(String[] args) {

	    BinaryTree<Integer> ab = new BinaryTree<Integer>(2);

	    // Nivel 1
	    BinaryTree<Integer> n7 = new BinaryTree<Integer>(7);
	    BinaryTree<Integer> n_5 = new BinaryTree<Integer>(-5);

	    ab.addLeftChild(n7);
	    ab.addRightChild(n_5);

	    // Subárbol izquierdo (7)
	    BinaryTree<Integer> n23 = new BinaryTree<Integer>(23);
	    BinaryTree<Integer> n6 = new BinaryTree<Integer>(6);

	    n7.addLeftChild(n23);
	    n7.addRightChild(n6);

	    BinaryTree<Integer> n_3 = new BinaryTree<Integer>(-3);
	    n23.addLeftChild(n_3);

	    BinaryTree<Integer> n55 = new BinaryTree<Integer>(55);
	    BinaryTree<Integer> n11 = new BinaryTree<Integer>(11);

	    n6.addLeftChild(n55);
	    n6.addRightChild(n11);

	    // Subárbol derecho (-5)
	    BinaryTree<Integer> n19 = new BinaryTree<Integer>(19);
	    n_5.addLeftChild(n19); // en la imagen parece único hijo

	    BinaryTree<Integer> n4 = new BinaryTree<Integer>(4);
	    n19.addRightChild(n4);

	    BinaryTree<Integer> n18 = new BinaryTree<Integer>(18);
	    n4.addLeftChild(n18);

	    // Prueba
	    ParcialArboles arbol = new ParcialArboles(ab);

	    arbol.getArbol().imprimirPreorden();

	    System.out.println("----------------------");

	    System.out.println(arbol.isLeftTree(7));
	}

}
