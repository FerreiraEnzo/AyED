package tp3.ejercicio1;

import java.util.LinkedList;
import java.util.List;

public class mainEjemplo {

	public static void main(String[] args) {

						//ARBOL 1
		List<GeneralTree<String>>children1 = new LinkedList<GeneralTree<String>>();
		children1.add(new GeneralTree<String>("20"));
		children1.add(new GeneralTree<String>("21"));
		children1.add(new GeneralTree<String>("22"));
		GeneralTree<String> a1 = new GeneralTree<String>("1",children1);
		
							//ARBOL 2
		List<GeneralTree<String>>children2 = new LinkedList<GeneralTree<String>>();
		children2.add(new GeneralTree<String>("30"));
		children2.add(new GeneralTree<String>("31"));
		children2.add(new GeneralTree<String>("32"));
		GeneralTree<String> a2 = new GeneralTree<String>("2", children2);
		
		
		
		
	}

}
