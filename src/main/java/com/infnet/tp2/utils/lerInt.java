package com.infnet.tp2.utils;

import java.util.Scanner;

public class lerInt {
    public static int lerInt(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido, tente novamente");
            }
        }
    }
}
