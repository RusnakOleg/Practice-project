package edu.practice.domain;

import java.util.Random;
public class RandomIdGenerator {
    public static String generateRandomId() {
        Random random = new Random();
        int randomNumber = random.nextInt(10000,100000);
        return String.valueOf(randomNumber);
    }
}
