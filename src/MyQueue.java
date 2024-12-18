import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyQueue {
    private Object[] elements;
    private int size;

    public MyQueue(){
        elements = new Object[3];
        this.size = 0;
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            Object[] newElements = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
    }

    public void add(Object value){
        ensureCapacity();
        elements[size++] = value;
    }

    public int size(){
        return size;
    }

    public void clear(){
        elements = new Object[10];
        this.size = 0;
    }

    public Object peek(){
        if (size == 0){
            throw new NoSuchElementException("Черга порожня");
        }
        return elements[0];
    }
    public Object poll(){
        if (size == 0){
            throw new NoSuchElementException("Черга порожня");
        }
        Object first = elements[0];
        System.arraycopy(elements,1,elements,0,--size);
        elements[size] = null;
        return first;
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.add("Слава");
        queue.add("Україні");

        System.out.println("Розмір: " + queue.size());
        System.out.println("Peek: " + queue.peek());
        System.out.println("Розмір: " + queue.size());
        System.out.println("----------------------------------------------------");
        System.out.println("Poll: " + queue.poll());
        System.out.println("Розмір після витягання " + queue.size());
        System.out.println("----------------------------------------------------");
        queue.clear();
        System.out.println("Розмір після очищення " + queue.size());

    }

}
