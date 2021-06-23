package data_structure.stack;

import java.util.Stack;

public class BalancedParenthesis {

	public static void main(String args[]) {
		
		
		System.out.println(isExpnBalanced("{()}[]"));
		System.out.println(isExpnBalanced("{()}[])"));
	}
	
	public static boolean isExpnBalanced(String expn) {
		
		Stack<Character> stackOfCharacter = new Stack<>();
		
		for(char currentChar : expn.toCharArray()) {
		
			if (currentChar == '(' || currentChar == '[' || currentChar == '{')
				stackOfCharacter.push(currentChar);
			else
				
				if (
					stackOfCharacter.isEmpty() ||
					(currentChar == ')' && stackOfCharacter.pop() != '(')
					|| (currentChar == ']' && stackOfCharacter.pop() != '[')
					|| (currentChar == '}' && stackOfCharacter.pop() != '{')
				)
					return false;
		}
		
		return stackOfCharacter.isEmpty();
	}
	
}