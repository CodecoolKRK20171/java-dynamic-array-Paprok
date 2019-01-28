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

    }

    public void remove(int index) throws ArrayIndexOutOfBoundsException {

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
