public class MyHashMap {
    private static class Node {
        final Object key;
        Object value;
        Node next;

        Node(Object key, Object value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Node[] buckets;
    private int size;

    public MyHashMap() {
        buckets = new Node[16];
        size = 0;
    }

    private int getBucketIndex(Object key) {
        return (key.hashCode() & 0x7FFFFFFF) % buckets.length;
    }

    public void put(Object key, Object value) {
        int index = getBucketIndex(key);
        Node current = buckets[index];
        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }
        buckets[index] = new Node(key, value, buckets[index]);
        size++;
    }


    public void remove(Object key) {
        int index = getBucketIndex(key);
        Node current = buckets[index];
        Node prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    buckets[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }


    public void clear() {
        buckets = new Node[16];
        size = 0;
    }


    public int size() {
        return size;
    }


    public Object get(Object key) {
        int index = getBucketIndex(key);
        Node current = buckets[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }




    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        System.out.println("Розмір: " + map.size());
        System.out.println("Отримати ключ 2: " + map.get("key2"));
        System.out.println("----------------------------------------------------");
        map.remove("key2");
        System.out.println("Розмір після видалення: " + map.size());
        System.out.println("Ключ 2 після видалення: " + map.get("key2"));
        System.out.println("----------------------------------------------------");
        map.clear();
        System.out.println("Розмір після очищення: " + map.size());
    }
}
