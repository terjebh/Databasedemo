package no.itfakultetet.demo.dao;

import no.itfakultetet.demo.model.Datamaskin;
import no.itfakultetet.demo.model.Laptop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Postgres {

    public static void insertMaskin(Datamaskin maskin) {

    String url = "jdbc:postgresql://itfakultetet.no/maskiner?user=kurs&password=kurs123&ssl=false";

        try (Connection conn = DriverManager.getConnection(url)) {

            String tabell = null;
            if (maskin instanceof Laptop) tabell = "laptop";
          //  if (maskin instanceof Desktop) tabell = "desktop";
          //  if (maskin instanceof Server) tabell = "server";

            System.out.println(tabell);

            final String INSERT_MASKIN = "INSERT INTO " + tabell +
                    "  (merke, modell, pris) VALUES " +
                    " (?, ?, ?);";
            PreparedStatement preparedStatement = conn.prepareStatement(INSERT_MASKIN);
            preparedStatement.setString(1, maskin.getMerke());
            preparedStatement.setInt(2, maskin.getÅrsmodell());
            preparedStatement.setInt(3, maskin.getPris());
            preparedStatement.executeUpdate();
            System.out.println(maskin.getMerke() + " ble lagret i databasen");
        } catch (SQLException e) {
            System.out.println("Noe gikk galt: \nFeilkode:" + e.getErrorCode() + "\nFeilmelding: " + e.getMessage());
        }

    } // Slutt på insertMaskin()


    public static List<Datamaskin> hentMaskiner(String maskinType) throws SQLException {

        List<Datamaskin> maskinliste = new ArrayList<>();
        String url = "jdbc:postgresql://itfakultetet.no/maskiner?user=kurs&password=kurs123&ssl=false";
        try (Connection conn = DriverManager.getConnection(url)) {

            final String query = "SELECT merke, modell, pris from " + maskinType + " ORDER BY merke;";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                switch (Objects.requireNonNull(maskinType)) {
                    case "Laptop" -> maskinliste.add(new Laptop(rs.getString(1), rs.getInt(2), rs.getInt(3)));
                  //  case "Desktop" -> maskinliste.add(new Desktop(rs.getString(1), rs.getInt(2), rs.getInt(3)));
                  //  case "Server" -> maskinliste.add(new Server(rs.getString(1), rs.getInt(2), rs.getInt(3)));
                }
            }

        } catch (SQLException e) {
            System.out.println("Noe gikk galt: \nFeilkode:" + e.getErrorCode() + "\nFeilmelding: " + e.getMessage());
        }

        return maskinliste;

    }


}

