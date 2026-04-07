package tp2.punto3;
import tp2.punto1.*;
import java.util.List;
import java.util.LinkedList;

public class ContadorArbol {
	
	BinaryTree<Integer> ab = new BinaryTree<>();
	
	public ContadorArbol(BinaryTree<Integer> ab) {
		this.ab = ab;
	}

	public List<Integer> numerosParesInOrden(BinaryTree<Integer> ab){
		List<Integer> ls = new LinkedList<Integer>();
		if (ab.hasLeftChild()) {
			ls.addAll(this.numerosParesInOrden(ab.getLeftChild()));
		}
		if (!ab.isEmpty()) {
			ls.add(ab.getData());
		}
		if (ab.hasRightChild()) {
			ls.addAll(this.numerosParesInOrden(ab.getRightChild()));
		}
		return ls;
	}
	
	public List<Integer> numerosParesPosOrden(BinaryTree<Integer> ab){
		List<Integer> ls = new LinkedList<Integer>();
		if (ab.hasLeftChild()) {
			ls.addAll(this.numerosParesInOrden(ab.getLeftChild()));
		}
		if (ab.hasRightChild()) {
			ls.addAll(this.numerosParesInOrden(ab.getRightChild()));
		}
		if (!ab.isEmpty()) {
			ls.add(ab.getData());
		}
		return ls;
		
	}
	
	public static void main(String [] args) {
		BinaryTree <Integer> ab = new BinaryTree <Integer> (40);
		BinaryTree <Integer> leftChild = new BinaryTree <Integer> (25);
		leftChild.addLeftChild(new BinaryTree<>(10));
		leftChild.addRightChild(new BinaryTree<>(30));
		BinaryTree <Integer> rigthChild = new BinaryTree<>(78);
		ab.addLeftChild(leftChild);
		ab.addRightChild(rigthChild);

		ContadorArbol contAb = new ContadorArbol(ab);
		
		List<Integer> listInOrden = null;
		
		listInOrden = contAb.numerosParesInOrden(ab);
		
		for (Integer integer : listInOrden) {
			System.out.println(integer);
		}
		
		System.out.println();
		
		listInOrden = contAb.numerosParesPosOrden(ab);
		
		for (Integer integer : listInOrden) {
			System.out.println(integer);
		}
	}
}
