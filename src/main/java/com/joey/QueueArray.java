package com.joey;

public class QueueArray<T> {
    private T[] array;
    private int queueEnd;
    private int queueSize;
    private int queueStart;


    @SuppressWarnings("unchecked")
    public QueueArray(int size) {
        this.array = (T[]) new Object[size];
        this.queueStart = -1;
        this.queueSize = 0;
        this.queueEnd = -1;
        System.out.println("The queue was successfully created with a size of: " + size);
    }


    public boolean isFull(){
        return array.length == queueSize;
    }


    public boolean isEmpty (){
        return (queueSize == 0);
    }


    public  void enQueue(T element){
        if (isFull()){
            System.out.println("The Queue is full");
        } else if (isEmpty()){
            queueStart = 0;
            queueEnd++;
            array[queueEnd] = element;
            queueSize++;
        } else {
            queueEnd++;
            queueSize++;
            array[queueEnd] = element;
        }
    }


    public T peek(){
        if (!isEmpty()){
            return array[queueStart];
        } else {
            return null;
        }
    }


    public T deQueue(){
        if (isEmpty()){
            System.out.println("The Queue is Empty.");
            return null;
        } else {
            T result = array[queueStart];
            queueStart++;

            if (queueStart > queueEnd) {
                queueStart = queueEnd = -1;
            }

            queueSize--;
            return result;
        }
    }


    public void deleteQueue(){
        array = null;
        System.out.println("The Queue was successfully deleted.");
    }
}