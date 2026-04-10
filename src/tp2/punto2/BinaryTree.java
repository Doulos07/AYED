package tp2.punto2;
import tp1.punto8.*;

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
	
	public int contarHojas() {
	   if (this.isEmpty()) {
		   return 0;
	   }
	   if (this.isLeaf()) {
		   return 1;
	   }
	   int aux = 0;
	   if (this.hasLeftChild()) {
		   aux += this.getLeftChild().contarHojas();
	   }
	   if (this.hasRightChild()) {
		   aux += this.getRightChild().contarHojas();
	   }
	   return aux;
	   
	}
		
		
    	 
	public BinaryTree<T> espejo(){
		
		BinaryTree<T> abEspejo = new BinaryTree<T>();

	   if (!this.isEmpty()) {
		   abEspejo.setData(this.getData());
	   }
	   
	   if (this.hasLeftChild()) {
		   abEspejo.addRightChild(this.getLeftChild().espejo());
	   }
	   if (this.hasRightChild()) {
		   abEspejo.addLeftChild(this.getRightChild().espejo());
	   }
	   
	   return abEspejo;
	}

	// 0<=n<=m
	public void entreNiveles(int n, int m){
		if(this.isEmpty()) {
			System.out.println("El arbol esta vacio");
		}else if(n > m) {
			System.out.println("no cumple con el formato dado");
		}else {
			BinaryTree<T> ab = null;
			Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
			cola.enqueue(this);
			cola.enqueue(null);
			int level = 1;
			
			while (!cola.isEmpty()){

				ab = cola.dequeue();
				if (ab != null) {
					if(n <= level && m >= level) {
						System.out.print(ab.getData() + " ");
					}
					if (ab.hasLeftChild()) {
						cola.enqueue(ab.getLeftChild());
					}
					if (ab.hasRightChild()) {
						cola.enqueue(ab.getRightChild());
					}
				}else if (!cola.isEmpty()){
					cola.enqueue(null);
					level ++;
					System.out.println();
				}
				
			}
		}
   }
	
	public void imprimirPreorden() {
	    System.out.println(this.getData());
	    if (this.hasLeftChild()) {
	        this.getLeftChild().imprimirPreorden();
	    }
	    if (this.hasRightChild()) {
	    	this.getRightChild().imprimirPreorden();
	    }
	}
		
}

