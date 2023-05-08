package resources;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

/**
 * This class is used for ...
 *
 * @version v.1.0.0 date:30/04/2023
 * @autor Esteban Andres Espinosa Aragon (espinosa.esteban@correounivalle.edu.co
 */
public class inGame extends JFrame {


    public JPanel ventana, dadosActivos, dadosInactivos, puntaje, dadosUtilizados, containerButton, containerInGame;
    public ImageIcon imageDices;

    public JLabel presionado;
    public JLabel[] dados;
    public JButton rules, lanzarDados;
    public listener listener;
    public modelDices modelDices;



    /**
     * Constructor of GUI class
     */
    public inGame() {
        setIconImage(new ImageIcon(getClass().getResource("/resources/Imagen1.png")).getImage());
        initGUI();

        //Default JFrame configuration
        this.setTitle("Geek Out Masters");
        this.setSize(1400, 900);
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
        modelDices = new modelDices();
        listener = new listener();


        imageDices = new ImageIcon(getClass().getResource("/resources/dice.png"));

        dados = new JLabel[10];


        lanzarDados = new JButton("Lanzar Dados");
        lanzarDados.addActionListener(listener);
        rules = new JButton("Reglas");
        rules.addActionListener(listener);

        containerButton = new JPanel();
        this.containerButton.add(lanzarDados);
        this.containerButton.add(rules);

        containerInGame = new JPanel();
        containerInGame.setLayout(new GridLayout(2, 2));

        this.ventana = new JPanel(new BorderLayout());

        this.dadosActivos = new JPanel();//  Pnael dados activos
        dadosActivos.setLayout(new GridLayout(3, 3));
        dadosActivos.addMouseListener(listener);

        this.dadosInactivos = new JPanel(); // panel dados inactivos
        dadosInactivos.setLayout(new GridLayout(3, 3));

        this.puntaje = new JPanel(); // panel puntaje

        this.dadosUtilizados = new JPanel(); // panel dados utilizados

        dadosUtilizados.setLayout(new GridLayout(3, 3));
        dadosUtilizados.setOpaque(false);
        dadosUtilizados.setBorder(null);

        containerButton.setBackground(Color.black);
        this.ventana.add(containerInGame, BorderLayout.CENTER);
        this.ventana.add(containerButton, BorderLayout.SOUTH);

        this.containerInGame.add(this.dadosActivos);
        this.containerInGame.add(this.dadosInactivos);
        this.containerInGame.add(this.puntaje);
        this.containerInGame.add(this.dadosUtilizados);

        for (int i = 0; i < 10; i++) {

            if (i < 7) {
                dados[i] = new JLabel();
                dados[i].setIcon(imageDices);
                dadosActivos.add(dados[i]);
            } else if (i > 6) {
                dados[i] = new JLabel();
                dados[i].setIcon(imageDices);
                dadosInactivos.add(dados[i]);
            }

        }
        setContentPane(ventana);
    }

    /**
     * Main process of the Java program
     *
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            inGame miProjectGUI = new inGame();
        });
    }


    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */

    private class listener implements ActionListener, MouseListener {


        @Override
        public void actionPerformed(ActionEvent e) {
            int[] caras = new int[10];
            dices prueba = new dices();
            if (e.getSource() == inGame.this.lanzarDados) {
                for (int i = 0; i < 10; i++) {
                    caras[i] = prueba.getDicesValue();
                    imageDices = new ImageIcon(getClass().getResource("/resources/" + caras[i] + ".png"));
                    dados[i].setIcon(imageDices);
                    dados[i].setText(String.valueOf(caras[i]));//Cambiar entero a cadena
                    //System.out.println(dados[i].getText());

                }
            }
            if (e.getSource()==inGame.this.rules){
                rulesInGame rules1 = new rulesInGame();
                rules1.setVisible(true);
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

