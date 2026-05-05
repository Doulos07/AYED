package tp3.punto5;

import java.util.LinkedList;
import java.util.List;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	//devuelve true si el valor “a” es ancestro del valor “b”.
	public boolean esAncestro(T a, T b) {
		if (this.isEmpty() || !this.hasChildren()) {
			return false;
		}
		
		GeneralTree<T> ancestro = buscarNodo(a);
		if (ancestro != null) {
			return ancestro.contiene(b);
		}
		return false;
	}
	
	private GeneralTree<T> buscarNodo(T a) {
		
		if (this.getData().equals(a)) {
			return this;
		}
		for (GeneralTree<T> child : this.getChildren()) {
			GeneralTree<T> nodo = child.buscarNodo(a);
			if (nodo != null) return nodo;
		}
		return null;
	}

	private boolean contiene (T b) {
		if (this.getData().equals(b)) {
			return true;
		}
		for (GeneralTree<T> child : this.getChildren()) {
			boolean result = child.contiene(b);
			if (result) return result;
		}
		return false;
	}
	
	public static void main(String[] args) {
	    //        A
	    //       /|\
	    //      B  C  D
	    //     / \    |
	    //    E   F   G

	    GeneralTree<Character> E = new GeneralTree<>('E');
	    GeneralTree<Character> F = new GeneralTree<>('F');
	    GeneralTree<Character> G = new GeneralTree<>('G');

	    GeneralTree<Character> B = new GeneralTree<>('B');
	    B.addChild(E);
	    B.addChild(F);

	    GeneralTree<Character> C = new GeneralTree<>('C');
	    GeneralTree<Character> D = new GeneralTree<>('D');
	    D.addChild(G);

	    GeneralTree<Character> A = new GeneralTree<>('A');
	    A.addChild(B);
	    A.addChild(C);
	    A.addChild(D);

	    // A es ancestro de E? → true
	    System.out.println(A.esAncestro('A', 'E'));  // true

	    // B es ancestro de E? → true
	    System.out.println(A.esAncestro('B', 'E'));  // true

	    // D es ancestro de G? → true
	    System.out.println(A.esAncestro('D', 'G'));  // true

	    // E es ancestro de B? → false (es al revés)
	    System.out.println(A.esAncestro('E', 'B'));  // false

	    // C es ancestro de G? → false (ramas distintas)
	    System.out.println(A.esAncestro('C', 'G'));  // false

	    // A es ancestro de A? → true o false segun criterio
	    System.out.println(A.esAncestro('A', 'A'));  // true
	}
}