package com.joey;

public class QueueArray {
    private Animal[] array;
    private int queueEnd;
    private int queueSize;
    private int queueStart;


    public QueueArray(int size) {
        this.array = new Animal[size];
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


    public  void enqueue(Animal element){
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


    public Animal peek(){
        if (!isEmpty()){
            return array[queueStart];
        } else {
            return null;
        }
    }


    public Animal dequeue(){
        if (isEmpty()){
            System.out.println("The Queue is Empty.");
            return null;
        } else {
            Animal result = array[queueStart];
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


    public Animal[] getArray() {
        return this.array;
    }

    public int getQueueEnd() {
        return this.queueEnd;
    }

    public int getQueueSize() {
        return this.queueSize;
    }

    public int getQueueStart() {
        return this.queueStart;
    }


    public void setArray(Animal[] array) {
        this.array = array;
    }

    public void setQueueEnd(int queueEnd) {
        this.queueEnd = queueEnd;
    }

    public void setQueueSize(int queueSize) {
        this.queueSize = queueSize;
    }

    public void setQueueStart(int queueStart) {
        this.queueStart = queueStart;
    }
}