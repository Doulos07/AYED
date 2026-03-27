package tp1.punto5;

import java.util.Random;

public class Calculador {

	private int maximo = Integer.MIN_VALUE;
	private int minimo = Integer.MAX_VALUE;
	private float promedio = 0;
	private int [] numeros = null;
	
	public Calculador () {
	}
	
	public Calculador (int[] numeros) {
		this.numeros = numeros;
	}
	
	
	public static Calculador metodoConReturn (int [] numeros) {
		Calculador resultado = new Calculador();
		
		float promedio = 0;
		
		for (int i = 0; i < numeros.length; i++) {
			int num = numeros[i];
			
			if (num > resultado.getMaximo()) {
				resultado.setMaximo(num);
			}
			else if (num < resultado.getMaximo()) {
				resultado.setMinimo(num);
			}
			
			promedio += num;
		}
		
		resultado.setPromedio(promedio / numeros.length);
		
		return resultado;
		
	}
	
	public static void metodoSinReturn (int [] numeros, Calculador resultado) {

		for (int i = 0; i < numeros.length; i++) {
			int num = numeros[i];
			
			if (num > resultado.getMaximo()) {
				resultado.setMaximo(num);
			}
			else if (num < resultado.getMaximo()) {
				resultado.setMinimo(num);
			}
			
			resultado.setPromedio(resultado.getPromedio() + num);
		}
		
		resultado.calcularPromedio(resultado.getPromedio(), numeros.length);
	}
	
	
	public void sinParametroYReturn () {
		int [] numeros = this.getNumeros();

		for (int i = 0; i < numeros.length; i++) {
			int num = numeros[i];
			
			if (num > this.getMaximo()) {
				this.setMaximo(num);
			}
			else if (num < this.getMaximo()) {
				this.setMinimo(num);
			}
			
			this.setPromedio(this.getPromedio() + num);
		}
		
		this.calcularPromedio(this.getPromedio(), numeros.length);
	}
			
	
	public void calcularPromedio (float total, int cantidad) {
		this.setPromedio(total / cantidad);
	}
	
	public int getMaximo() {
		return maximo;
	}

	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}

	public int getMinimo() {
		return minimo;
	}

	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}

	public float getPromedio() {
		return promedio;
	}

	public void setPromedio(float promedio) {
		this.promedio = promedio;
	}
	
	
	public int[] getNumeros() {
		return numeros;
	}

	public void setNumeros(int[] numeros) {
		this.numeros = numeros;
	}

	@Override
	public String toString() {
		return "maximo=" + maximo + ", minimo=" + minimo + ", promedio=" + promedio;
	}

	public static void main(String[] args) {
	    int[] enteros = new int[10];
	    Calculador resultado = null;
	    Random random = new Random();
	    
	
	    for (int i = 0; i < enteros.length; i++) {
	        enteros[i] = random.nextInt(100) + 1; 
	    }
	
	    for (int n : enteros) {
	        System.out.println(n);
	    }
	    
	    resultado = Calculador.metodoConReturn(enteros);
	    
	    System.out.println(resultado.toString());
	    
	    // Vuelvo a crear una nueva instancia de clase para resetar los valores viejos
	    resultado = new Calculador();
	    
	    Calculador.metodoSinReturn(enteros, resultado);
	    System.out.println(resultado.toString());
	    
	    resultado = new Calculador(enteros);
	    resultado.sinParametroYReturn();
	    System.out.println(resultado.toString());
	    
	}

}
