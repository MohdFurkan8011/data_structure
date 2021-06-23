package data_structure.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveOccuranceChracter {

	public static void main(String[] args) {
		
		String result = RemoveOccuranceChracter.removeOccurance("caabbbacc");
		System.out.println(result);
	}
	
	public static String removeOccurance(String text) {
		
		Deque<Character> stack = new ArrayDeque<>();
		
		for(char currentChar : text.toCharArray()) {
			
			if (stack.size() < 2) {
				stack.push(currentChar);
			} else {
				
				char removeHead = stack.pop();
				if (currentChar == removeHead && currentChar == stack.peek()) {
					stack.pop();
				} else {
					stack.push(removeHead);
					stack.push(currentChar);
				}
			}
				
			
		}
		
		if (! stack.isEmpty()) {
			
			StringBuilder stringBuilder = new StringBuilder();
			while(! stack.isEmpty()) {
				
				stringBuilder.insert(0, stack.pop());
			}
			return stringBuilder.toString();
		}
		
		return "";
	}
	
}