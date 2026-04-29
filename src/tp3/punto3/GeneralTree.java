package tp3.punto3;

import java.util.LinkedList;
import java.util.List;
import tp1.punto8.Queue;

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
	
	public int altura() {	 
		if (this.isEmpty()) return 0;
		
		int altura = 0;
		
		for (GeneralTree<T> child : children) {
			int alturaHijo = child.altura();
			if (alturaHijo > altura) {
				altura = alturaHijo;
			}
		}
		
		return altura + 1;
	}
	
	/*
	public int nivel(T dato){
		int nivel = 0;
		
		if (!this.isEmpty()) {
			
			if (this.getData() == dato) {
				return 1;
			}
			
			for (GeneralTree<T> child : this.getChildren()) {
				int aux = 0;
				aux += child.nivel(dato);
				if (aux != 0) {
					nivel += aux + 1;
					break;
				}
			}
			
		}
		return nivel;
	  }
	  */

	public int nivel(T dato){
		if (this.isEmpty()) return -1;
		
		if (this.getData().equals(dato)) {
			return 0;
		}
		
		for (GeneralTree<T> child : this.getChildren()) {
			int nivelHijo = child.nivel(dato);
			if (nivelHijo != -1) {
				return nivelHijo + 1;
			}
		}
		
		return -1;
	}
	
	public int ancho(){
		GeneralTree<T> agAux = new GeneralTree<T>();
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		cola.enqueue(this);
		cola.enqueue(null);
		int nivel = 1, nivelMaxAncho = 1, ancho = 0, anchoMax = 0;
		
		while (!cola.isEmpty()) {
			agAux = cola.dequeue();
			if (agAux != null) {
				for (GeneralTree<T> child : agAux.getChildren()) {
					cola.enqueue(child);
				}
				
				ancho += 1;
				// ancho del nivel
				if (ancho > anchoMax) {
					anchoMax = ancho;
					nivelMaxAncho = nivel;
				}
			}
			else {
				nivel += 1;
				ancho = 0;
				if (!cola.isEmpty()) {
					cola.enqueue(null);
				}
			}
		}
		
		return nivelMaxAncho;
	}
}