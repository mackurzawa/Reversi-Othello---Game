import javax.swing.JButton;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Font;

public class Exit {
    public static JButton exit_button;
    AL action_listener = new AL();
    public Exit(){
        exit_button = new JButton("Exit");
        Window.window.add(exit_button);
        exit_button.setBounds(Constants.screen_width/2 - Constants.exit_button_width/2,Constants.screen_height/2 + Constants.how_to_play_button_height + Constants.statistics_button_height + 3*Constants.dif_bet_buttons, Constants.exit_button_width, Constants.exit_button_height);
        exit_button.addActionListener(action_listener);
        exit_button.setBackground(Constants.button_color);
        exit_button.setFont(new Font("Calibri", Font.ITALIC, 40));
        exit_button.setForeground(Color.BLACK);
        exit_button.setBorder(BorderFactory.createEtchedBorder());
        exit_button.setFocusable(false);

    }
}
