package resources;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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

    public JButton[] dados;
    public JButton rules, lanzarDados, terminarRonda;
    public listener listener;
    public boolean clickCount=true;
    int numeroAccion=0;
    public modelDices modelDices;

    public dices prueba;
    int[] caras = new int[10];


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


        prueba = new dices();


        imageDices = new ImageIcon(getClass().getResource("/resources/dice.png"));

        dados = new JButton[10];


        terminarRonda= new JButton("Terminar ronda");
        terminarRonda.setEnabled(false);
        terminarRonda.addActionListener(listener);
        lanzarDados = new JButton("Lanzar Dados");
        lanzarDados.addActionListener(listener);
        rules = new JButton("Reglas");
        rules.addActionListener(listener);

        containerButton = new JPanel(new FlowLayout());
        this.containerButton.add(lanzarDados);
        this.containerButton.add(rules);
        this.containerButton.add(terminarRonda);

        containerInGame = new JPanel();
        containerInGame.setLayout(new GridLayout(2, 2));

        this.ventana = new JPanel(new BorderLayout());

        this.dadosActivos = new JPanel();//  Pnael dados activos
        dadosActivos.setLayout(new GridLayout(3, 3));
        dadosActivos.addMouseListener(listener);

        this.dadosInactivos = new JPanel(); // panel dados inactivos
        dadosInactivos.addMouseListener(listener);
        dadosInactivos.setLayout(new GridLayout(3, 3));

        this.puntaje = new JPanel(); // panel puntaje


        this.dadosUtilizados = new JPanel(); // panel dados utilizados

        dadosUtilizados.setLayout(new GridLayout(3, 3));
        dadosUtilizados.addMouseListener(listener);
        dadosUtilizados.setOpaque(false);
        dadosUtilizados.setBorder(null);

        containerButton.setBackground(Color.black);
        this.ventana.add(containerInGame, BorderLayout.CENTER);
        this.ventana.add(containerButton, BorderLayout.SOUTH);

        this.containerInGame.add(this.dadosActivos);
        this.containerInGame.add(this.dadosInactivos);
        this.containerInGame.add(this.puntaje);
        this.containerInGame.add(this.dadosUtilizados);

        for (int i = 0; i < dados.length; i++) {
            imageDices = new ImageIcon(getClass().getResource("/resources/dice.png"));
            if (i < 7) {
                dados[i] = new JButton();
                dados[i].setEnabled(true);
                dados[i].setIcon(imageDices);
                dadosActivos.add(dados[i]);
                dados[i].addMouseListener(listener);
                dados[i].addActionListener(listener);
            } else if (i > 6) {
                dados[i] = new JButton();
                dados[i].setEnabled(false);
                dados[i].setIcon(imageDices);
                dadosInactivos.add(dados[i]);
                dados[i].addMouseListener(listener);
                dados[i].addActionListener(listener);
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

    public void acomodarPartida(){
        dadosActivos.removeAll();
        dadosInactivos.removeAll();
        dadosUtilizados.removeAll();
        dadosActivos.repaint();
        dadosActivos.revalidate();
        dadosInactivos.revalidate();
        dadosInactivos.repaint();
        dadosUtilizados.revalidate();
        dadosUtilizados.repaint();

        for (int i = 0; i < dados.length; i++) {
            imageDices = new ImageIcon(getClass().getResource("/resources/dice.png"));
            if (i < 7) {
                dados[i].setEnabled(true);
                dados[i].setIcon(imageDices);
                dadosActivos.add(dados[i]);
            } else if (i > 6) {
                dados[i].setIcon(imageDices);
                dados[i].setEnabled(false);
                dadosInactivos.add(dados[i]);
            }
        }
    }
    private class listener implements ActionListener, MouseListener {


        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == inGame.this.lanzarDados) {
                lanzarDados.setEnabled(false);
                terminarRonda.setEnabled(true);
                acomodarPartida();
                for (int i = 0; i < 10; i++) {
                    caras[i] = prueba.getDicesValue();
                    imageDices = new ImageIcon(getClass().getResource("/resources/" + caras[i] + ".png"));
                    dados[i].setIcon(imageDices);
                    dados[i].addMouseListener(new MouseAdapter() {

                        @Override
                        public void mousePressed(MouseEvent e) {

                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {
                            super.mouseReleased(e);
                        }
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            super.mouseClicked(e);
                        }
                    });
                }
                // for (int j=0;j<dados.length;j++){
                //}
                //dados[i].setText(String.valueOf(caras[i]));//Cambiar entero a cadena
                //System.out.println(dados[i].getText());


            }
            if (e.getSource()==inGame.this.terminarRonda){
                lanzarDados.setEnabled(true);
                acomodarPartida();
            }
            if (e.getSource()==inGame.this.rules){
                rulesInGame rules1 = new rulesInGame();
                rules1.setVisible(true);
            }
            /*for (int i=0; i<dados.length;i++) {
                if(clickCount=false) {
                    if (e.getSource() == dados[i] && numeroAccion == 5) {
                        caras[i] = caras[i] - 7;
                        imageDices = new ImageIcon(getClass().getResource("/resources/" + caras[i] + ".png"));
                        dados[i].setIcon(imageDices);
                        dadosActivos.revalidate();
                        dadosActivos.repaint();
                        numeroAccion = 0;
                        clickCount = true;

                    }
                }
            }*/
        }

        @Override
        public void mouseClicked(MouseEvent e) {

            for (int i = 0;i<10;i++){
                if(e.getSource()==dados[i]) {
                    if (clickCount == true) {
                        if (caras[i] == 1) {
                            dadosActivos.remove(dados[i]);
                            dadosUtilizados.add(dados[i]);
                            dados[i].setEnabled(false);
                            dadosActivos.revalidate();
                            dadosActivos.repaint();
                            numeroAccion = 1;
                            clickCount = false;
                            //caras[i]=7-caras[i];
                            //imageDices = new ImageIcon(getClass().getResource("/resources/" + caras[i] + ".png"));
                            //dados[i].setIcon(imageDices);
                        }
                        if (caras[i] == 2) {
                            dadosActivos.remove(dados[i]);
                            dadosUtilizados.add(dados[i]);
                            dados[i].setEnabled(false);
                            dadosActivos.revalidate();
                            dadosActivos.repaint();
                            clickCount = false;
                        }
                        if (caras[i] == 3) {
                            dadosActivos.remove(dados[i]);
                            dadosUtilizados.add(dados[i]);
                            dados[i].setEnabled(false);
                            dadosActivos.revalidate();
                            dadosActivos.repaint();
                            clickCount = false;
                        }
                        if (caras[i] == 4) {
                            dadosActivos.remove(dados[i]);
                            dadosUtilizados.add(dados[i]);
                            dados[i].setEnabled(false);
                            dadosActivos.revalidate();
                            dadosActivos.repaint();
                            dados[7].setEnabled(true);
                            dados[8].setEnabled(true);
                            dados[9].setEnabled(true);
                            dadosInactivos.revalidate();
                            dadosInactivos.repaint();
                            numeroAccion = 4;
                            clickCount = false;

                        }
                        if (caras[i] == 5) {
                            dadosActivos.remove(dados[i]);
                            dadosUtilizados.add(dados[i]);
                            dados[i].setEnabled(false);
                            dadosActivos.revalidate();
                            dadosActivos.repaint();
                            numeroAccion = 5;
                            clickCount = false;
                        }
                        if (caras[i] == 6) {
                            dadosActivos.remove(dados[i]);
                            dadosUtilizados.add(dados[i]);
                            dados[i].setEnabled(false);
                            dadosActivos.revalidate();
                            dadosActivos.repaint();
                            numeroAccion=6;
                            clickCount = false;
                        }

                        System.out.println("Se presiono el boton " + i + " y: " + caras[i] + "Estado: " + clickCount);

                    } else {
                        if (e.getSource() == dados[i] && numeroAccion == 5) {
                            caras[i]=7-caras[i];
                            imageDices = new ImageIcon(getClass().getResource("/resources/" + caras[i] + ".png"));
                            dados[i].setIcon(imageDices);
                            clickCount=true;
                            numeroAccion=0;
                        }
                        if (e.getSource() == dados[i] && numeroAccion == 6) {
                            dados[i].setEnabled(false);
                            dadosInactivos.add(dados[i]);
                            dadosActivos.repaint();
                            dadosActivos.revalidate();
                            dadosInactivos.repaint();
                            dadosInactivos.revalidate();
                            clickCount=true;
                            numeroAccion=0;
                        }
                        if (e.getSource() == dados[i] && numeroAccion == 1) {
                            caras[i]=prueba.getRelanzar();
                            imageDices = new ImageIcon(getClass().getResource("/resources/" + caras[i] + ".png"));
                            dados[i].setIcon(imageDices);
                            clickCount=true;
                            numeroAccion=0;

                        }
                           /*if (e.getSource() == dados[i] && numeroAccion == 2) {


                           }
                           if (e.getSource() == dados[i] && numeroAccion == 3) {


                           }*/
                        if (e.getSource() == dados[i] && numeroAccion == 4) {
                            dadosActivos.add(dados[i]);
                            dadosInactivos.remove(dados[i]);
                            dadosActivos.repaint();
                            dadosActivos.revalidate();
                            dadosInactivos.revalidate();
                            dadosInactivos.repaint();
                            clickCount=true;
                            numeroAccion=0;

                        }

                    }

                }
            }
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