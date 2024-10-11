package no.itfakultetet.demo.model;

public class Datamaskin {
    private Integer årsmodell;
    private String merke;
    private Integer pris;

    public Datamaskin() {
    }

    public Integer getÅrsmodell() {
        return årsmodell;
    }

    public void setÅrsmodell(Integer årsmodell) {
        this.årsmodell = årsmodell;
    }

    public String getMerke() {
        return merke;
    }

    public void setMerke(String merke) {
        this.merke = merke;
    }

    public Integer getPris() {
        return pris;
    }

    public void setPris(Integer pris) {
        this.pris = pris;
    }

    @Override
    public String toString() {
        return "Datamaskin{" +
                "årsmodell=" + årsmodell +
                ", merke='" + merke + '\'' +
                ", pris=" + pris +
                '}';
    }
}
