package resources;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * This class is used for ...
 * @autor Esteban Andres Espinosa Aragon (espinosa.esteban@correounivalle.edu.co
 * @version v.1.0.0 date:30/04/2023
 */
public class inGame extends JFrame {


    public JPanel ventana,dadosActivos,dadosInactivos,puntaje,dadosUtilizados;
    public Image imageInactivos,imageActivos,imagePuntaje,imageUtilizados;
    /**
     * Constructor of GUI class
     */
    public inGame(){
        initGUI();
        setIconImage(new ImageIcon(getClass().getResource("/resources/Imagen1.png")).getImage());
        //Default JFrame configuration
        this.setTitle("Geek Out Masters");
        this.setSize(1400,1080);
        //this.pack();
        this.setResizable(false);
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


        this.imageInactivos = new ImageIcon("/resources/dadosInactivos.jpg").getImage();
        this.imagePuntaje = new ImageIcon("/resources/marcadorPuntaje.jpg").getImage();
        this.imageUtilizados = new ImageIcon("/resources/dadosUtilizados.jpg").getImage();


        this.ventana = new JPanel();
        ventana.setLayout(new GridLayout(2,2));
        this.dadosActivos=new JPanel();
        try {
            imageActivos= ImageIO.read(new File("/resources/dadosActivos.jpg"));
        } catch (Exception e){
            System.out.println("Error"+e.getMessage());
        }
        //dadosActivos.setBackground(Color.BLACK);
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

   /* public void paint(Graphics g){
        g.drawImage(this.imageActivos,0,0,getWidth(),getHeight(),this);
    }*/



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



