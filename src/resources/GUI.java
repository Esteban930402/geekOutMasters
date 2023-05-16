package resources;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JFrame;


/**
 * This class is used for ...
 * @autor Esteban Andres Espinosa Aragon (espinosa.esteban@correounivalle.edu.co
 * @version v.1.0.0 date:26/04/2023
 */
public class GUI extends JFrame {

    public Image principalBackgroundImage;
    private JButton startGame,gameRules;
    public JPanel containerButtonsV1, backgroundPanel, vacio;

   /*public void paint(Graphics g){
        Dimension dimension=this.getSize();
        ImageIcon icon = new ImageIcon(getClass().getResource("/resources/Fondo.jpg"));

        g.drawImage(icon.getImage(),0,0,dimension.width, dimension.height, null);
        this.setOpacity(0);
        super.paint(g);
    }*/

    private Listener listener;

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
        this.setSize(1400,920);
        this.getContentPane();
        //this.pack();
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void setIconImage(URL resource) {
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {


        backgroundPanel =new JPanel(){
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (principalBackgroundImage != null) {
                    g.drawImage(principalBackgroundImage, 0, 0, getWidth(), getHeight(), null);
                }

            }
        };
        backgroundPanel.setPreferredSize(new Dimension(1400,1080));

        //Creacion de hilo

        Thread hilo= new Thread(){
            @Override
            public void run(){
                try {
                    principalBackgroundImage= ImageIO.read(getClass().getResource("/resources/Fondo.jpg"));
                    backgroundPanel.repaint();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        hilo.start();

        listener = new Listener();
        vacio=new JPanel();
        backgroundPanel.setLayout(new BorderLayout());
        containerButtonsV1 = new JPanel();
        //this.containerButtonsV1.setLayout(new BorderLayout());


        startGame = new JButton("START GAME");
        startGame.addActionListener(listener);
        startGame.setOpaque(false);
        startGame.setBorderPainted(false);
        startGame.setContentAreaFilled(false);
        //this.startGame.setBounds(700,450,100,30);


        gameRules = new JButton("GAME RULES");
        gameRules.addActionListener(listener);
        gameRules.setOpaque(false);
        gameRules.setBorder(null);
        gameRules.setContentAreaFilled(false);
        //this.gameRules.setBounds(700,500,100,30);
        //containerButtonsV1.setPreferredSize(new Dimension(1400,1080));
        containerButtonsV1.add(startGame);
        containerButtonsV1.add(gameRules);
        //this.add(containerButtonsV1,BorderLayout.SOUTH);      //  backgroundPanel.add(containerButtonsV1,BorderLayout.CENTER);
       backgroundPanel.add(containerButtonsV1,BorderLayout.SOUTH);
        getContentPane().add(backgroundPanel);
        //getContentPane().setLayout(null);
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

    private void startGameActionPerformed(java.awt.event.ActionEvent evt)
    {

    }
    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Listener implements ActionListener, MouseListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource()== GUI.this.gameRules) { // Al presionar el boton Game Rules se abre una nueva ventana para ver las reglas del juego y una pequeña explicacion
                vGameRules vGameRules1 = new vGameRules();
                vGameRules1.setVisible(true);
                dispose();
            }
            if (e.getSource()==GUI.this.startGame){ //Inicia el juego
                inGame vInGame = new inGame();
                vInGame.setVisible(true);
                dispose();
            }

        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
