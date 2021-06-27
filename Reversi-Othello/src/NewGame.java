import javax.swing.JButton;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Font;

public class NewGame {
    public static JButton new_game_button;
    AL action_listener = new AL();
    public NewGame(){
        new_game_button = new JButton("New Game");
        Window.window.add(new_game_button);
        new_game_button.setBounds(Constants.screen_width/2 - Constants.new_game_button_width/2,Constants.screen_height/2 - Constants.new_game_button_height,Constants.new_game_button_width, Constants.new_game_button_height);
        new_game_button.addActionListener(action_listener);
        new_game_button.setBackground(Constants.button_color);
        new_game_button.setFont(new Font("Calibri", Font.ITALIC, 70));
        new_game_button.setForeground(Color.BLACK);
        new_game_button.setBorder(BorderFactory.createEtchedBorder());
//        new_game_button.setBorder(new RoundedBorder(10));
        new_game_button.setFocusable(false);

    }
}
