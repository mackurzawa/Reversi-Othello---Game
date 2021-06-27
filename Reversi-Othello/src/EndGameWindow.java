import java.awt.*;

public class EndGameWindow {
    public Graphics2D g2 = Window.g2;
    AL action_listener = new AL();
    public EndGameWindow(){
        try{
            Thread.sleep(100);
        } catch (Exception e){
        }
        PointsBar.stop();
        Scores.stop();

        try{
            Thread.sleep(100);
        } catch (Exception e){
        }
        g2.setColor(Color.BLACK);
        g2.fillRoundRect((Constants.screen_width - Constants.end_game_width)/2, (Constants.screen_height - Constants.end_game_height)/2, Constants.end_game_width, Constants.end_game_height, Constants.end_game_window_radius, Constants.end_game_window_radius);
        g2.setColor(Color.WHITE);
        g2.fillRoundRect((Constants.screen_width - Constants.end_game_width)/2 + 5, (Constants.screen_height - Constants.end_game_height)/2 + 5, Constants.end_game_width - 10, Constants.end_game_height - 10, Constants.end_game_window_radius, Constants.end_game_window_radius);

        g2.drawImage(Constants.confetti, 220, 155, Window.window);
        g2.drawImage(Constants.confetti, 600, 155, Window.window);


        FontMetrics metrics = g2.getFontMetrics(Constants.end_game_font);
        g2.setColor(Color.BLACK);
        g2.setFont(Constants.end_game_font);
        try{
            Thread.sleep(30);
        } catch (Exception e){
        }
        g2.drawString(Constants.end_game_title, Constants.screen_width/2 - metrics.stringWidth(Constants.end_game_title)/2, Constants.screen_height/3);

        g2.drawImage(Constants.golden_cup, 380, 380, Window.window);

        metrics = g2.getFontMetrics(Constants.end_game_username_font);
        g2.setFont(Constants.end_game_username_font);
        if(Game.first_color_quantity > Game.second_color_quantity){
            g2.drawString(Game.first_username, 530, 530);
        }
        else {
            g2.drawString(Game.second_username, 530, 530);
        }
//        g2.drawImage(Constants.silver_cup, 400, 570, Window.window);

        BackToMenuButton back_to_menu_button = new BackToMenuButton();


    }

}
