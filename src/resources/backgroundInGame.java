package resources;

import javax.swing.*;
import java.awt.*;

public class backgroundInGame {
    private Image backgroundImage;

    public void paint (Graphics g){
        backgroundImage = new ImageIcon(getClass().getResource("/resources/backgroundInGame.jpg")).getImage();
        g.drawImage(backgroundImage,0,0,1400,1000,inGame.);

        super.paint(g);
    }
}
