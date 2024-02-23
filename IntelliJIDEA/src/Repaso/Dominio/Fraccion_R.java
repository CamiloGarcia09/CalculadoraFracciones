package Repaso.Dominio;
import Repaso.Dominio.Exception.FraccionInexistenteException;

public class Fraccion_R {

    private int numerador;
    private int denominador;

    public Fraccion_R(int numerador, int denomidador){

        if(denomidador!=0){
            this.denominador= denomidador;
            this.numerador = numerador;
        }
        else throw new FraccionInexistenteException();

    }


    public boolean verificarPropiaOImpropia(Fraccion_R fraccionR){
        if (fraccionR.numerador< fraccionR.denominador){
            System.out.println("Es propia");
            return true;
        }
        else if(fraccionR.numerador> fraccionR.denominador){
            System.out.println("Es impropia");
            return false;
        }
        return false;
    }


    public int getNumerador() {
        return numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }

    @Override
    public String toString() {
        return numerador + "/" + denominador;
    }
}
