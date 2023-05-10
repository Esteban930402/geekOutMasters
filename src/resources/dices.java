package resources;

import java.util.Random;

/**
 * This class is used for ...
 * @autor Esteban Andres Espinosa Aragon (espinosa.esteban@correounivalle.edu.co
 * @version v.1.0.0 date:30/04/2023
 */
public class dices {
    private  int dicesValue;

    private int relanzar;

    private String power;

    public dices() {
    }

    public int getDicesValue(){
        Random randomValue = new Random();
        dicesValue = randomValue.nextInt(6)+1;
        return dicesValue;
    }
    public int getRelanzar(){
        Random random = new Random();
        relanzar= random.nextInt(6)+1;
        return relanzar;
    }
}
