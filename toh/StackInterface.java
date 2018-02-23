package toh;

/**
 * The StackInterface holds the methods to be implemented
 * by the LinkedStack
 *
 * @author Sanskar Thapa <tsanskar>
 * @version 03.11.2017
 * 
 * @param <T> holds the type of object the client decides
 *          to use.
 */
public interface StackInterface<T>
{
    /**
     * pushes the entry to the stack
     * @param anEntry holds the entry to be pushed
     */
    public void push(T anEntry);
    
    /**
     * pulls entry out of the top of the stack
     * @return the pulled entry
     */
    public T pop();
    
    /**
     * peek gets the data from the stack top without
     * removing it.
     * @return returns the top element in the stack
     */
    public T peek();
    
    /**
     * checks if the stack is empty or not
     * @return returns decision if the stack is empty or not.
     */
    public boolean isEmpty();
    
    /**
     * clears the value stored in the stack
     */
    public void clear();
    
}
