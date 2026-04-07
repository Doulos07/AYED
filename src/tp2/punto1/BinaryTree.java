package tp2.punto1;



public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

	// EJERCICIO 2
	
	public int contarHojas(BinaryTree<T> ab) {
	   if (ab.isEmpty()) {
		   return 0;
	   }
	   if (ab.isLeaf()) {
		   return 1;
	   }
	   int aux = 0;
	   if (ab.hasLeftChild()) {
		   aux += contarHojas(ab.getLeftChild());
	   }
	   if (ab.hasRightChild()) {
		   aux += contarHojas(ab.getRightChild());
	   }
	   return aux;
	   
	}
		
		
    	 
	public BinaryTree<T> espejo(BinaryTree<T> ab){
		
		BinaryTree<T> abEspejo = new BinaryTree<T>();

	   if (!ab.isEmpty()) {
		   abEspejo.setData(ab.getData());
	   }
	   
	   if (ab.hasLeftChild()) {
		   abEspejo.addRightChild(this.espejo(ab.getLeftChild()));
	   }
	   if (ab.hasRightChild()) {
		   abEspejo.addLeftChild(this.espejo(ab.getRightChild()));
	   }
	   
	   return abEspejo;
	}

	// 0<=n<=m
	public void entreNiveles(int n, int m, int aux){
		if (n <= m){
			if (!this.isEmpty() && (aux >= n && aux <= m)) { 
				System.out.println(this.getData());
			}
			if(this.hasLeftChild()) {
				this.getLeftChild().entreNiveles(n, m, aux + 1 );
			}
			if (this.hasRightChild()){
				this.getRightChild().entreNiveles(n, m, aux + 1);
			}
		}
   }
	
	public void imprimirPreorden(BinaryTree<T> ab) {
	    System.out.println(ab.getData());
	    if (ab.hasLeftChild()) {
	        this.imprimirPreorden(ab.getLeftChild());
	    }
	    if (ab.hasRightChild()) {
	        this.imprimirPreorden(ab.getRightChild());
	    }
	}
		
}

