package com.joey;

import java.time.Instant;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AnimalShelter shelter = new AnimalShelter(10);
        boolean running = true;

        System.out.println("=== Welcome to the Animal Shelter System ===");

        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add a new Dog");
            System.out.println("2. Add a new Cat");
            System.out.println("3. Adopt oldest Animal");
            System.out.println("4. Adopt oldest Dog");
            System.out.println("5. Adopt oldest Cat");
            System.out.println("6. View all Animals in Queue");
            System.out.println("7. Exit");
            System.out.print("Select an option: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Dog's name: ");
                    String dogName = scanner.nextLine();

                    System.out.print("Enter Dog's age: ");
                    int dogAge = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Dog's breed: ");
                    String dogBreed = scanner.nextLine();

                    Dog newDog = new Dog(dogName, dogAge, Instant.now(), dogBreed);
                    shelter.enqueueAnimal(newDog);
                    System.out.println(dogName + " the Dog has been added to the shelter.");
                    break;
                case 2:
                    System.out.print("Enter Cat's name: ");
                    String catName = scanner.nextLine();

                    System.out.print("Enter Cat's age: ");
                    int catAge = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Cat's breed: ");
                    String catBreed = scanner.nextLine();

                    Cat newCat = new Cat(catName, catAge, Instant.now(), catBreed);
                    shelter.enqueueAnimal(newCat);
                    System.out.println(catName + " the Cat has been added to the shelter.");
                    break;
                case 3:
                    shelter.dequeueAny();
                    System.out.println("The oldest animal has been adopted!");
                    break;
                case 4:
                    shelter.dequeueDog();
                    System.out.println("The oldest dog has been adopted!");
                    break;
                case 5:
                    shelter.dequeueCat();
                    System.out.println("The oldest cat has been adopted!");
                    break;
                case 6:
                    System.out.println("\nCurrent Animals in Shelter:");
                    QueueArray queue = shelter.getAnimalQueue();
                    Animal[] animals = queue.getArray();

                    for (Animal animal : animals) {
                        if (animal != null) {
                            System.out.println(" - " + animal + "\n");
                        }
                    }

                    break;
                case 7:
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }

        scanner.close();
    }
}