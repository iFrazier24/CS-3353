// Isis Frazier
// ArrayQueue 

import java.io.IOException;
import java.util.*;

public class ArrayQueue<E> implements Queue<E> {

    private static int CAPACITY = 80; // default capacity based on instructions
    // private static int front;
    // private static int rear;
    // At 10, increase the size and give the user a choice of either tight stratedy
    // or growth strategy.
    // At array size 80, return an overflow exeption when adding a new customer

    // These variables may need to be adjusted

    public E[] data; // generic array used for storage
    public int frontIndex; // index of the front element
    public int rearIndex;
    public int numElements; // number of elements in the queue

    private static final int DEFAULT_CAPACITY = 10;
    private int cap;
    private int current;
    private int front;
    private int rear;

    public ArrayQueue() {
        cap = DEFAULT_CAPACITY;
        data = data = (E[]) new Object[DEFAULT_CAPACITY];
        frontIndex = 0;
        rearIndex = 0;
    }

    @Override
    public int size() {

        return numElements;
    }

    @Override
    public boolean isEmpty() {
        return (numElements == 0);

    }

    @Override
    public boolean isFull() {

        return (numElements == data.length);
    }

    @Override
    public void enqueue(E e) throws IllegalStateException {

        if (numElements == CAPACITY)
            throw new IllegalStateException("Queue is Full");
        int avail = (frontIndex + numElements) % data.length;
        data[avail] = e;
        numElements++;

    }

    @Override
    public E dequeue() {

        if (isEmpty())
            return null;
        E answer = data[frontIndex];
        data[frontIndex] = null;
        frontIndex = (frontIndex + 1) % data.length;
        numElements--;
        return answer;
    }

    @Override
    public E first() {
        if (isEmpty())
            return null;
        return data[frontIndex];
    }

    public void initialize() {
        for (int i = 0; i < numElements; i++)
            data[i] = null;
        numElements = 0;
        frontIndex = 0;
        rearIndex = -1;

    }

    public void first2() throws IOException
    {
        Customer customer = new Customer();
      //  customer.printCustomerInfo();
        String line1 = customer.readFile();
       // System.out.println(line1);
        
    }

    
    public void print()
    {
    
        for (int i = 0; i < data.length; i++)
        {
            System.out.print(data[i] + " ");
        }
    }
    
}

// Efficiency...
// size = O(1)
// isEmpty = O(1)
// first = O(1)
// enqueue = O(1)
// dequeue = O(1)