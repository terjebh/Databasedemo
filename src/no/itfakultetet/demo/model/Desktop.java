package no.itfakultetet.demo.model;

import no.itfakultetet.demo.dao.Postgres;

import java.util.Scanner;

/**
 * Klasse som man kan lage Desktop-objekter fra.
 *
 * @author Terje Berg-Hansen
 *
 */
public class Desktop extends Datamaskin{



    public Desktop() {
    }

    public Desktop(String merke, int modell, int pris) {

        setMerke(merke);
        setÅrsmodell(modell);
        setPris(pris);

    }


    public static void lagNyDesktop () {

        System.out.println("Ny Desktop");
        Scanner leggInn = new Scanner(System.in);
        System.out.print("Merke: ");
        String merke = leggInn.nextLine();
        System.out.print("Årsmodell: ");
        Integer modell = leggInn.nextInt();
        System.out.print("Pris: ");
        Integer pris = leggInn.nextInt();

        Datamaskin l = new Desktop(merke, modell, pris);

        System.out.println("Lagree i Database? (J/N)");
        String lagreValg = leggInn.next();
        if(lagreValg.equalsIgnoreCase("J")) {
            Postgres.insertMaskin(l);

        }

    }



}
