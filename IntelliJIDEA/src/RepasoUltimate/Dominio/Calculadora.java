package RepasoUltimate.Dominio;

import RepasoUltimate.Dominio.Exception.Fraccion1NullException;
import RepasoUltimate.Dominio.Exception.Fraccion2NullException;
import RepasoUltimate.Dominio.Exception.FraccionNullException;
import RepasoUltimate.Dominio.Exception.NoAmplificaException;


public class Calculadora {


    private Calculadora(){
        super();
    }

    private static long calcularMaximoComunDivisor(long a, long b){
        if (b==0){
            return a;
        }
        return (calcularMaximoComunDivisor(b,a%b));
    }

    private static void notificarNulos (Fraccion fraccion1, Fraccion fraccion2){
        if (fraccion1 == null){
            throw new Fraccion1NullException();
        }
        if (fraccion2 == null){
            throw new Fraccion2NullException();
        }
    }





    public static Fraccion simplificar(Fraccion fraccion){
        long comunDivisor = calcularMaximoComunDivisor(fraccion.getNumerador(), fraccion.getDenominador());
        return Fraccion.crear(fraccion.getNumerador()/comunDivisor,
                fraccion.getDenominador()/comunDivisor);
    }


    public static Fraccion sumar(Fraccion fraccion1, Fraccion fraccion2){

        notificarNulos(fraccion1, fraccion2);

        long resultadoNumerador = (fraccion1.getDenominador()* fraccion2.getNumerador())
                + (fraccion1.getNumerador()* fraccion2.getDenominador());
        long resultadoDenominador = (fraccion1.getDenominador()* fraccion2.getDenominador());

        return simplificar(Fraccion.crear(resultadoNumerador,resultadoDenominador));
    }


    public static Fraccion restar(Fraccion fraccion1, Fraccion fraccion2){

        notificarNulos(fraccion1, fraccion2);

        long resultadoNumerador = (fraccion1.getDenominador()* fraccion2.getNumerador())
                - (fraccion1.getNumerador()* fraccion2.getDenominador());
        long resultadoDenominador = (fraccion1.getDenominador()* fraccion2.getDenominador());

        return simplificar(Fraccion.crear(resultadoNumerador,resultadoDenominador));
    }


    public static Fraccion multiplicar(Fraccion fraccion1, Fraccion fraccion2){

        notificarNulos(fraccion1, fraccion2);

        long resultadoNumerador = (fraccion1.getNumerador()* fraccion2.getNumerador());
        long resultadoDenominador = (fraccion1.getDenominador()* fraccion2.getDenominador());

        return simplificar(Fraccion.crear(resultadoNumerador, resultadoDenominador));
    }


    public static Fraccion dividir(Fraccion fraccion1, Fraccion fraccion2){

        notificarNulos(fraccion1, fraccion2);

        long resultadoNumerador = (fraccion1.getNumerador()* fraccion2.getDenominador());
        long resultadoDenominador = (fraccion1.getDenominador()* fraccion2.getNumerador());

        return simplificar(Fraccion.crear(resultadoNumerador, resultadoDenominador));
    }


    public static Fraccion amplificar(long numeroAmplificador, Fraccion fracccion){

        if (fracccion == null){
            throw new FraccionNullException();
        }
        long resultadoNumerador = fracccion.getNumerador();
        long resultadoDenominador = fracccion.getDenominador();

        if (numeroAmplificador > 1 || numeroAmplificador < -1){
            resultadoNumerador =  (fracccion.getNumerador() * numeroAmplificador);
            resultadoDenominador =  (fracccion.getDenominador() * numeroAmplificador);
        }
        else throw new NoAmplificaException();

        return Fraccion.crear(resultadoNumerador, resultadoDenominador);
    }


    public static Fraccion convertirMixtoAFraccion (FraccionMixta fraccionMixto){

        if (fraccionMixto == null){
            throw new FraccionNullException();
        }

        long resultadoNumerador = (fraccionMixto.getParteEntera()*fraccionMixto.getDenominador())
                +  fraccionMixto.getNumerador();
        long resultadoDenominador = fraccionMixto.getDenominador();

        return Fraccion.crear(resultadoNumerador, resultadoDenominador);
    }


    public static FraccionMixta convertirFraccionAMixto (Fraccion fraccion){

        if (fraccion == null){
            throw new FraccionNullException();
        }

        if (fraccion.verificarPropiaOImpropia(fraccion)){
            return FraccionMixta.crear(0,fraccion.getNumerador(), fraccion.getDenominador());
        }
        long parteEntera = fraccion.getNumerador()/ fraccion.getDenominador();
        long nuevoNumerador = fraccion.getNumerador() % fraccion.getDenominador();

        return FraccionMixta.crear(parteEntera, nuevoNumerador, fraccion.getDenominador());
    }


    public static FraccionMixta sumarMixto (FraccionMixta mixto1, FraccionMixta mixto2){

        Fraccion fraccion1 = convertirMixtoAFraccion(mixto1);
        Fraccion fraccion2 = convertirMixtoAFraccion(mixto2);

        Fraccion resultado = sumar(fraccion1, fraccion2);

        return convertirFraccionAMixto(resultado);
    }


    public static FraccionMixta restarMixto (FraccionMixta mixto1, FraccionMixta mixto2){

        Fraccion fraccion1 = convertirMixtoAFraccion(mixto1);
        Fraccion fraccion2 = convertirMixtoAFraccion(mixto2);

        Fraccion resultado = restar(fraccion1, fraccion2);

        return convertirFraccionAMixto(resultado);
    }


    public static FraccionMixta multiplicarMixto (FraccionMixta mixto1, FraccionMixta mixto2){

        Fraccion fraccion1 = convertirMixtoAFraccion(mixto1);
        Fraccion fraccion2 = convertirMixtoAFraccion(mixto2);

        Fraccion resultado = multiplicar(fraccion1, fraccion2);

        return convertirFraccionAMixto(resultado);
    }


    public static FraccionMixta dividirMixto (FraccionMixta mixto1, FraccionMixta mixto2){

        Fraccion fraccion1 = convertirMixtoAFraccion(mixto1);
        Fraccion fraccion2 = convertirMixtoAFraccion(mixto2);

        Fraccion resultado = dividir(fraccion1, fraccion2);

        return convertirFraccionAMixto(resultado);
    }

    public static FraccionMixta amplificarMixto (long numeroAmplificador, FraccionMixta mixto1){

        Fraccion fraccion1 = convertirMixtoAFraccion(mixto1);
        Fraccion resultado = amplificar(numeroAmplificador, fraccion1);

        return convertirFraccionAMixto(resultado);
    }


    public static FraccionMixta simplicarMixto (FraccionMixta mixto1){

        Fraccion fraccion1 = convertirMixtoAFraccion(mixto1);
        Fraccion resultado = simplificar(fraccion1);

        return convertirFraccionAMixto(resultado);
    }
}
