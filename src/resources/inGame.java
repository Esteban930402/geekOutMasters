package resources;

import javax.swing.*;
import java.awt.*;

public class inGame extends JFrame {


    public JPanel ventana,dadosActivos,dadosInactivos,puntaje,dadosUtilizados;
    /**
     * Constructor of GUI class
     */
    public inGame(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("Geek Out Masters");
        this.setSize(1400,1080);
        //this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {
        //Set up JFrame Container's Layout
        //Create Listener Object and Control Object
        //Set up JComponents
        setLayout(new GridLayout(4,4));

        this.ventana = new JPanel();
        ventana.setLayout(new GridLayout(2,2));
        this.dadosActivos=new JPanel();
        dadosActivos.setBackground(Color.BLACK);
        this.dadosInactivos= new JPanel();
        dadosInactivos.setBackground(Color.white);
        this.puntaje = new JPanel();
        puntaje.setBackground(Color.red);
        this.dadosUtilizados=new JPanel();
        dadosUtilizados.setBackground(Color.BLUE);

        this.ventana.add(this.dadosActivos);
        this.ventana.add(this.dadosInactivos);
        this.ventana.add(this.puntaje);
        this.ventana.add(this.dadosUtilizados);

        setContentPane(ventana);

    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha {

    }
}
