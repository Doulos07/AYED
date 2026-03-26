package tp1.punto2;

import java.util.Scanner;

public class Contador {
	
	public static int [] NumerosMultiplos (int num) {
		int [] listaNumeros = new int [num];
		
		for (int i = 1; i <= num; i++) {
			listaNumeros[i - 1] = i * num;
		}
		
		return listaNumeros;
		
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		
		System.out.print("ingrese para obtener una lista de numeros multiples de la misma longitud");
		System.out.print("se corta con -1 ");
		
		int num = scan.nextInt();
		
		while ( num != -1 ) {
			int [] lista = new int [num];
			
			lista = Contador.NumerosMultiplos(num);
			
			for (int i : lista) {
				System.out.print("\n" + i);
			}
			
			System.out.print("\n Ingrese otro numero");
			num = scan.nextInt();
		}
		scan.close();
	}
	
}
