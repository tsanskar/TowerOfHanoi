package toh;

import java.util.EmptyStackException;

import bag.Node;

public class LinkedStack<T> implements StackInterface<T>{

	private Node<T> topNode;
	private int size;

	public LinkedStack()
	{
		topNode = null;
		size = 0;
	}
	
	@Override
	public void push(T anEntry) {
		
		Node<T> tempNode = new Node<T>(anEntry);
		tempNode.setNext(topNode);
		topNode = tempNode;
		size++;
	
	}

	@Override
	public T pop() {
		
		if (isEmpty()){
			
			throw new EmptyStackException();
		}
		
		Node<T> temp;
		temp = topNode;
		topNode = topNode.next();
		size--;
		
		return temp.data();
	}

	@Override
	public T peek() {
		if (isEmpty())
		{
			throw new EmptyStackException();
		}
		return topNode.data();
	}

	@Override
	public boolean isEmpty() {
		
		return topNode == null;
	}

	@Override
	public void clear() {
		
		topNode = null;
		size = 0;
	}
	
	public int size()
	{
		return size;
	}
	
	public String toString()
	{
		StringBuilder givenString = new StringBuilder();
		givenString.append("[");
		Node<T> currentNode = topNode;
		
		while(currentNode != null)
			{
			if(givenString.length() > 1)
			{
				givenString.append(",");
			}
			if(currentNode.data() == null)
			{
				currentNode = currentNode.next();
			}
		
			givenString.append(currentNode.data());
			currentNode = currentNode.next();
		}
		givenString.append("]");
		return givenString.toString();
	}
	
}
