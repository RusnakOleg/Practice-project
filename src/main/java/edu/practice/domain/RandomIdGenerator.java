package edu.practice.domain;

import java.util.Random;
public class RandomIdGenerator {
    public static int generateRandomId() {
        Random random = new Random();
        return random.nextInt(10000,100000);
    }
}
