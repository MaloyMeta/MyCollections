public class MyLinkedList {
    private Node head;
    private Node tail;
    private int size;


    private static class Node {
        Object value;
        Node next;
        Node prev;

        Node(Object value) {
            this.value = value;
        }
    }
    public Object get(int index) {
        checkIndex(index);
        return getNode(index).value;
    }

    private Node getNode(int index) {
        Node current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    public void checkIndex(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Індекс: " + index + ", виходить за межі");
        }
    }

    public void add(Object value) {
        Node newNode = new Node(value);
        if (size == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }


    public void remove(int index) {
        checkIndex(index);

        Node toRemove = getNode(index);

        if (toRemove.prev != null) {
            toRemove.prev.next = toRemove.next;
        } else {
            head = toRemove.next;
        }

        if (toRemove.next != null) {
            toRemove.next.prev = toRemove.prev;
        } else {
            tail = toRemove.prev;
        }

        size--;
    }


    public void clear() {
        head = tail = null;
        size = 0;
    }


    public int size() {
        return size;
    }

}
