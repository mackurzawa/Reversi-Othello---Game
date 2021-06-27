import javax.swing.JButton;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Font;

public class BackToMenuButton {
    public static JButton back_to_menu_button;
    AL action_listener = new AL();
    public static boolean running;

    public BackToMenuButton(){
        back_to_menu_button = new JButton("Back");
        Window.window.add(back_to_menu_button);
        back_to_menu_button.setBounds(Constants.screen_width/2 - Constants.exit_button_width/2,Constants.screen_height*3/5, Constants.exit_button_width, Constants.exit_button_height);
        back_to_menu_button.addActionListener(action_listener);
        back_to_menu_button.setBackground(Constants.button_color);
        back_to_menu_button.setFont(new Font("Calibri", Font.ITALIC, 40));
        back_to_menu_button.setForeground(Color.BLACK);
        back_to_menu_button.setBorder(BorderFactory.createEtchedBorder());
        back_to_menu_button.setFocusable(false);
        running = true;
        run();
    }

    public void run(){
        while(running){
            try{
                Thread.sleep(30);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        Game.running = false;

    }

    public static void stopRunning(){
        running = false;
        back_to_menu_button.setVisible(false);
    }
}
