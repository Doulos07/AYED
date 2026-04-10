package tp2.punto3;
import tp2.punto1.*;
import java.util.List;
import java.util.LinkedList;
import java.util.*;
public class ContadorArbol {
	
	BinaryTree<Integer> ab = new BinaryTree<>();
	
	public ContadorArbol(BinaryTree<Integer> ab) {
		this.ab = ab;
	}

	public ArrayList<Integer> numerosParesA(){
		ArrayList<Integer> result = new ArrayList<Integer>();
		this.inOrden(ab, result);
		return result;
	}
	
	public ArrayList<Integer> numerosParesB(){
		ArrayList<Integer> result = new ArrayList<Integer>();
		this.postOrden(ab, result);
		return result;
	}	
	
	public void inOrden(BinaryTree<Integer> ab, ArrayList<Integer> lista){
		if (ab.hasLeftChild()) {
			this.inOrden(ab.getLeftChild(), lista);
		}
		if (!ab.isEmpty()) {
			if (ab.getData() % 2 == 0) lista.add(ab.getData());
		}
		if (ab.hasRightChild()) {
			this.inOrden(ab.getRightChild(), lista);
		}
	}
	
	public void postOrden(BinaryTree<Integer> ab, ArrayList<Integer> lista){
		if (ab.hasLeftChild()) {
			this.postOrden(ab.getLeftChild(), lista);
		}
		if (ab.hasRightChild()) {
			this.postOrden(ab.getRightChild(), lista);
		}
		if (!ab.isEmpty()) {
			
			if (ab.getData() % 2 == 0) lista.add(ab.getData());
		}
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
		
		listInOrden = contAb.numerosParesA();
		
		for (Integer integer : listInOrden) {
			System.out.println(integer);
		}
		
		System.out.println();
		
		listInOrden = contAb.numerosParesB();
		
		for (Integer integer : listInOrden) {
			System.out.println(integer);
		}
	}
}
