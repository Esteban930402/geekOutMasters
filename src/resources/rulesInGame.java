package resources;

import java.awt.*;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * This class is used for ...
 * @autor Esteban Andres Espinosa Aragon (espinosa.esteban@correounivalle.edu.co
 * @version v.1.0.0 date:30/04/2023
 */
public class rulesInGame extends JFrame {

    public Image backgroundTest;
    public JPanel backgroundPanel,buttonPanel;

    public JButton mainMenu,rulesPart2;

    public listener listener;

    //public Thread hilo;

    /**
     * Constructor of GUI class
     */
    public rulesInGame(){
        initGUIRules();
        setIconImage(new ImageIcon(getClass().getResource("/resources/Imagen1.png")).getImage());
        //Default JFrame configuration
        this.setTitle("Geek Out Masters");
        this.setSize(1000,700);
        //this.pack();
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUIRules() {


        backgroundPanel = new JPanel(){
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                if(backgroundTest!=null){
                    //int x = (getWidth()-backgroundTest.getWidth(null))/2;
                    //int y = (getHeight()-backgroundTest.getHeight(null))/2;
                    g.drawImage(backgroundTest,0,0,getWidth(),getHeight(),null);
                }

            }
        };
        backgroundPanel.setPreferredSize(new Dimension(1000,700));

        //Creacion de hilo

        Thread hilo= new Thread(){
            @Override
            public void run(){
                try {
                    backgroundTest= ImageIO.read(getClass().getResource("/resources/Rules.jpg"));
                    backgroundPanel.repaint();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        hilo.start();
        this.listener = new listener();
        this.buttonPanel = new JPanel();
        this.buttonPanel.setLayout(new BorderLayout());

        this.rulesPart2= new JButton("Next");
        this.rulesPart2.addActionListener(this.listener);
        this.rulesPart2.setBorder(null);
        this.rulesPart2.setOpaque(true);

        this.buttonPanel.add(rulesPart2,BorderLayout.CENTER);
        // this.buttonPanel.add(new JPanel(),"East"); // Panel vacio para evitar la extencion del boton

        this.backgroundPanel.add(buttonPanel);
        getContentPane().add(backgroundPanel);
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


    private class listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource()==rulesInGame.this.rulesPart2){
                rulesInGamePart2 rules2 = null;
                try {
                    rules2 = new rulesInGamePart2();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                rules2.setVisible(true);
                dispose();
            }

        }
    }
}
