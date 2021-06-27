import javax.swing.JButton;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Font;

public class Statistics {
    public static JButton statistics_button;
    AL action_listener = new AL();
    public Statistics(){
        statistics_button = new JButton("Statistics");
        Window.window.add(statistics_button);
        statistics_button.setBounds(Constants.screen_width/2 - Constants.statistics_button_width/2,Constants.screen_height/2 + Constants.how_to_play_button_height + 2*Constants.dif_bet_buttons, Constants.statistics_button_width, Constants.statistics_button_height);
        statistics_button.addActionListener(action_listener);
        statistics_button.setBackground(Constants.button_color);
        statistics_button.setFont(new Font("Calibri", Font.ITALIC, 40));
        statistics_button.setForeground(Color.BLACK);
        statistics_button.setBorder(BorderFactory.createEtchedBorder());
        statistics_button.setFocusable(false);

    }
}
