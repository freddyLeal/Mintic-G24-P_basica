package juego;


public class SimulationCraps {
    
    private int gano = 0;
    private int perdio = 0;
    private final int ciclos;

    
    public SimulationCraps(int ciclos) {
        this.ciclos = ciclos;
    }
    
    public void simular(){
        Craps juegoCrap = new Craps();
        boolean result;
        for(int i=0; i < ciclos; i++){
            result = juegoCrap.jugar();
            if( result == true){
                gano++;
            } else {
                perdio++;
            }
        }
        
        System.out.println();
        System.out.println();
        System.out.println("El juegador gano: " + gano + " partidas.");
        System.out.println("El juegador perdio: " + perdio + " partidas.");
        
        double procentaje = 100 - (gano*100 / ciclos);
        System.out.println("La casa gana : " + procentaje + "% de las veces.");
    }

    
}
