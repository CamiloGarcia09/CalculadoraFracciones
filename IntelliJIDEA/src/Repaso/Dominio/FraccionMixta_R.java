package Repaso.Dominio;

public class FraccionMixta_R extends Fraccion_R {

    private int parteEntera;

    public FraccionMixta_R(int numerador, int denomidador, int parteEntera) {
        super(numerador, denomidador);
        this.parteEntera=parteEntera;

    }

    @Override
    public String toString() {

        return "(" + parteEntera + ")"
                + getNumerador() + "/" + getDenominador();
    }

    public int getParteEntera() {
        return parteEntera;
    }

    public void setParteEntera(int parteEntera) {
        this.parteEntera = parteEntera;
    }
}
