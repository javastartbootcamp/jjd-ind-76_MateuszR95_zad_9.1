package pl.javastart.task;

public class Przychod {

    private String nazwa;
    private double wartosc;

    public Przychod(String nazwa, double wartosc) {
        this.wartosc = wartosc;
        this.nazwa = nazwa;
    }

    public double getWartosc() {
        return wartosc;
    }

    public void setWartosc(double wartosc) {
        this.wartosc = wartosc;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}
