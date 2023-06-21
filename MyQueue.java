/*
 * Class: CMSC204  
 * Due: 06/20/2023
 * Asvidu Samarasinghe
*/

import java.util.ArrayList;

public class MyQueue <T> implements QueueInterface<T> {

	private T[] queue;
	private int frontIndex, backIndex, maxIndex;
	private static final int MAX_INDEX = 50;
	
	public MyQueue() {
		this(MAX_INDEX);
	}
	
	
	public MyQueue(int maxQueue) {
		
		@SuppressWarnings("unchecked")
		T[] tempQueue = (T[]) new Object[maxQueue + 1];
		queue = tempQueue;
		frontIndex = 0;
		backIndex = 0;
		maxIndex = maxQueue;
	}
	
	/**
	 * Checks queue is empty
	 * @return 
	 */
	@Override
	public boolean isEmpty() {
		return queue[frontIndex] == null;
	}

	/**
	 * Checks if queue is Full
	 * @return 
	 */
	@Override
	public boolean isFull() {
		boolean full = true;
		
		for (int i = 0; i < maxIndex; i++)
		{
			if (queue[i] == null)
			{
				full = false;
				break;
			}
		}
		
		return full;
	}

	/**
	 * Return number of elements in queue
	 * @return
	 */
	@Override
	public int size() {
		return Math.abs(backIndex - frontIndex);
	}
	
	/**
	 * Deletes and returns front element
	 * @return
	 * @throws QueueUnderflowException 
	 */
	@Override
	public T dequeue() throws QueueUnderflowException {
		T front = null;
		
		if(!isEmpty())
		{
			front = queue[frontIndex];
			queue[frontIndex] = null;
			frontIndex = (frontIndex + 1) % queue.length;
		}
		
		else
			throw new QueueUnderflowException();
		
		return front;
	}

	/**
	 * Add element to the end of queue
	 * @param 
	 * @return 
	 * @throws QueueOverflowException 
	 */
	@SuppressWarnings("unchecked")
	public boolean enqueue(Object object) throws QueueOverflowException {
		boolean added = false;		
		
		if(!isFull())
		{
			queue[backIndex] = (T) object;
			backIndex = (backIndex + 1) % queue.length; 
			added = true;
		}
		
		else
			throw new QueueOverflowException();
		
		return added;
	}

	/**
	 * toString
	 * @return
	 */
	@Override
	public String toString() {
		String line = "";
		
		for(int i = frontIndex; i < backIndex; i++)
		{
			if (i < queue.length)
				line += queue[i];
			else
				i = (i+1)%queue.length;
		}
			
		
		return line;
	}
	
	/**
	 * toString 
	 * @return elements separated with delimiter
	 */
	@Override
	public String toString(String delimiter) {
		String line = "";
		
		for(int i = frontIndex; i < backIndex; i++)
		{
			if (i < queue.length)
			{
				line += queue[i];
				if (i < backIndex-1)
					line += delimiter;
			}
			else
				i = (i+1)%queue.length;
		}
		
		return line;
	}


	 /**
	  * Adds to the queue with the elements in the ArrayList
	  * @param
	  * @throws QueueOverflowException 
	  */
	@SuppressWarnings("rawtypes")
	public void fill(ArrayList list) {
		ArrayList tempList = list;
		
		for (int i = 0; i < tempList.size(); i++) {
			try {
				enqueue(tempList.get(i));
			} catch (QueueOverflowException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}