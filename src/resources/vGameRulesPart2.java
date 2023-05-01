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

public class vGameRulesPart2 extends JFrame {

    public JPanel backgroundPanelRules2,buttonPanel;
    public JButton mainMenu, rulesPart1;

    public Image backgroundRulesPart2;

    public listener listener;
    public vGameRulesPart2() throws IOException {
        initGUIRulesPart2();
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

    private void initGUIRulesPart2() throws IOException {

        backgroundPanelRules2= new JPanel(){
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                if(backgroundRulesPart2!= null){
                    g.drawImage(backgroundRulesPart2,0,0,getWidth(),getHeight(),null);
                }
            }
        };

        backgroundPanelRules2.setPreferredSize(new Dimension(1400,1080));

        Thread hilo= new Thread(){
            @Override
            public void run(){
                try {
                    backgroundRulesPart2= ImageIO.read(getClass().getResource("/resources/Reglas2.jpg"));
                    backgroundPanelRules2.repaint();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
       hilo.start();

        buttonPanel=new JPanel();
        buttonPanel.setLayout(new BorderLayout());

        listener = new listener();

        this.mainMenu = new JButton("Main menu");
        this.mainMenu.addActionListener(this.listener);
        this.mainMenu.setOpaque(true);
        this.mainMenu.setBorder(null);

        this.rulesPart1= new JButton();
        this.mainMenu.addActionListener(this.listener);
        this.rulesPart1.setOpaque(true);
        this.rulesPart1.setBorder(null);

        this.buttonPanel.add(mainMenu,"Center");
        this.buttonPanel.add(rulesPart1,"South");

        this.backgroundPanelRules2.add(buttonPanel);
        getContentPane().add(backgroundPanelRules2);

    }

    private class listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==vGameRulesPart2.this.mainMenu){
                GUI mainMenu = new GUI();
                mainMenu.setVisible(true);
                dispose();
            }
            if(e.getSource()==vGameRulesPart2.this.rulesPart1){
                vGameRules gameRules = new vGameRules();
                gameRules.setVisible(true);
                dispose();
            }
        }
    }
}
