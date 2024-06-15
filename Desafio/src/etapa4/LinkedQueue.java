package etapa4;

public class LinkedQueue<E> implements Queue<E> {

    private Node<E> frontNode;
    private Node<E> backNode;
    private int numElements;

    public LinkedQueue() {
        frontNode = null;
        backNode = null;
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
    public void enqueue(E element) throws OverflowException {
        Node<E> newNode = new Node<>(element);
        if (isEmpty()) {
            frontNode = newNode;
            backNode = newNode;
        } else {
            backNode.setNext(newNode);
            backNode = newNode;
        }
        numElements++;
    }

    @Override
    public E dequeue() throws UnderflowException {
        if (isEmpty())
            throw new UnderflowException();

        E data = frontNode.getData();
        frontNode = frontNode.getNext();
        numElements--;
        if (frontNode == null)
            backNode = null;

        return data;
    }

    @Override
    public E front() throws UnderflowException {
        if (isEmpty())
            throw new UnderflowException();

        return frontNode.getData();
    }

    @Override
    public E back() throws UnderflowException {
        if (isEmpty())
            throw new UnderflowException();

        return backNode.getData();
    }
}
