package data_structure.stack.logical;

import java.util.Stack;

public class RedundantPair {

	public static void main(String[] args) {
		
		System.out.println("isRedundantPair => " + isRedundantPair("((a+b)+c)"));
		System.out.println("isRedundantPair => " + isRedundantPair("(a+b)+(c)"));
	}
	
	
	public static boolean isRedundantPair(String expn) {
		
		Stack<Character> stackOfCharacter = new Stack<>();
		
		for(char currentChar : expn.toCharArray()) {
			if (currentChar == ')') {
				int count = 0;
				while(!stackOfCharacter.isEmpty() && stackOfCharacter.peek() != '(') {
					stackOfCharacter.pop();
					count += 1;
				}
				if (count <= 1)
					return true;
			}
			else {
				stackOfCharacter.push(currentChar);
			}
		}
		
		return false;
	}
	
}
