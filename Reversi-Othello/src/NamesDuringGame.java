import java.awt.*;

public class NamesDuringGame implements Runnable{
    Graphics2D g2 = Window.g2;
    public NamesDuringGame() {
    }

    public void run(){
        while(!Constants.semaphore){

        }
        Constants.semaphore = false;
        g2.setColor(Constants.first_piece);
        g2.fillRect(Constants.score_padding, Constants.screen_height - 2*Constants.score_height - Constants.score_padding - 40, 2 * Constants.score_height, Constants.score_height);

        FontMetrics metrics = Window.g2.getFontMetrics(Constants.names_font);
        g2.setFont(Constants.names_font);

        g2.setColor(Constants.second_piece);
        g2.drawString(Game.first_username, Constants.score_padding + Constants.score_height - metrics.stringWidth(Game.first_username)/2, Constants.screen_height - 2*Constants.score_height - Constants.score_padding - 40 + 70);


        g2.setColor(Constants.second_piece);
        g2.fillRect(Constants.screen_width - 2 * Constants.score_height - Constants.score_padding, Constants.screen_height - 2*Constants.score_height - Constants.score_padding - 40, 2 * Constants.score_height, Constants.score_height);

        g2.setColor(Constants.first_piece);
        g2.drawString(Game.second_username, Constants.screen_width - 2 * Constants.score_height - Constants.score_padding + Constants.score_height - metrics.stringWidth(Game.second_username)/2, Constants.screen_height - 2*Constants.score_height - Constants.score_padding - 40 + 70);

        Constants.semaphore = true;
    }
}
