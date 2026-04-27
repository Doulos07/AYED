package tp2.punto9;
import tp2.punto2.*;

public class ParcialArboles {

	public ParcialArboles() {
		// TODO Auto-generated constructor stub
	}

	public BinaryTree<?> sumAndDif(BinaryTree<Integer> arbol){
		return null;
	}
	
	
	public static void main(String[] args) {
	   
	    BinaryTree<Integer[][]> root = new BinaryTree<>(new Integer[][]{{20, 0}});
	    
	    // Hijos directos
	    BinaryTree<Integer[][]> rootIzquierdo = new BinaryTree<>(new Integer[][] {{5, 0}});
	    BinaryTree<Integer[][]> rootIDerecho = new BinaryTree<>(new Integer[][] {{30, 0}});
	    
	    // Hijos del hijo Directo Izquierdo
	    BinaryTree<Integer[][]> izqIzq = new BinaryTree<>(new Integer[][] {{-5, 0}});
	    BinaryTree<Integer[][]> izqDer = new BinaryTree<>(new Integer[][] {{10, 0}});
	    
	    BinaryTree<Integer[][]> izqDerIzq = new BinaryTree<>(new Integer[][] {{1, 0}});
	    
	    
	    // Hijos del hijo Directo Derecho
	    BinaryTree<Integer[][]> derIzq = new BinaryTree<>(new Integer[][] {{50, 0}});
	    BinaryTree<Integer[][]> derDer = new BinaryTree<>(new Integer[][] {{-9, 0}});
	    
	    BinaryTree<Integer[][]> derIzqDer = new BinaryTree<>(new Integer[][] {{4, 0}});
	    BinaryTree<Integer[][]> derIzqDerDer = new BinaryTree<>(new Integer[][] {{6, 0}});
	    
	    derIzqDer.addRightChild(derIzqDerDer);
	    
	    derIzq
	}

}

/*
 * El método recibe un árbol binario de enteros y devuelve un nuevo árbol que contenga en cada nodo dos tipos de información:
 *	La suma de los números a lo largo del camino desde la raíz hasta el nodo actual.
 *	La diferencia entre el número almacenado en el nodo original y el número almacenado en el nodo padre.
 *
 * 
 */