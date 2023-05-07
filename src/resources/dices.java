package resources;

import java.util.Random;

public class dices {
    private  int dicesValue;

    public int getDicesValue(){
        Random randomvalue = new Random();
        dicesValue = randomvalue.nextInt(6)+1;
        return dicesValue;
    }
}
