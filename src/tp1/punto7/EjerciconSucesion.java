package tp1.punto7;

import java.util.*;
public class EjerciconSucesion {

	public List<Integer> calcularSucesion (int n){
		List<Integer> lista = new ArrayList<>();
		
		if (n == 1) {
			lista.add(n);
			return lista;
		}else {
			lista.addFirst(n);
			if ( (n % 2) == 0 ) {
				n = n / 2;
			}else {
				n = 3 * n + 1;
			}
			
			lista.addAll(this.calcularSucesion(n));
			return lista;
		}
	}
}
