package Repaso.App;

import Repaso.Dominio.Calculadora_R;
import Repaso.Dominio.Fraccion_R;
import Repaso.Dominio.FraccionMixta_R;

public class Main {

    public static void main(String[] args) {
        Calculadora_R calculadoraFracciones=new Calculadora_R();
        Fraccion_R fraccionR1 =new Fraccion_R(2 ,3);
        Fraccion_R fraccionR2 =new Fraccion_R(1,2);
        FraccionMixta_R fraccionMixta1=new FraccionMixta_R(5,6,2);
        FraccionMixta_R fraccionMixta2=new FraccionMixta_R(1,2,7);


        System.out.println("La suma de fracciones es: "+calculadoraFracciones.sumar(fraccionR1, fraccionR2));
        System.out.println("La resta de fracciones es: "+calculadoraFracciones.restar(fraccionR1, fraccionR2));
        System.out.println("La multiplicación de fracciones es: "+calculadoraFracciones.multiplicar(fraccionR1, fraccionR2));
        System.out.println("La división de fracciones es: "+calculadoraFracciones.dividir(fraccionR1, fraccionR2));
        System.out.println("La fraccion 1 amplificada es: "+ calculadoraFracciones.amplificar(2, fraccionR1) + "\n");
        System.out.println("La fraccion 1 convertida a mixto es: "+ calculadoraFracciones.convertirFraccionAMixto(fraccionR1));
        System.out.println("La fraccion mixta 1 convertida a fraccion es: "+ calculadoraFracciones.convertirMixtoAFraccion(fraccionMixta1));
    }
}
