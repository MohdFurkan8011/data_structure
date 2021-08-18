package data_structure.stack.logical;

public class MaxDepthParenthesis {

	public static void main(String[] args) {

		int maxDepth = maxDethParenthesis("((()))()()");
		System.out.println("Max Depth => " + maxDepth);
	}

	public static int maxDethParenthesis(String expn) {

		int depth = 0;
		int maxDepth = 0;

		for (char currentChar : expn.toCharArray()) {
			if (currentChar == '(')
				depth += 1;
			else
				depth -= 1;
		
			if (depth > maxDepth)
				maxDepth = depth;
		}

		return maxDepth;
	}

}