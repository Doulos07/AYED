package tp1.punto1;

public class Punto1 {	
	
	public static void imprimirNumerosFor (int a, int b) {
		for (int i = a; i <= b; i++) {
			System.out.print(i);
		}	
	}
	
	public static void imprimirNumerosWhile (int a, int b) {
		while (a <= b ){
			System.out.print(a);
			a++;
		}
	}
	
	public static void imprimirNumerosRecursivo (int a, int b) {
		if (a > b) return;
		
		System.out.print(a);

		Punto1.imprimirNumerosRecursivo(a + 1, b);
	}
	
}
