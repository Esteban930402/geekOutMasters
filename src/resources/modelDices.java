package resources;

/**
 * This class is used for ...
 * @autor Esteban Andres Espinosa Aragon (espinosa.esteban@correounivalle.edu.co
 * @version v.1.0.0 date:30/04/2023
 */
public class modelDices {

    private dices dice1,dice2,dice3,dice4,dice5,dice6,dice7,dice8,dice9,dice10;
    private  int tiro, punto, estado;
    private String estadoToString;

    private int[] caras;

    public modelDices(){
        dice1=new dices();
        dice2=new dices();
        dice3=new dices();
        dice4=new dices();
        dice5=new dices();
        dice6=new dices();
        dice7=new dices();
        dice8=new dices();
        dice9=new dices();
        dice10=new dices();

        caras = new int[10];
    }

    public void calcularTiro(){
        caras[0]=dice1.getDicesValue();
        caras[1]=dice2.getDicesValue();
        caras[2]=dice3.getDicesValue();
        caras[3]=dice4.getDicesValue();
        caras[4]=dice5.getDicesValue();
        caras[5]=dice6.getDicesValue();
        caras[6]=dice7.getDicesValue();
        caras[7]=dice8.getDicesValue();
        caras[8]=dice9.getDicesValue();
        caras[9]=dice10.getDicesValue();
    }

    public int[] getCaras(){
        return caras;
    }

}
