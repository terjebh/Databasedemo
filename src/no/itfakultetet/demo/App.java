package no.itfakultetet.demo;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while(true) {
            System.out.println("1 = Legg til ny Laptop");
            System.out.println("2 = Legg til ny Desktop");
            System.out.println("3 = Legg til ny Server");
            System.out.println("4 = Vis alle maskiner");
            System.out.println("q = Avslutt programmet");

            String menyvalg = in.next();

            switch (menyvalg) {
                case "q" -> {
                    System.out.println("Farvel...");
                    System.exit(0);
                }
                case "1" -> {

                }
                case "2" -> {
                }
                case "3" -> {
                    //TODO lag rutine for å sette inn ny server
                }
                case "4" -> {
                }
                default -> System.out.println("Ukjent menyvalg...");
            }


        }


    }

}
