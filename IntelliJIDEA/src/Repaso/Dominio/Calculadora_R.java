package Repaso.Dominio;
import Repaso.Dominio.Exception.NoAmplificaException;

public class Calculadora_R {

    private int maximoComunDivisor(int a, int b){
        if (b==0){
            return a;
        }
        return (maximoComunDivisor(b,a%b));
    }

    public Fraccion_R simplificar(Fraccion_R fraccionR){
       int comunDivisor = maximoComunDivisor(fraccionR.getNumerador(), fraccionR.getDenominador());
       return new Fraccion_R(fraccionR.getNumerador()/comunDivisor,
                            fraccionR.getDenominador()/comunDivisor);
    }


    public Fraccion_R sumar(Fraccion_R fraccionR1, Fraccion_R fraccionR2){

        int resultadoNumerador = (fraccionR1.getDenominador()* fraccionR2.getNumerador())
                                    + (fraccionR1.getNumerador()* fraccionR2.getDenominador());
        int resultadoDenominador = (fraccionR1.getDenominador()* fraccionR2.getDenominador());

        return simplificar(new Fraccion_R(resultadoNumerador,resultadoDenominador));
    }


    public Fraccion_R restar(Fraccion_R fraccionR1, Fraccion_R fraccionR2){

        int resultadoNumerador = (fraccionR1.getDenominador()* fraccionR2.getNumerador())
                                    - (fraccionR1.getNumerador()* fraccionR2.getDenominador());
        int resultadoDenominador = (fraccionR1.getDenominador()* fraccionR2.getDenominador());

        return simplificar(new Fraccion_R(resultadoNumerador,resultadoDenominador));
    }


    public Fraccion_R multiplicar(Fraccion_R fraccionR1, Fraccion_R fraccionR2){

        int resultadoNumerador = (fraccionR1.getNumerador()* fraccionR2.getNumerador());
        int resultadoDenominador = (fraccionR1.getDenominador()* fraccionR2.getDenominador());

        return simplificar(new Fraccion_R(resultadoNumerador, resultadoDenominador));
    }


    public Fraccion_R dividir(Fraccion_R fraccionR1, Fraccion_R fraccionR2){

        int resultadoNumerador = (fraccionR1.getNumerador()* fraccionR2.getDenominador());
        int resultadoDenominador = (fraccionR1.getDenominador()* fraccionR2.getNumerador());

        return simplificar(new Fraccion_R(resultadoNumerador, resultadoDenominador));
    }


    public Fraccion_R amplificar(double numeroAmplificador, Fraccion_R fracccion){

        double resultadoNumerador = fracccion.getNumerador();
        double resultadoDenominador = fracccion.getDenominador();

        if (numeroAmplificador > 1 || numeroAmplificador < -1){
            resultadoNumerador =  (fracccion.getNumerador()*numeroAmplificador);
            resultadoDenominador =  (fracccion.getDenominador()*numeroAmplificador);
        }
        else throw new NoAmplificaException();

        return new Fraccion_R((int) resultadoNumerador, (int) resultadoDenominador);
    }


    public Fraccion_R convertirMixtoAFraccion (FraccionMixta_R fraccionMixto){

        int resultadoNumerador = (fraccionMixto.getParteEntera()*fraccionMixto.getDenominador()) +  fraccionMixto.getNumerador();
        int resultadoDenominador = fraccionMixto.getDenominador();

        return new Fraccion_R(resultadoNumerador, resultadoDenominador);
    }


    public FraccionMixta_R convertirFraccionAMixto (Fraccion_R fraccionR){
        if (fraccionR.verificarPropiaOImpropia(fraccionR)){
            return new FraccionMixta_R(fraccionR.getNumerador(), fraccionR.getDenominador(), 0);
        }
        int parteEntera = fraccionR.getNumerador()/ fraccionR.getDenominador();
        int nuevoNumerador = fraccionR.getNumerador() % fraccionR.getDenominador();

        return new FraccionMixta_R(nuevoNumerador, fraccionR.getDenominador(),parteEntera);

    }

}
