package juego;

/*
    si lanzo 7 - 11 : gano al primer tiro
    si lanzo 2, 3, o 12: prierdo a la primera
        
    guardar el valor el primer lanzamiento
        
    sino es ninguna, guardo el valor, y lanzo los dados hasta que:
    me salga el mismo valor que obtuve a la primera y si lanzo 7, piedo.
*/
public class Craps {
    
    private enum ESTADO {CONTINUA, GANO, PERDIO};
    private final Dado dado1 = new Dado(6);
    private final Dado dado2 = new Dado(6);
    
    private final static int DOS = 2;
    private final static int TRES = 3;
    private final static int SIETE = 7;
    private final static int ONCE = 11;
    private final static int DOCE = 12;

    
    
    public boolean jugar(){
        ESTADO estadoJuego;
        int miPunto = 0;
        int valorDatos = lanzarDados();
        
        switch( valorDatos ){
            case SIETE:
            case ONCE:
                estadoJuego = ESTADO.GANO;
                break;
            case DOS:
            case TRES:
            case DOCE:
                estadoJuego = ESTADO.PERDIO;
                break;
            default:
                miPunto = valorDatos;
                estadoJuego = ESTADO.CONTINUA;
                break;
        }
        
        while( estadoJuego == ESTADO.CONTINUA ){
            valorDatos = lanzarDados();
            if( miPunto == valorDatos)  
                estadoJuego = ESTADO.GANO; 
            else 
                if( valorDatos == SIETE )
                    estadoJuego = ESTADO.PERDIO; 
        }
        
        if( estadoJuego == ESTADO.GANO ){
            return true;
        } else {
            return false;
        }
    }
    
    
    
    private int lanzarDados(){
        int suma = 0;
        
        int valor1 = dado1.lanzar();
        int valor2 = dado2.lanzar();
        suma = valor1 + valor2;
        return suma;
    }
    
 
    
}
