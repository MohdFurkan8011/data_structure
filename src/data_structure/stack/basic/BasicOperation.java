package data_structure.stack.basic;

import data_structure.stack.MyStack;

public class BasicOperation {

	private MyStack head;
	private Integer size = 0;
	
	public boolean isEmpty() {
		
		return size == 0;
	}
	
	public int peek() throws IllegalStateException {
		
		if (isEmpty())
			throw new IllegalStateException("Stack is empty");
		
		return head.getValue();
	}
	
	public void push(int value) {
		
		head = new MyStack(value, head);
		size++;
	}
	
	public void sortedInsert(int value) {
		
		if (head == null || isEmpty() || value > peek()) {
			push(value);
		}
		else {
			int temp = pop();
			sortedInsert(value);
			push(temp);
		}
	}
	
	public void bottomInsert(int value) {
		
		if (isEmpty()) {
			push(value);
		} else {
			int temp = pop();
			bottomInsert(value);
			push(temp);
		}
	}
	
	public int pop() throws IllegalStateException {
		
		if (isEmpty())
			throw new IllegalStateException("Stack is empty");
		
		int value = head.getValue();
		head = head.getNext();
		size--;
		return value;
	}
	
	public void print() {
		System.out.println("**************");
		MyStack temp = head;
		while(temp != null) {
			System.out.print(temp.getValue() + " ");
			temp = temp.getNext();
		}
		System.out.println("");
	}
	
	public static void main(String args[]) {
		
		BasicOperation operation = new BasicOperation();
		operation.push(1);
		operation.push(2);
		operation.push(3);
		operation.print();
		System.out.println("Operation => " + operation.size);
		System.out.println(operation.pop());
		System.out.println(operation.pop());
		operation.print();
		System.out.println("Operation => " + operation.size);
		
		operation.sortedInsert(3);
		operation.sortedInsert(2);
		operation.print();
		
		System.out.println("Operation Size => " + operation.size);
		
		operation.bottomInsert(5);
		operation.print();
	}
	
}
