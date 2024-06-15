package etapa4;

public class LinkedStack<E> implements Stack<E> {

    private Node<E> topNode;
    private int numElements;

    public LinkedStack() {
        topNode = null;
        numElements = 0;
    }

    @Override
    public boolean isEmpty() {
        return numElements == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int numElements() {
        return numElements;
    }

    @Override
    public void push(E element) throws OverflowException {
        Node<E> newNode = new Node<>(element, topNode);
        topNode = newNode;
        numElements++;
    }

    @Override
    public E pop() throws UnderflowException {
        if (isEmpty())
            throw new UnderflowException();

        E data = topNode.getData();
        topNode = topNode.getNext();
        numElements--;
        return data;
    }

    @Override
    public E top() throws UnderflowException {
        if (isEmpty())
            throw new UnderflowException();

        return topNode.getData();
    }
}
