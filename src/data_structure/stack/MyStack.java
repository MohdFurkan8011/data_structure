package data_structure.stack;

public class MyStack {

	private int value;
	private MyStack next;
	
	public MyStack(int value, MyStack node) {

		this.value = value;
		this.next = node;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public MyStack getNext() {
		return next;
	}

	public void setNext(MyStack next) {
		this.next = next;
	}
	
	
	
}
