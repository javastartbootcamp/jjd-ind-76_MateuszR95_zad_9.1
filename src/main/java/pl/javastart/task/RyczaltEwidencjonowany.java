package pl.javastart.task;

public class RyczaltEwidencjonowany extends FormaOpodatkowania {

    private static final double KWOTA_RYCZALTU = 0.15;

    @Override
    public double wyliczPodatek(double przychody, double wydatki) {
        return przychody * KWOTA_RYCZALTU;
    }

    @Override
    public String getName() {
        return "Rycztał od dochodów ewidencjonowanych";
    }
}
