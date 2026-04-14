package tp2.punto5;
import tp2.punto1.*;
import tp1.punto8.*;

public class ProfundidadDeArbolBinario {
	
	BinaryTree<Integer> ab = null;
	
	public ProfundidadDeArbolBinario(BinaryTree<Integer> ab) {
		this.ab = ab;
	}

	public int sumaElementosProfundidad (int p) {
		BinaryTree<Integer> abAux = null;
		Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
		cola.enqueue(ab);
		cola.enqueue(null);
		int profundidad = 1, total = 0;
		
		while (!cola.isEmpty()) {
			abAux = cola.dequeue();
			if (abAux != null) {
				if (profundidad == p) {
					total += abAux.getData();
				}
				if (abAux.hasLeftChild()) {
					cola.enqueue(abAux.getLeftChild());
				}
				if (abAux.hasRightChild()) {
					cola.enqueue(abAux.getRightChild());
				}
			}
			else if (!cola.isEmpty()){
				cola.enqueue(null);
				profundidad += 1;
			}
		}
		
		return total;
	}
	
	public static void main(String[] args) {
		BinaryTree<Integer> ab = new BinaryTree<Integer>(10);
		BinaryTree<Integer> hijoIzquierdo = new BinaryTree<Integer>(10);
		BinaryTree<Integer> hijoDerecho = new BinaryTree<Integer>(10);
		
		hijoIzquierdo.addLeftChild(new BinaryTree<Integer>(10));
		hijoIzquierdo.addRightChild(new BinaryTree<Integer>(10));
		
		hijoDerecho.addLeftChild(new BinaryTree<Integer>(10));
		hijoDerecho.addRightChild(new BinaryTree<Integer>(10));
		
		ab.addLeftChild(hijoIzquierdo);
		ab.addRightChild(hijoDerecho);
		
		ProfundidadDeArbolBinario red = new ProfundidadDeArbolBinario(ab);
		System.out.print("total = " + red.sumaElementosProfundidad(3));
	}
}
