package Resoluciones.Practica1.Ejercicio9;

import java.util.Stack;

public class TestBalanceo {
	
	public static boolean esBalanceado (String S) {
		Stack<Character> C = new Stack ();
		
		for (char c :S.toCharArray()) {
			if (c == '(' || c == '[' || c == '{') {
				C.push(c);
			}
			else
				if (c == ')' || c == ']' || c == '}') {
					if (C.isEmpty())return false;
					
					char top = C.pop();
					if ((c == ')' && top != '(') ||
		                    (c == ']' && top != '[') ||
		                    (c == '}' && top != '{')) {
					return false;
						}
					}
			}
		return C.isEmpty();
		}
	

}