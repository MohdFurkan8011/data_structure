package data_structure.stack.logical;

import java.util.Stack;

public class ReverseParenthesis {
	
	public static void main(String args[]) {
		
		String expn = "(())((()";
		System.out.println("Expression = " + expn);
		int count = reverseParenthesis(expn);
		System.out.println("Reverse Parenthesis is = " + count);
	}
	
	public static int reverseParenthesis(String exp) {
		
		Stack<Character> stackOfCharacter = new Stack<>();
		for(char currentChar: exp.toCharArray()) {
			
			if (currentChar == '(')
				stackOfCharacter.push(currentChar);
			else if (currentChar == ')') {
				
				if (!stackOfCharacter.isEmpty() && stackOfCharacter.peek() == '(')
					stackOfCharacter.pop();
				else
					stackOfCharacter.push(currentChar);
				
			}
			
		}
		
		int openCount = 0;
		int closeCount = 0;
		while(! stackOfCharacter.isEmpty()) {
			
			if (stackOfCharacter.pop() == '(')
				openCount += 1;
			else
				closeCount += 1;
		}
		return (int)Math.ceil(openCount/2.0) + (int) Math.ceil(closeCount/2.0);
	}
	
}