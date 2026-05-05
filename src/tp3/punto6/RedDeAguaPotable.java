package tp3.punto6;
import tp3.punto1.GeneralTree;

public class RedDeAguaPotable {

    private GeneralTree<Character> red;

    public RedDeAguaPotable(GeneralTree<Character> red) {
        this.red = red;
    }

	public double minimoCaudal(double caudal) {
		if (red.isEmpty()) return 0;
		
		return calcularMinimoCaudal(red, caudal);
	}
	
	private double calcularMinimoCaudal (GeneralTree<Character> red, double caudal) {
		if (red.isLeaf()) {
			return caudal;
		}
		
		int bifurcaciones = red.getChildren().size();
		if (bifurcaciones == 0) return caudal;
		
		double caudalHijo = caudal / bifurcaciones;
		double minimo = Integer.MAX_VALUE;
		System.out.println("Bifurcaciones:" + caudal);
		for (GeneralTree<Character> child: red.getChildren()) {
			double subCaudal = calcularMinimoCaudal(child, caudalHijo);
			if (subCaudal < minimo) {
				minimo = subCaudal;
			}
		}
		return minimo;
	}

	public static void main(String[] args) {
		GeneralTree<Character> N = new GeneralTree<Character>('N');
		GeneralTree<Character> M = new GeneralTree<Character>('M');
		GeneralTree<Character> L = new GeneralTree<Character>('L');
		
		GeneralTree<Character> P = new GeneralTree<Character>('P');
		GeneralTree<Character> K = new GeneralTree<Character>('K');
		GeneralTree<Character> J = new GeneralTree<Character>('J');
		J.addChild(M);
		J.addChild(N);
		GeneralTree<Character> I = new GeneralTree<Character>('I');
		GeneralTree<Character> H = new GeneralTree<Character>('H');
		GeneralTree<Character> G = new GeneralTree<Character>('G');
		G.addChild(L);
		GeneralTree<Character> F = new GeneralTree<Character>('F');
		
		
		GeneralTree<Character> E = new GeneralTree<Character>('E');
		GeneralTree<Character> D = new GeneralTree<Character>('D');
		D.addChild(H);
		D.addChild(I);
		D.addChild(J);
		D.addChild(K);
		D.addChild(P);
		GeneralTree<Character> C = new GeneralTree<Character>('C');
		C.addChild(F);
		C.addChild(G);
		GeneralTree<Character> B = new GeneralTree<Character>('B');
		
		GeneralTree<Character> A = new GeneralTree<Character>('A');
		A.addChild(B);
		A.addChild(C);
		A.addChild(D);
		A.addChild(E);
		
		RedDeAguaPotable red = new RedDeAguaPotable(A);
		System.out.println(red.minimoCaudal(1000));
	}
}
