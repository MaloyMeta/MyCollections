import java.util.NoSuchElementException;

public class MyStack {
    private Object[] elements;
    private int size;

    public MyStack() {
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

    public void remove(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Невірний індекс!" + " Розмір: " + size + "Індекс: " + index);
        }
        System.arraycopy(elements,index+1,elements,index,size - index - 1);
        elements[--size] = null;
    }

    public void push(Object value) {
        ensureCapacity();
        elements[size++] = value;
    }

    public int size() {
        return size;
    }

    public void clear() {
        elements = new Object[10];
        this.size = 0;
    }

    public Object peek() {
        if (size == 0) {
            throw new NoSuchElementException("Черга порожня");
        }
        return elements[size - 1];
    }

    public Object pop() {
        if (size == 0) {
            throw new NoSuchElementException("Черга порожня");
        }
        Object top = elements[--size];
        elements[size] = null;
        return top;
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push("Слава");
        stack.push("Україні");
        stack.push("Героям");
        stack.push("Слава");

        System.out.println("Розмір: " + stack.size());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Розмір: " + stack.size());
        System.out.println("----------------------------------------------------");
        System.out.println("Pop: " + stack.pop());
        System.out.println("Розмір після витягання " + stack.size());
        System.out.println("----------------------------------------------------");
        stack.remove(0); // Видаляємо "first"
        System.out.println("Розмір після видалення: " + stack.size()); // 1
        System.out.println("----------------------------------------------------");
        stack.clear();
        System.out.println("Розмір після очищення " + stack.size());

    }
}
