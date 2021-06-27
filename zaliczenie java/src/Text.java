import javax.swing.JComponent;
import java.awt.*;

public class Text extends JComponent {
    String text;

    public Text(String txt){
        this.text = txt;
    }

    public void paintComponent(Graphics2D g2){
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Times New Roman", Font.PLAIN, 50));
        g2.drawString(this.text, 50, 100);
    }
}
