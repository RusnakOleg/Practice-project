package edu.practice.presentation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner command = new Scanner(System.in);
        System.out.println("Enter command: ");
        label:
        while (true) {
            switch (command.nextLine()) {
                case "exit":
                    System.out.println("Application was сlosed");
                    break label;
                default:
                    System.out.println("Command not recognized!");
                    break;
            }
        }
    }
}