package Repaso.Dominio;

import Repaso.Dominio.Exception.NoAmplificaException;

public class Calculadora {

    private int maximoComunDivisor(int a, int b){
        if (b==0){
            return a;
        }
        return (maximoComunDivisor(b,a%b));
    }

    public Fraccion simplificar(Fraccion fraccion){
       int comunDivisor = maximoComunDivisor(fraccion.getNumerador(), fraccion.getDenominador());
       return new Fraccion(fraccion.getNumerador()/comunDivisor,
                            fraccion.getDenominador()/comunDivisor);
    }


    public Fraccion sumar(Fraccion fraccion1, Fraccion fraccion2){

        int resultadoNumerador = (fraccion1.getDenominador()*fraccion2.getNumerador())
                                    + (fraccion1.getNumerador()*fraccion2.getDenominador());
        int resultadoDenominador = (fraccion1.getDenominador()*fraccion2.getDenominador());

        return simplificar(new Fraccion(resultadoNumerador,resultadoDenominador));
    }


    public Fraccion restar(Fraccion fraccion1, Fraccion fraccion2){

        int resultadoNumerador = (fraccion1.getDenominador()*fraccion2.getNumerador())
                                    - (fraccion1.getNumerador()*fraccion2.getDenominador());
        int resultadoDenominador = (fraccion1.getDenominador()*fraccion2.getDenominador());

        return simplificar(new Fraccion(resultadoNumerador,resultadoDenominador));
    }


    public Fraccion multiplicar(Fraccion fraccion1, Fraccion fraccion2){

        int resultadoNumerador = (fraccion1.getNumerador()*fraccion2.getNumerador());
        int resultadoDenominador = (fraccion1.getDenominador()*fraccion2.getDenominador());

        return simplificar(new Fraccion(resultadoNumerador, resultadoDenominador));
    }


    public Fraccion dividir(Fraccion fraccion1, Fraccion fraccion2){

        int resultadoNumerador = (fraccion1.getNumerador()*fraccion2.getDenominador());
        int resultadoDenominador = (fraccion1.getDenominador()*fraccion2.getNumerador());

        return simplificar(new Fraccion(resultadoNumerador, resultadoDenominador));
    }


    public Fraccion amplificar(double numeroAmplificador, Fraccion fracccion){

        double resultadoNumerador = fracccion.getNumerador();
        double resultadoDenominador = fracccion.getDenominador();

        if (numeroAmplificador > 1 || numeroAmplificador < -1){
            resultadoNumerador =  (fracccion.getNumerador()*numeroAmplificador);
            resultadoDenominador =  (fracccion.getDenominador()*numeroAmplificador);
        }
        else throw new NoAmplificaException();

        return new Fraccion ((int) resultadoNumerador, (int) resultadoDenominador);
    }


    public Fraccion convertirMixtoAFraccion (FraccionMixta fraccionMixto){

        int resultadoNumerador = (fraccionMixto.getParteEntera()*fraccionMixto.getDenominador()) +  fraccionMixto.getNumerador();
        int resultadoDenominador = fraccionMixto.getDenominador();

        return new Fraccion(resultadoNumerador, resultadoDenominador);
    }


    public FraccionMixta convertirFraccionAMixto (Fraccion fraccion){
        if (fraccion.verificarPropiaOImpropia(fraccion)){
            return new FraccionMixta(fraccion.getNumerador(), fraccion.getDenominador(), 0);
        }
        int parteEntera = fraccion.getNumerador()/fraccion.getDenominador();
        int nuevoNumerador = fraccion.getNumerador() % fraccion.getDenominador();

        return new FraccionMixta(nuevoNumerador,fraccion.getDenominador(),parteEntera);

    }

}
