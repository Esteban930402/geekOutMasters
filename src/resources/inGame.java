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


    public JPanel ventana, dadosActivos, dadosInactivos, puntaje, dadosUtilizados, containerButton, containerInGame; //Creacion de paneles, Ventana: contenedor principal donde se almacenaran los contenedores activos, inactivos el area de puntaje, dados utilizados, y el contenedores de botones
    public ImageIcon imageDices;

    public JButton[] dados;// Creacion array de dados
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
    private void initGUI() {//Inicializacion de componentes,adiccion de botones y asignacion de metodos
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
        dadosActivos.setBorder(BorderFactory.createTitledBorder("Dados Activos"));
        dadosActivos.setLayout(new GridLayout(3, 3));

        this.dadosInactivos = new JPanel(); // panel dados inactivos
        dadosInactivos.setBorder(BorderFactory.createTitledBorder("Dados Inactivos"));
        dadosInactivos.setLayout(new GridLayout(3, 3));

        this.puntaje = new JPanel(); // panel puntaje
        puntaje.setBorder(BorderFactory.createTitledBorder("Puntaje"));


        this.dadosUtilizados = new JPanel(); // panel dados utilizados

        dadosUtilizados.setLayout(new GridLayout(3, 3));
        dadosUtilizados.setBorder(BorderFactory.createTitledBorder("Dados Activos"));
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
                dados[i].setOpaque(false);
                dados[i].setBorder(null);
                dados[i].setBorderPainted(false);
                dados[i].setIcon(imageDices);
                dadosActivos.add(dados[i]);
                //dados[i].addMouseListener(listener);
                //dados[i].addActionListener(listener);
            } else if (i > 6) {
                dados[i] = new JButton();
                dados[i].setOpaque(false);
                dados[i].setBorder(null);
                dados[i].setBorderPainted(false);
                dados[i].setIcon(imageDices);
                dadosInactivos.add(dados[i]);
                //dados[i].addMouseListener(listener);
                //dados[i].addActionListener(listener);
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
    public void activarInactivos() { //Activa los dados inactivos

        Component[] components = dadosInactivos.getComponents();

        for (Component component : components) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                button.addMouseListener(listener);
                button.setEnabled(true);
            }
        }
        System.out.println("Activa Inactivos");
    }
    public void desactivarInactivos() { //Desactiva los dados Inactivos

        Component[] components = dadosInactivos.getComponents();

        for (Component component : components) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                button.removeMouseListener(listener);
                button.setEnabled(false);
            }
        }
        System.out.println("Desactiva inactivos");
    }
    public void activarActivos() { //Activa los dados Activos

        Component[] components = dadosActivos.getComponents();

        for (Component component : components) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                button.addMouseListener(listener);
                button.setEnabled(true);
            }
        }
        System.out.println("Activa activos");
    }
    public void desactivarActivos() { //Desactiva los dados activos

        Component[] components = dadosActivos.getComponents();

        for (Component component : components) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                button.removeMouseListener(listener);
                button.setEnabled(false);
            }
        }
        System.out.println("Desactiva dados activos");
    }
    public void contardados(){ //Contador de caras 42 y dragones en el panel de dados activos

        int cantidadDadosActivos=0;
        for (int i = 0; i < dados.length; i++) {
            // Verificar si la cara del dado no es 4 ni 2
            if (caras[i] != 4 && caras[i] != 2 && dadosActivos.isAncestorOf(dados[i])) {
                cantidadDadosActivos++;
                System.out.println(cantidadDadosActivos);
            }
        }
        switch (cantidadDadosActivos){
            case 1:
                cantidadDadosActivos=1;
                break;
            case 2:
                cantidadDadosActivos=3;
                break;
            case 3:
                cantidadDadosActivos=6;
                break;
            case 4:
                cantidadDadosActivos=10;
                break;
            case 5:
                cantidadDadosActivos=15;
                break;
            case 6:
                cantidadDadosActivos=21;
                break;
            case 7:
                cantidadDadosActivos=28;
                break;
            case 8:
                cantidadDadosActivos=36;
                break;
            case 9:
                cantidadDadosActivos=45;
                break;
            case 10:
                cantidadDadosActivos=55;
                break;
        }
        System.out.println(cantidadDadosActivos);
    }
    public void acomodarPartida(){//Acomoda la partida reseteando todos los datos para empezar una nueva ronda
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
                dados[i].setIcon(imageDices);
                dados[i].setOpaque(false);
                dados[i].setBorder(null);
                dados[i].setBorderPainted(false);
                dadosActivos.add(dados[i]);
            } else if (i > 6) {
                dados[i].setIcon(imageDices);
                dados[i].setOpaque(false);
                dados[i].setBorder(null);
                dados[i].setBorderPainted(false);
                dadosInactivos.add(dados[i]);
            }
        }
        activarActivos();
        desactivarInactivos();
    }
    private class listener implements ActionListener, MouseListener {


        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == inGame.this.lanzarDados) { //Si el evento obtenido es lanzar dados inicia el juego, asigna la cara correspondiente a cada uno de los dados
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

            }
            if (e.getSource()==inGame.this.terminarRonda){ //Termina la ronda y cuenta el puntaje obtenido segun la cantidad de dados con cara 42 o dragon que se encuentren en el panel de dados activos
                lanzarDados.setEnabled(true);
                contardados();
                acomodarPartida();
            }
            if (e.getSource()==inGame.this.rules){ //Abre una nueva ventana para ver las reglas mientras se esta en juego
                rulesInGame rules1 = new rulesInGame();
                rules1.setVisible(true);
            }
        }

        @Override
        //Evento cuando el mouse se presiona, este evento utiliza el booleano clickCount para realizar una validacion de clicks, en este caso cuando se encuentra en true es porque el programa esta a la espera del primer click por parte del jugador, dependiendo de este ejeccuta una accion, y cuando se encuentra en False esta a la espera del segundo click en donde se ejecutara la accion del dado seleccionado en el primer click
        public void mouseClicked(MouseEvent e) {

            for (int i = 0;i<10;i++){
                if(e.getSource()==dados[i]) {
                    if (clickCount == true) {
                        if (caras[i] == 3) {
                            dadosActivos.remove(dados[i]);
                            dadosUtilizados.add(dados[i]);
                            dados[i].setEnabled(false);
                            dadosActivos.revalidate();
                            dadosActivos.repaint();
                            numeroAccion = 3;
                            clickCount = false;
                            //caras[i]=7-caras[i];
                            //imageDices = new ImageIcon(getClass().getResource("/resources/" + caras[i] + ".png"));
                            //dados[i].setIcon(imageDices);
                        }
                        if (caras[i] == 4) {
                            //dadosActivos.setEnabled(false);
                            dadosActivos.remove(dados[i]);
                            dadosUtilizados.add(dados[i]);
                            dados[i].setEnabled(false);
                            dadosActivos.revalidate();
                            dadosActivos.repaint();
                            dadosInactivos.revalidate();
                            dadosInactivos.repaint();
                            numeroAccion = 4;
                            clickCount = false;
                            System.out.println("Entro");

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
                            desactivarActivos();
                            activarInactivos();
                            dadosActivos.revalidate();
                            dadosActivos.repaint();
                            dadosInactivos.revalidate();
                            dadosInactivos.repaint();
                            numeroAccion=6;
                            clickCount = false;
                        }

                        System.out.println("Se presiono el boton " + i + " y: " + caras[i] + "Estado: " + clickCount);

                    } else  {
                        if (e.getSource() == dados[i] && numeroAccion == 5) {
                            caras[i]=7-caras[i];
                            imageDices = new ImageIcon(getClass().getResource("/resources/" + caras[i] + ".png"));
                            dados[i].setIcon(imageDices);
                            dadosActivos.repaint();
                            dadosActivos.revalidate();
                            clickCount=true;
                            numeroAccion=0;
                        }
                        if (e.getSource() == dados[i] && numeroAccion == 6) {
                            dados[i].setEnabled(false);
                            dadosActivos.add(dados[i]);
                            activarActivos();
                            desactivarInactivos();
                            dadosActivos.repaint();
                            dadosActivos.revalidate();
                            dadosInactivos.repaint();
                            dadosInactivos.revalidate();
                            clickCount=true;
                            numeroAccion=0;
                        }
                        if (e.getSource() == dados[i] && numeroAccion == 3) {
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
                            dadosInactivos.add(dados[i]);
                            dadosActivos.remove(dados[i]);
                            desactivarInactivos();
                            dadosActivos.repaint();
                            dadosActivos.revalidate();
                            dadosInactivos.revalidate();
                            dadosInactivos.repaint();
                            dadosActivos.setEnabled(true);
                            dadosInactivos.setEnabled(false);
                            dadosInactivos.removeMouseListener(this);
                            clickCount=true;
                            numeroAccion=0;
                            System.out.println("Entro 2");

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