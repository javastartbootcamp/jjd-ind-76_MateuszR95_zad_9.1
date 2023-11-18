package pl.javastart.task;

public class PodatekWgSkali extends FormaOpodatkowania {

    private static final double KWOTA_WOLNA_OD_PODATKU = 10_000;
    private static final double KWOTA_PIERWSZEGO_PROGU = 100_000;
    private static final double OPODATKOWANIE_PIERWSZY_PROG = 0.18;
    private static final double OPODATKOWANIE_DRUGI_PROG = 0.32;

    @Override
    public double wyliczPodatek(double przychody, double wydatki) {
        double dochod = przychody - wydatki;

        if (dochod >= KWOTA_WOLNA_OD_PODATKU && dochod < KWOTA_PIERWSZEGO_PROGU) {
            double kwotaDoOpatkowania = dochod - KWOTA_WOLNA_OD_PODATKU;
            return kwotaDoOpatkowania * OPODATKOWANIE_PIERWSZY_PROG;
        } else if (dochod >= KWOTA_PIERWSZEGO_PROGU) {
            double podatekPierwszyProg = (KWOTA_PIERWSZEGO_PROGU - KWOTA_WOLNA_OD_PODATKU) * OPODATKOWANIE_PIERWSZY_PROG;
            double podatekDrugiProg = (dochod - KWOTA_PIERWSZEGO_PROGU) * OPODATKOWANIE_DRUGI_PROG;
            return podatekPierwszyProg + podatekDrugiProg;
        } else {
            return 0;
        }
    }

    @Override
    public String getName() {
        return "Podatek wg skali podatkowej";
    }
}
