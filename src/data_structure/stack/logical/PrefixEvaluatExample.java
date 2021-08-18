package data_structure.stack.logical;

import java.util.Scanner;
import java.util.Stack;

public class PrefixEvaluatExample {

	public static void main(String args[]) {
		
		System.out.println("Prefix => + 9 * 2 6 => " + solvePrefix("+ 9 * 2 6"));
	}
	
	public static Integer solvePrefix(String prefixExp) {
		
		String prefixExpReverse = (new StringBuffer(prefixExp)).reverse().toString();
		Scanner scanner = new Scanner(prefixExpReverse);
		Stack<Integer> stack = new Stack<>();

		while (scanner.hasNext()) {
			
			if (scanner.hasNextInt()) {
				stack.add(scanner.nextInt());
			}
			else {
				
				char operator = scanner.next().charAt(0);
				Integer firstValue = stack.pop();
				Integer secondValue = stack.pop();
				
				switch(operator) {
				
					case '+': 
						stack.push(firstValue + secondValue);
						break;
					case '-':
						stack.push(firstValue - secondValue);
						break;
					case '*':
						stack.push(firstValue * secondValue);
						break;
					case '/':
						stack.push(firstValue / secondValue);
					default:
						break;
				}
			}
		}
		scanner.close();
		return stack.pop();
	}
	
}
