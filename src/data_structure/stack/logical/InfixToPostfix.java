package data_structure.stack.logical;

import java.util.Stack;

public class InfixToPostfix {

	public static void main(String []args) {
	
		String expn = "10+(20*30)";
		String result = infixToPostfix(expn);
		System.out.println("Postfix => " + result);
	}
	
	public static int precedence(char x) {
		
		if (x == '(')
			return 0;
		if (x == '+' || x == '-')
			return 1;
		if (x == '*' || x == '/' || x == '%')
			return 2;
		if (x == '^')
			return 3;
		return 4;
	}
	
	public static String infixToPostfix(String expn) {
		
		String output = "";
		char[] out = infixToPostfix(expn.toCharArray());
		
		for(char ch: out) {
			output+= ch;
		}
		
		return output;
	}
	
	public static char[] infixToPostfix(char[] arrayOfCharacters) {
		
		Stack<Character> stack = new Stack<>();
		String output = "";
		char out;
		
		for(char c : arrayOfCharacters) {
			
			if (c >= '0' && c <= '9') 
				output += c;
			
			else {
				switch(c) {
					case '+':
					case '-':
					case '*':
					case '/':
					case '%':
					case '^':
						while(! stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
							out = stack.pop();
							output = output + " " + out;
						}
						stack.push(c);
						output += " ";
						break;
					
					case '(':
						stack.push(c);
						break;
					case ')':
						while(!stack.isEmpty() && (out = stack.pop()) != '(')
							output = output + " " + out + " ";
						break;
					default:
						break;
				}
				
			}
		}
		
		while(!stack.isEmpty()) {
			out = stack.pop();
			output = output + out + " ";
		}
		
		return output.toCharArray();
	}
	
	
	
}