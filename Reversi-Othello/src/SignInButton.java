import javax.swing.JButton;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Font;

public class SignInButton {
    public static JButton sign_in_button;
    AL action_listener = new AL();
    public SignInButton(){
        sign_in_button = new JButton("Sign In");
        Window.window.add(sign_in_button);
        sign_in_button.setBounds(Constants.screen_width - Constants.sign_in_button_width - 100,Constants.screen_height/2 + Constants.how_to_play_button_height + Constants.statistics_button_height + 3*Constants.dif_bet_buttons,Constants.sign_in_button_width, Constants.sign_in_button_height);
        sign_in_button.addActionListener(action_listener);
        sign_in_button.setBackground(Constants.button_color);
        sign_in_button.setFont(new Font("Calibri", Font.ITALIC, 40));
        sign_in_button.setForeground(Color.BLACK);
        sign_in_button.setBorder(BorderFactory.createEtchedBorder());
        //sign_in_button.setBorder(new RoundedBorder(10));
        sign_in_button.setFocusable(false);

    }
}
