package resources;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;import java.awt.Graphics;
import java.awt.Dimension;
import javax.swing.JFrame;
import java.awt.EventQueue;

/**
 * This class is used for ...
 * @autor Esteban Andres Espinosa Aragon (espinosa.esteban@correounivalle.edu.co
 * @version v.1.0.0 date:26/04/2023
 */
public class GUI extends JFrame {


    private JButton startGame,gameRules;
    private Header headerProject;
    public JPanel containerButtonsV1,ventana;

   /* public void paint(Graphics g){
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
        this.setSize(1400,1080);
        this.getContentPane();
        //this.pack();
        this.setResizable(true);
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

        this.listener=new Listener();

        this.startGame = new JButton("START GAME");
        this.startGame.setOpaque(true);
        this.startGame.setBorder(null);
       // this.startGame.setSize(50,50);


        this.gameRules = new JButton("GAME RULES");
        this.gameRules.setOpaque(true);
        this.gameRules.setBorder(null);
        //this.gameRules.setSize(50,50);


        this.ventana= new JPanel();
        this.containerButtonsV1=new JPanel();

        this.containerButtonsV1.add(this.gameRules);
        this.containerButtonsV1.add(this.startGame);
        this.ventana.add(this.containerButtonsV1);

        this.gameRules.addActionListener(this.listener);
        this.startGame.addActionListener(this.listener);
        this.gameRules.addMouseListener(this.listener);

        this.add(this.ventana,"Center");

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

            if (e.getSource()== GUI.this.gameRules) {
                vGameRules vGameRules1 = new vGameRules();
                vGameRules1.setVisible(true);
                dispose();
            }
            if (e.getSource()==GUI.this.startGame){
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
