package tp2.punto8;

import tp2.punto2.BinaryTree;

public class ParcialArboles {

	public ParcialArboles() {
		// TODO Auto-generated constructor stub
	}

	public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		
		if (arbol1.isEmpty() && arbol2.isEmpty()) {
			return true;
		}
		if (arbol1.isLeaf() && arbol2.isLeaf()) {
			if (arbol1.getData() == arbol2.getData()) {
				return true;
			}
			return false;
		}
		else {
			boolean prefijo = true;
			System.out.println(prefijo);
			System.out.println("ab1: " + arbol1.getData());
			System.out.println("ab2: " + arbol2.getData());
			
			if (arbol1.getData() != arbol2.getData()) {
				return false;
			}
			
			
			if (arbol1.hasLeftChild()) {
				if (arbol2.hasLeftChild()) {
					prefijo = prefijo && this.esPrefijo(arbol1.getLeftChild(), arbol2.getLeftChild());
				}
				else {
					return false;
				}
			}
			
			if (arbol1.hasRightChild()) {
				if (arbol2.hasRightChild()) {
					prefijo = prefijo && this.esPrefijo(arbol1.getRightChild(), arbol2.getRightChild());
				}
				else {
					return false;
				}
			}
			
			
			return prefijo;
			
		}
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

	    
	    BinaryTree<Integer> ab2 = new BinaryTree<Integer>(2);

	    // Nivel 1
	    ab2.addLeftChild(new BinaryTree<Integer>(7));
	    ab2.addRightChild(new BinaryTree<Integer>(-5));

	    ab.entreNiveles(1, 2);
	    System.out.println();
	    
	    ab2.entreNiveles(1, 2);
	    System.out.println();
	    
	    ParcialArboles pruebaArbol = new ParcialArboles();
	    System.out.println(pruebaArbol.esPrefijo(ab2, ab));
	}

}
