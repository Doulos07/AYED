package tp2.punto2;

public class Main {

	public static void main(String [] args) {
		BinaryTree <Integer> ab = new BinaryTree <Integer> (40);
		BinaryTree <Integer> leftChild = new BinaryTree <Integer> (25);
		leftChild.addLeftChild(new BinaryTree<>(10));
		leftChild.addRightChild(new BinaryTree<>(30));
		BinaryTree <Integer> rigthChild = new BinaryTree<>(78);
		ab.addLeftChild(leftChild);
		ab.addRightChild(rigthChild);
		System.out.println(ab.contarHojas());
		
		ab.imprimirPreorden();
		ab = ab.espejo();
		System.out.println();
		ab.imprimirPreorden();
		
		System.out.println();
		ab.entreNiveles(1, 3);
	}
}
