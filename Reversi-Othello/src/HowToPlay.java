import javax.swing.JButton;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Font;

public class HowToPlay {
    public static JButton how_to_play_button;
    AL action_listener = new AL();
    public HowToPlay(){
        how_to_play_button = new JButton("How to play");
        Window.window.add(how_to_play_button);
        how_to_play_button.setBounds(Constants.screen_width/2 - Constants.how_to_play_button_width/2,Constants.screen_height/2 + Constants.dif_bet_buttons, Constants.how_to_play_button_width, Constants.how_to_play_button_height);
        how_to_play_button.addActionListener(action_listener);
        how_to_play_button.setBackground(Constants.button_color);
        how_to_play_button.setFont(new Font("Calibri", Font.ITALIC, 40));
        how_to_play_button.setForeground(Color.BLACK);
        how_to_play_button.setBorder(BorderFactory.createEtchedBorder());
        how_to_play_button.setFocusable(false);

    }
}
