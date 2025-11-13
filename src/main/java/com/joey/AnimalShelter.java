package com.joey;

import java.time.Instant;

public class AnimalShelter {
    private QueueArray animalQueue;


    public AnimalShelter(int queueSize) {
        this.animalQueue = new QueueArray(queueSize);
    }


    public <T extends Animal> void dequeueBySubClass(Class<T> subClassOfAnimal) {
        if (animalQueue.isEmpty()) {
            return;
        }
        QueueArray temporaryQueue = new QueueArray(animalQueue.getQueueSize());
        Animal found = null;


        while (!animalQueue.isEmpty()) {
            Animal current = animalQueue.dequeue();

            if (found == null && subClassOfAnimal.isInstance(current)) {
                found = current;
            } else {
                temporaryQueue.enqueue(current);
            }
        }

        while (!temporaryQueue.isEmpty()) {
            animalQueue.enqueue(temporaryQueue.dequeue());
        }

    }


    public void enqueueAnimal(Animal animal) {
        animal.setTimestampReceived(Instant.now());
        animalQueue.enqueue(animal);
    }

    public void dequeueAny() {
        animalQueue.dequeue();
    }

    public void dequeueCat() {
        dequeueBySubClass(Cat.class);
    }

    public void dequeueDog() {
        dequeueBySubClass(Dog.class);
    }


    public QueueArray getAnimalQueue() {
        return this.animalQueue;
    }


    public void setAnimalQueue(QueueArray animalQueue) {
        this.animalQueue = animalQueue;
    }
}