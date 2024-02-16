package Repaso.App;

import Repaso.Dominio.Calculadora;
import Repaso.Dominio.Fraccion;
import Repaso.Dominio.FraccionMixta;

public class Main {

    public static void main(String[] args) {
        Calculadora calculadoraFracciones=new Calculadora();
        Fraccion fraccion1=new Fraccion(2 ,3);
        Fraccion fraccion2=new Fraccion(1,2);
        FraccionMixta fraccionMixta1=new FraccionMixta(5,6,2);
        FraccionMixta fraccionMixta2=new FraccionMixta(1,2,7);


        System.out.println("La suma de fracciones es: "+calculadoraFracciones.sumar(fraccion1,fraccion2));
        System.out.println("La resta de fracciones es: "+calculadoraFracciones.restar(fraccion1,fraccion2));
        System.out.println("La multiplicación de fracciones es: "+calculadoraFracciones.multiplicar(fraccion1,fraccion2));
        System.out.println("La división de fracciones es: "+calculadoraFracciones.dividir(fraccion1,fraccion2));
        System.out.println("La fraccion 1 amplificada es: "+ calculadoraFracciones.amplificar(2, fraccion1) + "\n");
        System.out.println("La fraccion 1 convertida a mixto es: "+ calculadoraFracciones.convertirFraccionAMixto(fraccion1));
        System.out.println("La fraccion mixta 1 convertida a fraccion es: "+ calculadoraFracciones.convertirMixtoAFraccion(fraccionMixta1));
    }
}
