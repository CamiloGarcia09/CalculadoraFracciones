package RepasoUltimate.Dominio.Exception;

public class ParteEnteraException extends RuntimeException{

    public ParteEnteraException (){
        super ("No es posible crear un numero mixto con la parte entera negativa");
    }
}
