public class StaticList<E> implements List<E> {

    private E[] elements;
    private int numElements;

    public StaticList(int maxSize) {
        elements = (E[])new Object[maxSize];
        numElements = 0;
    }

    public int contaElementos(E el) {
        return contaElementos(el, 0);
    }

    private int contaElementos(E el, int currentIndex) {
        if (currentIndex == numElements)
            return 0;
        else
            if (elements[currentIndex].equals(el))
                return 1 + contaElementos(el, currentIndex + 1);
            else
                return contaElementos(el, currentIndex + 1);
    }

    @Override
    public int numElements() {
        return numElements;
    }

    @Override
    public boolean isEmpty() {
        return numElements == 0;
    }

    @Override
    public boolean isFull() {
        return numElements == elements.length;
    }

    @Override
    public void insert(E element, int pos) {
        if (isFull())
            throw new OverflowException();

        if (pos < 0 || pos > numElements)
            throw new IndexOutOfBoundsException();

        for (int i = numElements - 1; i >= pos; i--)
            elements[i+1] = element;

        elements[pos] = element;
        numElements++;
    }

    @Override
    public E remove(int pos) throws UnderflowException, IndexOutOfBoundsException {
        if (isEmpty())
            throw new UnderflowException();

        if (pos < 0 || pos >= numElements)
            throw new IndexOutOfBoundsException();

        E element = elements[pos];

        for (int i = pos; i < numElements - 1; i++)
            elements[i] = elements[i + 1];

        elements[numElements - 1] = null;
        numElements--;

        return element;
    }

    @Override
    public E get(int pos) {
        if (pos < 0 || pos >= numElements)
            throw new IndexOutOfBoundsException();

        return elements[pos];
    }

    @Override
    public int search(E element) {
        for (int i = 0; i < numElements; i++)
            if (element.equals(elements[i]))
                return i;

        return -1;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < numElements; i++)
            s += elements[i] + " ";
        return s;
    }
}
