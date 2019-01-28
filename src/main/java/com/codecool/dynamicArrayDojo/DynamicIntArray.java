package com.codecool.dynamicArrayDojo;

// put your code here!
public class DynamicIntArray {
    private int[] array;
    private int index;
    private int size;

    public DynamicIntArray() {
        this.size = 16;
        this.array = new int[size];
        this.index = 0;
    }

    public DynamicIntArray(int size) {
        this.size = 16;
        this.array = new int[size];
        this.index = 0;
    }

    public void add(int item) {
        if (index + 1 < size) {
            append(item);
        } else {
            doubleSize();
            append(item);
        }
    }

    private void append(int item) {
        this.array[index] = item;
        this.index++;
    }

    private void doubleSize() {
        int[] temp = this.array.clone();
        this.size *= 2;
        this.array = new int[size];
        save(temp);
    }

    private void save(int[] temp) {
        for (index = 0; index < temp.length; index++) {
            this.array[index] = temp[index];
        }
    }

    public void insert(int insertId, int item) {
        if (insertId < index) {
            int end = ++index;
            moveItems(array, item, insertId, end);
        } else {
            add(item);
        }
    }

    private int[] moveItems(int[] arr, int item, int start, int end) {
        if (start < end) {
            int temp = arr[start];
            arr[start] = item;
            return moveItems(arr, temp, ++start, end);
        } else {
            return arr;
        }
    }

    public void remove(int removeIndex) throws ArrayIndexOutOfBoundsException {
        int lastIndex = index - 1;
        if (isOutOfBounds(removeIndex, lastIndex)) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            moveItems(this.array, removeIndex, lastIndex);
            this.index = lastIndex;
        }
    }

    private int[] moveItems(int[] arr, int start, int end) {
        if (start < end) {
            arr[start] = arr[++start];
            return moveItems(arr, start, end);
        } else {
            return arr;
        }
    }


    private boolean isOutOfBounds(int removeIndex, int lastIndex) {
        return removeIndex < 0 || removeIndex > lastIndex;
    }

    public String toString() {
        StringBuilder toReturn = new StringBuilder(" ");
        int end = index - 1;
        int i;
        for (i = 0; i < end; i++) {
            toReturn.append(array[i]);
            toReturn.append(' ');
        }
        toReturn.append(array[i]);
        return toReturn.toString();
    }
}
