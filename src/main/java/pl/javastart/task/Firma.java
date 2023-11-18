package pl.javastart.task;

import java.util.Arrays;

public class Firma {

    private String nazwa;
    private FormaOpodatkowania formaOpodatkowania;
    private Przychod[] przychody = new Przychod[1];
    private int licznikPrzychodow = 0;

    private Wydatek[] wydatki = new Wydatek[1];
    private int licznikWydatkow = 0;

    public Firma(String nazwa, FormaOpodatkowania formaOpodatkowania) {
        this.nazwa = nazwa;
        this.formaOpodatkowania = formaOpodatkowania;
    }

    public void wyswietlPodsumowanie() {
        double sumaPrzychodow = zsumujPrzychody();

        System.out.printf("======= Firma: %s ===========\n", nazwa);
        System.out.printf("Forma opodatkowania: %s\n", formaOpodatkowania.getName());
        System.out.printf("Suma przychodów: %.2f zł\n", sumaPrzychodow);
        System.out.printf("Suma wydatków: %.2f zł\n", zsumujWydatki());
        System.out.printf("Podatek do zapłacenia: %.2f zł", formaOpodatkowania.wyliczPodatek(sumaPrzychodow, zsumujWydatki()));
        System.out.print("\n\n");
    }

    private double zsumujWydatki() {
        double sumaWydatkow = 0;
        for (int i = 0; i < licznikWydatkow; i++) {
            sumaWydatkow += wydatki[i].getWartosc();
        }
        return sumaWydatkow;
    }

    private double zsumujPrzychody() {
        double sumaPrzychodow = 0;
        for (int i = 0; i < licznikPrzychodow; i++) {
            sumaPrzychodow += przychody[i].getWartosc();
        }
        return sumaPrzychodow;
    }

    public void dodajPrzychod(String nazwa, double wartosc) {
        zapewnijWielkoscTablicyPrzychodow();
        przychody[licznikPrzychodow] = new Przychod(nazwa, wartosc);
        licznikPrzychodow++;
    }

    private void zapewnijWielkoscTablicyPrzychodow() {
        if (licznikPrzychodow >= przychody.length) {
            przychody = Arrays.copyOf(przychody, przychody.length + 1);
        }
    }

    public void dodajWydatek(String nazwa, double wartosc) {
        zapewnijWielkoscTablicyWydatkow();
        wydatki[licznikWydatkow] = new Wydatek(nazwa, wartosc);
        licznikWydatkow++;
    }

    private void zapewnijWielkoscTablicyWydatkow() {
        if (licznikWydatkow >= wydatki.length) {
            wydatki = Arrays.copyOf(wydatki, wydatki.length + 1);
        }
    }
}
