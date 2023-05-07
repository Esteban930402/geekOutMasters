package resources;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * This class is used for ...
 * @autor Esteban Andres Espinosa Aragon (espinosa.esteban@correounivalle.edu.co
 * @version v.1.0.0 date:30/04/2023
 */
public class inGame extends JFrame {


    public JPanel ventana,dadosActivos,dadosInactivos,puntaje,dadosUtilizados;
    public Image imageInactivos,imageActivos,imagePuntaje,imageUtilizados, backgroundImage;



    public JButton dado1,dado2,dado3,dado4,dado5,dado6,dado7;

    public listener listener;
    public CardLayout cardLayout;


    /**
     * Constructor of GUI class
     */
    public inGame(){
        setIconImage(new ImageIcon(getClass().getResource("/resources/Imagen1.png")).getImage());
        initGUI();

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

        setLayout(new GridLayout(4, 4));

        this.imageInactivos = new ImageIcon("/resources/dadosInactivos.jpg").getImage();
        this.imagePuntaje = new ImageIcon("/resources/marcadorPuntaje.jpg").getImage();
        this.imageUtilizados = new ImageIcon("/resources/dadosUtilizados.jpg").getImage();
        this.ventana = new JPanel();
        ventana.setLayout(new GridLayout(2, 2));

        this.dadosActivos = new JPanel();//  Pnael dados activos
        dadosActivos.setLayout(new GridLayout(4, 4));
        dado1 = new JButton("1");
        dado1.setBackground(Color.BLUE);
        dado2 = new JButton("2");
        dado2.setBackground(Color.red);
        dado3 = new JButton("3");
        dado3.setBackground(Color.BLACK);
        dado4 = new JButton("4");
        dado4.setBackground(Color.CYAN);
        dado5 = new JButton("5");
        dado5.setBackground(Color.DARK_GRAY);
        dado6 = new JButton("6");
        dado6.setBackground(Color.green);
        dado7 = new JButton("7");
        dado7.setBackground(Color.MAGENTA);
        dadosActivos.add(new JPanel());//Espacios en blanco
        dadosActivos.add(new JPanel());
        dadosActivos.add(new JPanel());
        dadosActivos.add(new JPanel());
        dadosActivos.add(new JPanel());
        dadosActivos.add(dado1);
        dadosActivos.add(dado2);
        dadosActivos.add(dado3);
        dadosActivos.add(dado4);
        dadosActivos.add(dado5);
        dadosActivos.add(dado6);
        dadosActivos.add(dado7);
        dadosActivos.add(new JPanel());//Espacios en blanco
        dadosActivos.add(new JPanel());
        dadosActivos.add(new JPanel());
        dadosActivos.add(new JPanel());
        dadosActivos.add(new JPanel());
        //dadosActivos.setBackground(Color.BLACK);

        cardLayout = new CardLayout();

        this.dadosInactivos= new JPanel(); // panel dados inactivos

        dadosInactivos.setBackground(Color.white);
        this.puntaje = new JPanel(); // panel puntaje
        puntaje.setBackground(Color.red);
        this.dadosUtilizados=new JPanel(); // panel dados utilizados
        dadosUtilizados.setLayout(new GridLayout(4,4));
        //dadosUtilizados.setBackground(Color.BLUE);
        Component component = dadosActivos.getComponent(0);
        dadosUtilizados.setOpaque(false);
        dadosUtilizados.setBorder(null);

        dadosUtilizados.add(component);

        dadosActivos.revalidate();
        dadosUtilizados.revalidate();

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


    private class listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }


}



