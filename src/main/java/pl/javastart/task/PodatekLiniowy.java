package pl.javastart.task;

public class PodatekLiniowy extends FormaOpodatkowania {

    private static final double STAWKA_PODATKU_LINIOWEGO = 0.19;

    @Override
    public double wyliczPodatek(double przychody, double wydatki) {
        double dochod = przychody - wydatki;
        return dochod * STAWKA_PODATKU_LINIOWEGO;
    }

    @Override
    public String getName() {
        return "Podatek liniowy";
    }
}
