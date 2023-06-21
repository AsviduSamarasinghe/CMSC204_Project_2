/*
 * Class: CMSC204  
 * Due: 06/20/2023
 * Asvidu Samarasinghe
*/
import java.util.ArrayList;

public class MyStack <T> implements StackInterface<T> {

	private T[] stack;
	private int topIndex;
	private static final int MAX_INDEX = 50;
	
	public MyStack() {
		this(MAX_INDEX);
	}
	
	@SuppressWarnings("unchecked")
	public MyStack(int maxStack) {
		T[] tempStack = (T[]) new Object[maxStack];
		stack = tempStack;
		
		topIndex = -1;
	}
	
	/**
	 * Checks if Stack is empty
	 * @return 
	 */
	@Override
	public boolean isEmpty() {
		return stack[0] == null;
	}

	/**
	 * Checks if Stack is full
	 * @return 
	 */
	@Override
	public boolean isFull() {
		
		if (topIndex == stack.length-1)
			return true;
		
		return false;
	}

	/**
	 * Deletes the element at the top of the Stack
	 * @return 
	 * @throws StackUnderflowException 
	 */
	@Override
	public T pop() throws StackUnderflowException {
		T tossed = null;
		
		if (!isEmpty())
		{
			tossed = stack[topIndex];
			stack[topIndex] = null;
			topIndex--;
		}
		
		else
			throw new StackUnderflowException();
			
		return tossed;
	}

	/**
	 * Returns the element at top of the Stack
	 * @return 
	 * @throws StackUnderflowException
	 */
	@Override
	public T top() throws StackUnderflowException {
		T item = null;
		
		if (!isEmpty())
			item = stack[topIndex];
		else 
			throw new StackUnderflowException();
		
		return item;
	}

	/**
	 * Adds an element to the top of the Stack
	 * @param 
	 * @return 
	 * @throws StackOverflowException 
	 */
	@Override
	public boolean push(Object e) throws StackOverflowException {
		boolean added = false;
		
		if (!isFull()) {
			topIndex++;
			stack[topIndex] = (T) e;
			added = true;
		}
		
		else if (isFull())
			throw new StackOverflowException();
		
		return added;
	}

	/**
	 * Number of elements in the Stack
	 * @return 
	 */
	@Override
	public int size() {
		return topIndex+1;
	}
	
	/**
	 * Returns element in toString bottom to top
	 * @return 
	 */
	@Override
	public String toString() {
		String line = "";
		
		for(int i = 0; i <= topIndex; i++)
			line += stack[i];
		
		return line;
	}
	
	/**
	 * Returns element in toString bottom to top, adding delimiter between elements 
	 * @return
	 */
	@Override
	public String toString(String delimiter) {
		String line = "";
		
		for(int i = 0; i <= topIndex; i++)
		{
			
				line += stack[i];
				if (i < topIndex)
					line += delimiter;
		}
		
		return line;
	}

	/**
	  * Adds to the queue with the elements in the ArrayList
	  * @param 
	  * @throws StackOverflowException 
	  */
	@SuppressWarnings("rawtypes")
	@Override
	public void fill(ArrayList list) {
		ArrayList tempList = list;
		
		for (int i = 0; i < tempList.size(); i++) {
			try {
				push(tempList.get(i));
			} catch (StackOverflowException e) {
				e.printStackTrace();
			}
		}
	}

}