package no.itfakultetet.demo.model;

import no.itfakultetet.demo.dao.Postgres;

import java.util.Scanner;

public class Laptop extends Datamaskin{

    private int skjermstørrelse;
    private String batteritype;

    public Laptop() {
    }

    public Laptop(String merke, int modell, int pris) {

        setMerke(merke);
        setÅrsmodell(modell);
        setPris(pris);

    }


    public static void lagNyLaptop () {

        System.out.println("Ny Laptop");
        Scanner leggInn = new Scanner(System.in);
        System.out.print("Merke: ");
        String merke = leggInn.nextLine();
        System.out.print("Årsmodell: ");
        Integer modell = leggInn.nextInt();
        System.out.print("Pris: ");
        Integer pris = leggInn.nextInt();

        Datamaskin l = new Laptop(merke, modell, pris);

        System.out.println("Lagree i Database? (J/N)");
        String lagreValg = leggInn.next();
        if(lagreValg.equalsIgnoreCase("J")) {
            Postgres.insertMaskin(l);

        }

    }



}
