package no.itfakultetet.demo;

import no.itfakultetet.demo.model.Desktop;
import no.itfakultetet.demo.model.Laptop;
import no.itfakultetet.demo.model.Server;
import no.itfakultetet.demo.view.Rapport;

import java.sql.SQLException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws SQLException {

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
                    Laptop.lagNyLaptop();
                }
                case "2" -> {
                    Desktop.lagNyDesktop();
                }
                case "3" -> {
                    Server.lagNyServer();
                }
                case "4" -> {
                    Rapport rapport = new Rapport();
                    rapport.lagRapport();
                }
                default -> System.out.println("Ukjent menyvalg...");
            }


        }


    }

}
