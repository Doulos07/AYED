package tp3.punto3;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		GeneralTree<Integer> ag = new GeneralTree<Integer>(10);
		
		GeneralTree<Integer> ag11 = new GeneralTree<Integer>(11);
		GeneralTree<Integer> ag30 = new GeneralTree<Integer>(30);
		GeneralTree<Integer> ag25 = new GeneralTree<Integer>(25);
		ag25.addChild(ag11);
		ag25.addChild(ag30);
		
		GeneralTree<Integer> ag21 = new GeneralTree<Integer>(21);
		GeneralTree<Integer> ag16 = new GeneralTree<Integer>(16);
		ag16.addChild(ag21);
		
		GeneralTree<Integer> ag40 = new GeneralTree<Integer>(40);
		GeneralTree<Integer> ag7 = new GeneralTree<Integer>(7);
		ag7.addChild(ag40);
		GeneralTree<Integer> ag15 = new GeneralTree<Integer>(15);
		GeneralTree<Integer> ag5 = new GeneralTree<Integer>(5);
		ag5.addChild(ag7);
		ag5.addChild(ag15);
		
		ag.addChild(ag5);
		ag.addChild(ag16);
		ag.addChild(ag25);

		System.out.println(ag.altura());
		System.out.println(ag.nivel(40));
		System.out.println(ag.ancho());
	}

}
