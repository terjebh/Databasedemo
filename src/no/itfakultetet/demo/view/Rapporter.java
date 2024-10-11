package no.itfakultetet.demo.view;

import java.sql.SQLException;

public interface Rapporter {
    void lagRapport() throws SQLException;

    void visRapport(String maskinType) throws SQLException;

    void printRapportHeader();

    void printTabellHeader();

    void printRapportFooter();

    void lagreRapportTilFil(StringBuilder rapportText);

    void lagreRapportIDB();
}
