package Repaso.Dominio.Exception;

public class FraccionInexistenteException extends RuntimeException{

    public FraccionInexistenteException (){
        super("La fraccion no existe");
    }

}
