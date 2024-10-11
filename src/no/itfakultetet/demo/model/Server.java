package no.itfakultetet.demo.model;

import no.itfakultetet.demo.dao.Postgres;

import java.util.Scanner;
/**
 * Klasse som man kan lage Server-objekter fra.
 *
 * @author Terje Berg-Hansen
 *
 */
public class Server extends Datamaskin{


    public Server() {
    }

    public Server(String merke, int modell, int pris) {

        setMerke(merke);
        setÅrsmodell(modell);
        setPris(pris);

    }


    public static void lagNyServer () {

        System.out.println("Ny Server");
        Scanner leggInn = new Scanner(System.in);
        System.out.print("Merke: ");
        String merke = leggInn.nextLine();
        System.out.print("Årsmodell: ");
        Integer modell = leggInn.nextInt();
        System.out.print("Pris: ");
        Integer pris = leggInn.nextInt();

        Datamaskin l = new Server(merke, modell, pris);

        System.out.println("Lagree i Database? (J/N)");
        String lagreValg = leggInn.next();
        if(lagreValg.equalsIgnoreCase("J")) {
            Postgres.insertMaskin(l);

        }

    }



}
