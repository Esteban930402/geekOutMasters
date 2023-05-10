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

public class rulesInGamePart2 extends JFrame {

    public JPanel backgroundPanelRules2,buttonPanel;
    public JButton mainMenu, rulesPart1;

    public Image backgroundRulesPart2;

    public listener listener;
    public rulesInGamePart2() throws IOException {
        initGUIRulesInGamePart2();
        setIconImage(new ImageIcon(getClass().getResource("/resources/Imagen1.png")).getImage());
        //Default JFrame configuration
        this.setTitle("Geek Out Masters");
        this.setSize(1000,700);
        //this.pack();
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
       // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initGUIRulesInGamePart2() throws IOException {

        backgroundPanelRules2= new JPanel(){
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                if(backgroundRulesPart2!= null){
                    g.drawImage(backgroundRulesPart2,0,0,getWidth(),getHeight(),null);
                }
            }
        };

        backgroundPanelRules2.setPreferredSize(new Dimension(1000,700));

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



        this.rulesPart1= new JButton("Back");
        rulesPart1.addActionListener(listener);
        this.rulesPart1.setOpaque(true);
        this.rulesPart1.setBorder(null);

        this.buttonPanel.add(rulesPart1,"South");

        this.backgroundPanelRules2.add(buttonPanel);
        getContentPane().add(backgroundPanelRules2);

    }

    private class listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==rulesInGamePart2.this.rulesPart1){
                rulesInGame rulesInGame1 = new rulesInGame();
                rulesInGame1.setVisible(true);
                dispose();
            }

        }
    }
}