package resources;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;import java.awt.Graphics;
import java.awt.Toolkit;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * This class is used for ...
 * @autor Esteban Andres Espinosa Aragon (espinosa.esteban@correounivalle.edu.co
 * @version v.1.0.0 date:26/04/2023
 */
public class GUI extends JFrame {

    private JButton startGame,gameRules;
    private Header headerProject;
    private JPanel containerButtonsV1;
    public void paint(Graphics g){
        Dimension dimension=this.getSize();
        ImageIcon icon = new ImageIcon(getClass().getResource("/resources/Fondo.jpg"));

        g.drawImage(icon.getImage(),0,0,dimension.width, dimension.height, null);
        this.setOpacity(0);
        super.paint(g);
    }

    /**
     * Constructor of GUI class
     */
    public GUI(){
        initGUI();
        setIconImage(new ImageIcon(getClass().getResource("/resources/Imagen1.png")).getImage());
        //this.setContentPane(rootPane);
        //backgroundImage = new ImageIcon(getClass().getResource("/resources/Fondo.jpg")).getImage();
        //Default JFrame configuration
        this.setTitle("Geek Out Masters");
        this.setSize(1800,1040);
        this.getContentPane();
        //this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


  /*  public void paint (Graphics g){
        backgroundImage = new ImageIcon(getClass().getResource("/resources/Fondo.jpg")).getImage();

        g.drawImage(backgroundImage,0,0,getWidth(),getHeight(),this);

        super.paint(g);
    }*/
    private void setIconImage(URL resource) {
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {


        startGame = new JButton("START GAME");
        startGame.setOpaque(true);
        startGame.setBorder(null);
        startGame.setSize(50,50);

        gameRules = new JButton("GAME RULES");
        gameRules.setOpaque(true);
        gameRules.setBorder(null);
        gameRules.setSize(50,50);

        this.containerButtonsV1=new JPanel();
        containerButtonsV1.setSize(200,200);
        this.containerButtonsV1.add(startGame);
        this.containerButtonsV1.add(gameRules);


        this.add(containerButtonsV1,"Center");
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
