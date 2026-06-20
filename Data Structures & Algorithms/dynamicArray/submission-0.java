class DynamicArray {

    private Integer[] arr;
    private int capacity;
    private int length;
    
    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.arr = new Integer[capacity];
        this.length = 0;
        Arrays.fill(this.arr, null);
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        arr[i] = n;
    }

    public void pushback(int n) {
        if (capacity == length) {
            resize();
        }
        arr[length] = n;
        length++;
    }

    public int popback() {
        if (length > 0) {
            length--;
        }
        return arr[length];
    }

    private void resize() {
        capacity = capacity * 2;
        Integer[] newArr = new Integer[capacity];
        for (int i = 0; i <= length - 1; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public int getSize() {
        return length;
    }

    public int getCapacity() {
        return capacity;
    }
}
