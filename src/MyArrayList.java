import java.util.Arrays;
import java.util.Objects;

public class MyArrayList {
    private Object[] elements;
    private int size;

    public MyArrayList(){
        elements = new Object[10];
        size = 0;
    }

    public void increaseArray(){
        if (size == elements.length){
            elements = Arrays.copyOf(elements,elements.length * 2);
        }
    }

    public void checkIndex(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Індекс: " + index + ", виходить за межі");
        }
    }

    public void add(Object value){
        increaseArray();
        elements[size] = value;
        size++;
    }
    public void remove(int index){
        checkIndex(index);
        System.arraycopy(elements,index + 1,elements, index,size - index - 1);
        elements[--size] = null;
    }
    public void clear(){
        Arrays.fill(elements,0,size,null);
        size = 0;
    }
    public int size(){
        return size;
    }
    public Object get(int index){
        checkIndex(index);
        return elements[index];
    }
}

