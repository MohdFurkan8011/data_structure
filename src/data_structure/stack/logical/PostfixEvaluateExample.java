package data_structure.stack.logical;

import java.util.Scanner;
import java.util.Stack;

public class PostfixEvaluateExample {

	public static void main(String ...s) {
		
		String exp1 = "1 2 + 3 4 + *";
		String exp2 = "6 5 2 3 + 8 * + 3 + *";
		
		System.out.println(exp1 + " : " + postfixEvaluate(exp1));
		System.out.println(exp2 + " : " + postfixEvaluate(exp2));
	}
	
	
	public static int postfixEvaluate(String expn) {
		
		Stack<Integer> stack = new Stack<>();
		Scanner scanner = new Scanner(expn);
		
		while(scanner.hasNext()) {
			
			if (scanner.hasNextInt()) {
				stack.add(scanner.nextInt());
			} else {
				
				int num1 = stack.pop();
				int num2 = stack.pop();
				char operation = scanner.next().charAt(0);
				switch (operation) {
				case '+':
					stack.push(num1 + num2);
					break;
				case '-':
					stack.push(num1 - num2);
					break;
				case '*':
					stack.push(num1 * num2);
					break;
				case '/':
					stack.push(num1 / num2);
					break;
				default:
					break;
				}
				
			}
			
		}
		scanner.close();
		return stack.pop();
	}
	
}
