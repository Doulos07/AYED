package tp2.punto6;
import tp2.punto2.BinaryTree;

public class Transformacion {
	
	private BinaryTree<Integer> ab = null;

	public Transformacion(BinaryTree<Integer> ab) {
		this.ab = ab;
	}

	public BinaryTree<Integer> getAb() {
		return ab;
	}

	public void setAb(BinaryTree<Integer> ab) {
		this.ab = ab;
	}
	
	public BinaryTree<Integer> suma (){
		 if (!ab.isEmpty() && ab.getData() != null) {
			 return sumaRecursiva(ab);
		 }
		 else {
			 return null;
		 }
	}
	
	public BinaryTree<Integer> sumaRecursiva (BinaryTree<Integer> ab) {
		
		if (ab.isEmpty()) {
			return new BinaryTree<Integer>();
		}
		if (ab.isLeaf()) {
			return new BinaryTree<Integer>(0);
		}
		else {
			BinaryTree<Integer> hijoIzq = null;
			BinaryTree<Integer> hijoDer = null;
			int suma = 0;
			
			if (ab.hasLeftChild()) {
				hijoIzq = sumaRecursiva(ab.getLeftChild());
				suma += hijoIzq.getData();
				suma += ab.getLeftChild().getData();
			}
			if (ab.hasRightChild()) {
				hijoDer = sumaRecursiva(ab.getRightChild());
				suma += hijoDer.getData();
				suma += ab.getRightChild().getData();
			}
			
			BinaryTree<Integer> abSuma = new BinaryTree<Integer>(suma);
			abSuma.addLeftChild(hijoIzq);
			abSuma.addRightChild(hijoDer);
			
			return abSuma;
		}

	}
	
	public static void main(String[] args) {
		BinaryTree<Integer> root = new BinaryTree<>(1);

	    BinaryTree<Integer> n2 = new BinaryTree<>(2);
	    BinaryTree<Integer> n3 = new BinaryTree<>(3);
	    BinaryTree<Integer> n4 = new BinaryTree<>(4);
	    BinaryTree<Integer> n5 = new BinaryTree<>(5);
	    BinaryTree<Integer> n6 = new BinaryTree<>(6);
	    BinaryTree<Integer> n7 = new BinaryTree<>(7);
	    BinaryTree<Integer> n8 = new BinaryTree<>(8);

	    // Nivel 1
	    root.addLeftChild(n2);
	    root.addRightChild(n3);

	    // Nivel 2
	    n2.addRightChild(n4);
	    n3.addLeftChild(n5);
	    n3.addRightChild(n6);

	    // Nivel 3
	    n5.addLeftChild(n7);
	    n5.addRightChild(n8);
	    
	    Transformacion trans = new Transformacion(root);
	    
		trans.getAb().imprimirPreorden();
		BinaryTree<Integer> suma =  trans.suma();
		System.out.println();
		suma.imprimirPreorden();
	}

}
