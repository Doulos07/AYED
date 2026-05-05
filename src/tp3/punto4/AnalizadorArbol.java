package tp3.punto4;
import tp3.punto1.GeneralTree;
import tp1.punto8.Queue;

public class AnalizadorArbol {

	public AnalizadorArbol() {
		// TODO Auto-generated constructor stub
	}

	public double devolverMaximoPromedio (GeneralTree<AreaEmpresa>arbol) {
		GeneralTree<AreaEmpresa> arbolAux = new GeneralTree<AreaEmpresa>();
		Queue<GeneralTree<AreaEmpresa>> cola = new Queue<GeneralTree<AreaEmpresa>>();
		cola.enqueue(arbol);
		cola.enqueue(null);
		int cantidadMensajes = 0, sumaMensajeTardansa = 0, promedioMayor = 0;
		
		while (!cola.isEmpty()) {
			arbolAux = cola.dequeue();
			if (arbolAux != null) {
				
				for (GeneralTree<AreaEmpresa> child: arbolAux.getChildren()) {
					cola.enqueue(child);
				}
				
				sumaMensajeTardansa += arbolAux.getData().getTardansa_mensaje();
				cantidadMensajes += 1;
			}
			else {
				int promedio = sumaMensajeTardansa / cantidadMensajes;
				if (promedio > promedioMayor) {
					promedioMayor = promedio;
				}
				
				if (!cola.isEmpty()) {
					cantidadMensajes = 0;
					sumaMensajeTardansa = 0;
					cola.enqueue(null);
				}
			}
		}
		return promedioMayor;
	}
	
	public static void main(String[] args) {
		AnalizadorArbol analizar = new AnalizadorArbol();
		GeneralTree<AreaEmpresa> abA = new GeneralTree<AreaEmpresa>(new AreaEmpresa("A", 4));
		GeneralTree<AreaEmpresa> abB = new GeneralTree<AreaEmpresa>(new AreaEmpresa("B", 7));
		GeneralTree<AreaEmpresa> abC = new GeneralTree<AreaEmpresa>(new AreaEmpresa("C", 5));
		
		GeneralTree<AreaEmpresa> abD = new GeneralTree<AreaEmpresa>(new AreaEmpresa("D", 6));
		GeneralTree<AreaEmpresa> abE = new GeneralTree<AreaEmpresa>(new AreaEmpresa("E", 10));
		GeneralTree<AreaEmpresa> abF = new GeneralTree<AreaEmpresa>(new AreaEmpresa("F", 18));

		GeneralTree<AreaEmpresa> abG = new GeneralTree<AreaEmpresa>(new AreaEmpresa("G", 9));
		GeneralTree<AreaEmpresa> abH = new GeneralTree<AreaEmpresa>(new AreaEmpresa("H", 12));
		GeneralTree<AreaEmpresa> abI = new GeneralTree<AreaEmpresa>(new AreaEmpresa("I", 19));	
		
		GeneralTree<AreaEmpresa> abJ = new GeneralTree<AreaEmpresa>(new AreaEmpresa("J", 13));
		abJ.addChild(abA);
		abJ.addChild(abB);
		abJ.addChild(abC);
		
		GeneralTree<AreaEmpresa> abK = new GeneralTree<AreaEmpresa>(new AreaEmpresa("K", 25));
		abK.addChild(abD);
		abK.addChild(abE);
		abK.addChild(abF);
		
		GeneralTree<AreaEmpresa> abL = new GeneralTree<AreaEmpresa>(new AreaEmpresa("L", 10));
		abL.addChild(abG);
		abL.addChild(abH);
		abL.addChild(abI);
		
		GeneralTree<AreaEmpresa> abM = new GeneralTree<AreaEmpresa>(new AreaEmpresa("M", 14));
		abM.addChild(abJ);
		abM.addChild(abK);
		abM.addChild(abL);
		
		System.out.println(analizar.devolverMaximoPromedio(abM));

	}

}
