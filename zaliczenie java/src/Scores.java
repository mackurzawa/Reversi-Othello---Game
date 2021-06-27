import java.awt.*;

public class Scores implements Runnable{
    Graphics2D g2 = Window.g2;
    public static boolean running;
    public static boolean check;


    public Scores(){
        running = true;
        check = true;
    }


    public void run(){
        while(running){
            try {
                Thread.sleep(60);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(check) {
                while(!Constants.semaphore){

                }
                Constants.semaphore = false;
                g2.setColor(Constants.first_piece);
                g2.fillRect(Constants.score_padding, Constants.screen_height - Constants.score_height - Constants.score_padding, 2 * Constants.score_height, Constants.score_height);

                FontMetrics metrics = Window.g2.getFontMetrics(Constants.score_font);
                g2.setFont(Constants.score_font);

                g2.setColor(Constants.second_piece);
                g2.drawString(String.valueOf(Game.first_color_quantity), Constants.score_padding + Constants.score_height - metrics.stringWidth(String.valueOf(Game.first_color_quantity))/2, Constants.screen_height - Constants.score_height - Constants.score_padding + 100);


                g2.setColor(Constants.second_piece);
                g2.fillRect(Constants.screen_width - 2 * Constants.score_height - Constants.score_padding, Constants.screen_height - Constants.score_height - Constants.score_padding, 2 * Constants.score_height, Constants.score_height);

                g2.setColor(Constants.first_piece);
                g2.drawString(String.valueOf(Game.second_color_quantity), Constants.screen_width - 2 * Constants.score_height - Constants.score_padding + Constants.score_height - metrics.stringWidth(String.valueOf(Game.second_color_quantity))/2, Constants.screen_height - Constants.score_height - Constants.score_padding + 100);

                Constants.semaphore = true;

                check = false;
            }

        }

    }

    public static void stop(){
        running = false;
    }


}
