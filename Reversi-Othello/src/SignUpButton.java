import javax.swing.JButton;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Font;

public class SignUpButton {
    public static JButton sign_up_button;
    AL action_listener = new AL();
    public SignUpButton(){
        sign_up_button = new JButton("Sign Up");
        Window.window.add(sign_up_button);
        sign_up_button.setBounds(100,Constants.screen_height/2 + Constants.how_to_play_button_height + Constants.statistics_button_height + 3*Constants.dif_bet_buttons,Constants.sign_up_button_width, Constants.sign_up_button_height);
        sign_up_button.addActionListener(action_listener);
        sign_up_button.setBackground(Constants.button_color);
        sign_up_button.setFont(new Font("Calibri", Font.ITALIC, 40));
        sign_up_button.setForeground(Color.BLACK);
        sign_up_button.setBorder(BorderFactory.createEtchedBorder());
//        sign_up_button.setBorder(new RoundedBorder(10));
        sign_up_button.setFocusable(false);

    }
}
