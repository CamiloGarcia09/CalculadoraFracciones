package RepasoUltimate.App;

import RepasoUltimate.Dominio.Calculadora;
import RepasoUltimate.Dominio.Fraccion;
import RepasoUltimate.Dominio.FraccionMixta;

public class Main {

    public static void main(String[] args) {

        Fraccion fraccion1 = Fraccion.crear(8,2);
        Fraccion fraccion2 = Fraccion.crear(5,2);

        FraccionMixta fraccionMixta1 = FraccionMixta.crear(5,2,7);
        FraccionMixta fraccionMixta2 = FraccionMixta.crear(3,2,3);

        System.out.println(Calculadora.sumar(fraccion1, fraccion2) + "\n");
        System.out.println(Calculadora.restar(fraccion1, fraccion2)+ "\n");
        System.out.println(Calculadora.multiplicar(fraccion1, fraccion2)+ "\n");
        System.out.println(Calculadora.dividir(fraccion1, fraccion2)+ "\n");
        System.out.println(Calculadora.amplificar(2, fraccion2)+ "\n");
        System.out.println(Calculadora.convertirFraccionAMixto(fraccion1)+ "\n");
        System.out.println(Calculadora.convertirMixtoAFraccion(fraccionMixta1)+ "\n");
        System.out.println(Calculadora.simplificar(fraccion1)+ "\n");


        System.out.println(Calculadora.sumarMixto(fraccionMixta1, fraccionMixta2) + "\n");
        System.out.println(Calculadora.restarMixto(fraccionMixta1, fraccionMixta2)+ "\n");
        System.out.println(Calculadora.multiplicarMixto(fraccionMixta1, fraccionMixta2)+ "\n");
        System.out.println(Calculadora.dividirMixto(fraccionMixta1, fraccionMixta2)+ "\n");
        System.out.println(Calculadora.amplificarMixto(2,fraccionMixta1)+ "\n");
        System.out.println(Calculadora.simplicarMixto(fraccionMixta2)+ "\n");

    }
}
