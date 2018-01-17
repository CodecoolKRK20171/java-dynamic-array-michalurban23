package com.codecool.dynamicArrayDojo;

public class DynamicIntArray {

    private int[] array;

    public DynamicIntArray() {

        this.array = new int[0];
    }

    public DynamicIntArray(int size) {

        this.array = new int[size];
    }

    public void add(int value) {

        int[] newArray = new int[array.length + 1];

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[array.length] = value;

        this.array = newArray;
    }

    public void insert(int index, int value) {

        if (index >= array.length) {
            add(value);
        } else {
            insertValue(index, value);
        }
    }

    public void remove(int index) {

        int[] newArray = new int[array.length - 1];

        copySubArray(newArray, index);

        for (int i = index; i < newArray.length; i++) {
            newArray[i] = array[i+1];
        }

        this.array = newArray;
    }

    private void insertValue(int index, int value) {

        int[] newArray = new int[array.length + 1];

        copySubArray(newArray, index);
        newArray[index] = value;

        for (int i = index; i < array.length; i++) {
            newArray[i+1] = array[i];
        }
        this.array = newArray;
    }

    private void copySubArray(int[] newArray, int index) {

        for (int i = 0; i < index; i++) {
            newArray[i] = array[i];
        }
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (int value: array) {
            sb.append(" " + value);
        }
        return sb.toString();
    }

}
