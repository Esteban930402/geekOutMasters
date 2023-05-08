package resources;

import java.util.Random;

/**
 * This class is used for ...
 * @autor Esteban Andres Espinosa Aragon (espinosa.esteban@correounivalle.edu.co
 * @version v.1.0.0 date:30/04/2023
 */
public class dices {
    private  int dicesValue;

    public int getDicesValue(){
        Random randomValue = new Random();
        dicesValue = randomValue.nextInt(6)+1;
        return dicesValue;
    }
}
