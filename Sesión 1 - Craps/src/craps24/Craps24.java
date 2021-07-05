package craps24;

import juego.SimulationCraps;





public class Craps24 {
    public static void main(String[] args) {
        SimulationCraps simular = new SimulationCraps(10000000);
        simular.simular();
    }
}
