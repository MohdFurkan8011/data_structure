package data_structure.stack.logical;

import java.util.Stack;
import java.util.StringJoiner;

public class PrintParenthesisNumber {

	public static void main(String []args) {
		
		String result = printParenthesisNumber("(((a+(b))+(c+d))))");
		System.out.println("Parenthesis number => " + result);
	}
	
	
	public static String printParenthesisNumber(String expn) {
	
		StringJoiner output = new StringJoiner(",", "[", "]");
		int count = 1;
		Stack<Integer> stackOfCharacter = new Stack<>();
		for(char currentChar : expn.toCharArray()) {
			if (currentChar == '(') {
				stackOfCharacter.push(count);
				output.add(String.valueOf(count));
				count += 1;
			}
			else if (currentChar == ')' && ! stackOfCharacter.isEmpty())
				output.add(String.valueOf(stackOfCharacter.pop()));
		}
		
		return output.toString();
	}
	
}
