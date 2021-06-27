import javax.swing.*;
import java.awt.*;
import java.io.*;

public class SignUpWindow{
    Graphics2D g2 = Window.g2;


    String username = "";
    String password = "";



    public SignUpWindow(){
        run();
    }

    public void run(){
        signUp();
        Menu.username = username;
        Menu.games_won = "0";
        Menu.games_played = "0";

//        BOTTOM LOGIN
        if(username != ""){
            FontMetrics metrics = g2.getFontMetrics(Constants.user_font);
            Window.g2.setFont(Constants.user_font);
            Window.g2.setColor(new Color(0,0,0));
            Window.g2.fillRect(0, Constants.screen_height - 50, Constants.screen_width, 50);
            Window.g2.setColor(new Color(240,240,240));
            Window.g2.drawString("Logged as " + username, Constants.screen_width/2 - metrics.stringWidth("Logged as " + username)/2, Constants.screen_height - 20);
        }
    }

    public void signUp(){

        try {
            username = JOptionPane.showInputDialog(Window.window, "Enter your new username", "Sign Up", JOptionPane.PLAIN_MESSAGE);
            if(null != username) {
                password = JOptionPane.showInputDialog(Window.window, "Enter password for " + username, "Sign Up", JOptionPane.PLAIN_MESSAGE);
                if(password != null){
                    JOptionPane.showMessageDialog(Window.window, "Signing up ended successful! You will be automatically logged in ;)", "Well done", JOptionPane.QUESTION_MESSAGE);
                    Writer writer = new BufferedWriter(new FileWriter("Users.txt", true));
                    writer.append(username+"\n");
                    writer.append(password+"\n");
                    writer.append("0"+"\n");
                    writer.append("0"+"\n");
                    writer.close();
                }
            }
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
