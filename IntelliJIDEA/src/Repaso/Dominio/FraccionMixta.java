package Repaso.Dominio;

public class FraccionMixta extends Fraccion {

    private int parteEntera;

    public FraccionMixta(int numerador, int denomidador, int parteEntera) {
        super(numerador, denomidador);
        this.parteEntera=parteEntera;

    }

    @Override
    public String toString() {

        return "(" + parteEntera + ")"
                + getNumerador() + "/" + getDenominador();
    }

}
