/*
 * Class: CMSC204  
 * Due: 06/20/2023
 * Asvidu Samarasinghe
*/
public class Notation {
	
	public Notation() {
		
	}

	/**
	 * Convert infix to postfix expression
	 * @param infix
	 * @return
	 * @throws QueueOverflowException 
	 * @throws StackUnderflowException 
	 */
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {
		
		MyQueue<Character> postFix = new MyQueue<Character>();
		MyStack<Character> stack = new MyStack<Character>();
		
		for(int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);
			
			if (Character.isDigit(c))
				try {
					postFix.enqueue(c);
				} catch (QueueOverflowException e) {
					throw new InvalidNotationFormatException();
				}
			
			else if (c == '(')
				try {
					stack.push(c);
				} catch (StackOverflowException e) {
					throw new InvalidNotationFormatException();
				}
			
			else if (c == ')') {
				try {
					while(!stack.isEmpty() && stack.top()!='(') {
						postFix.enqueue(stack.pop());
					}
					
					stack.pop();	
				} catch (StackUnderflowException | QueueOverflowException e) {
						throw new InvalidNotationFormatException();
				}
			}
			
			else if (c == '+' || c == '-') {
				try {
					if (stack.top() == '+' || stack.top() == '-')
						postFix.enqueue(stack.pop());
					
					else if (stack.top() == '*' || stack.top() == '/')
					{
						postFix.enqueue(stack.pop());
						postFix.enqueue(stack.pop());
					}
					
					stack.push(c);
				} catch (StackUnderflowException | QueueOverflowException | StackOverflowException e) {
					throw new InvalidNotationFormatException(); 
				
				}
			}
			
			else if (c == '*' || c == '/' || c == '%') {
				try {
					if (stack.top() == '*' || stack.top() == '/'  || stack.top() == '%')
						postFix.enqueue(stack.pop());
					
					else if (stack.isEmpty()) 
						throw new InvalidNotationFormatException();
					
					stack.push(c);
				} catch (StackUnderflowException | QueueOverflowException | StackOverflowException e) {
					throw new InvalidNotationFormatException(); 
				}
			}
			
			else	
				throw new InvalidNotationFormatException();
		}
		
		return postFix.toString();
	}
	
	/**
	 * Convert postfix to infix expression
	 * @param postfix
	 * @return
	 */
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {

		MyStack<String> infixStack = new MyStack<String>();
		
		for(int i = 0; i < postfix.length(); i++) {
			char c = postfix.charAt(i);
			
			if(Character.isDigit(c))
				try {
					infixStack.push(c+"");
				} catch (StackOverflowException e) {
					throw new InvalidNotationFormatException();
				}
			else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '%')	
			{
				if (infixStack.size() >= 2)
				{
					String s1;
					String s2;
					
					try {
						s1 = infixStack.pop();
						s2 = infixStack.pop();
						
						String temp = "(" +s2 +c+ s1+ ")";
						infixStack.push(temp);	
						
					} catch (StackUnderflowException | StackOverflowException e) {
						throw new InvalidNotationFormatException();
					}
					
				}
				else 
					throw new InvalidNotationFormatException();
			}
			
			else 
				throw new InvalidNotationFormatException();
			
		}
		
		return infixStack.toString();
	}

	/**
	 * Evaluates a postfix expression 
	 * @param complexPostfix
	 * @return
	 * @throws StackOverflowException 
	 * @throws StackUnderflowException 
	 * @throws NumberFormatException 
	 */
	public static double evaluatePostfixExpression(String complexPostfix) throws InvalidNotationFormatException {
		MyStack<Double> postfixStack = new MyStack<Double>();
		
			for (int i = 0; i < complexPostfix.length(); i++) {
				char c = complexPostfix.charAt(i);
				
				
				if(Character.isDigit(c))
					try {
						postfixStack.push((double)c - '0');
					} catch (StackOverflowException e) {
						e.printStackTrace();
					}
				else if (c == '+' || c == '-' || c == '*' || c == '/')
				{
					if (postfixStack.size() >= 2)
					{
						double n1;
						double n2;
						
						try {
							n1 = postfixStack.pop();
							n2 = postfixStack.pop();
						
							if (c == '+')
								postfixStack.push(n1+n2);
								
							else if	(c == '-')
								postfixStack.push(n2-n1);
			
							else if	(c == '*')
								postfixStack.push(n1*n2);
									
							else if	(c == '/')
								postfixStack.push(n2/n1);
							else if (c == '%')
								postfixStack.push(n2%n1);
						
						} catch (StackUnderflowException | StackOverflowException e) {
							e.printStackTrace();
						}
					}
					
					else 
						throw new InvalidNotationFormatException();
				}
				
				else 
					throw new InvalidNotationFormatException();
			}
		
		try {
			return postfixStack.pop();
		} catch (StackUnderflowException e) {

			e.printStackTrace();
		}
		return 0;
	}

}