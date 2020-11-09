package Lesson4;

public class TwoSideLinkedListImpl<E> extends SimpleLinkedListImpl<E> implements TwoSideLinkedList<E> {

    private Node<E> lastElement;



    @Override
    public void insertFirst(E value) {
        super.insertFirst(value);
        if (size == 1) {
            lastElement = firstElement;
        }
    }

    @Override
    public E removeFirst() {
        E removedData = super.removeFirst();
        if (isEmpty()) {
            lastElement = null;
        }
        return removedData;
    }

    @Override
    public boolean remove(E value) {
        Node<E> previous = null;
        Node<E> current = firstElement;
        while (current != null) {
            if(current.item.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        if(size()==1){
            return removeFirst() !=null;
        }

        if (current == firstElement && current == lastElement) {
            firstElement = lastElement = null;
        } else if (current == firstElement) {
            firstElement = current.next;
        } else if (current == lastElement) {
            lastElement = previous;
            previous.next = null;
        } else {
            previous.next = current.next;
        }

        size--;
        return true;
    }


        @Override
    public void insertLast(E value) {
        Node<E> entry = new Node<>(value,null);

        if (isEmpty()) {
            firstElement = entry;
        } else {
            lastElement.next = entry;
        }

        lastElement = entry;
        size++;
    }
}
