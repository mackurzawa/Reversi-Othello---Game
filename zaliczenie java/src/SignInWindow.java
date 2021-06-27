import javax.swing.*;
import java.awt.*;
import java.io.*;

public class SignInWindow{
    Graphics2D g2 = Window.g2;


    String username = "";
    String password = "";
    String games_won = "";
    String games_played = "";
    public static boolean logged_in;



    public SignInWindow(){
        logged_in = false;
        run();
    }

    public void run(){
        int in_array = -1;
        while(!logged_in){

            username = JOptionPane.showInputDialog(Window.window, "Enter your username", "Sign in", JOptionPane.PLAIN_MESSAGE);
            in_array = isUsernameInArray(username);
            if(username == null){
                username = "";
                break;
            }
            else if(in_array == 0){
                JOptionPane.showMessageDialog(Window.window, "Invalid username. Try again!", "Invalid Username :(",JOptionPane.WARNING_MESSAGE);
            }
            else if(in_array == 2){
                logged_in = true;
                JOptionPane.showMessageDialog(Window.window, "Logged in", "Well done", JOptionPane.QUESTION_MESSAGE);
                Menu.username = username;
                Menu.games_played = games_played;
                Menu.games_won = games_won;
            }
        }


//        BOTTOM LOGIN
        if(username != ""){
            Menu.drawingBottomLogin();
        }
    }

    public int isUsernameInArray(String username){

        int in_array = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Users.txt"));
            String line = reader.readLine();
            String valid_username;
            String valid_password;
            String valid_games_won;
            String valid_games_played;
            while(line != null){
                valid_username = line;
                line = reader.readLine();
                valid_password = line;
                valid_games_won = reader.readLine();
                valid_games_played = reader.readLine();

                if(valid_username.equals(username)){
                    in_array = 1;
                    while(in_array != 2){
                        password = JOptionPane.showInputDialog(Window.window, "Enter password for " + username, "Sign in", JOptionPane.PLAIN_MESSAGE);
                        if(password == null){
                            break;
                        }
                        else if(password.equals(valid_password)){
                            in_array = 2;
                            games_won = valid_games_won;
                            games_played = valid_games_played;
                        }
                        else{
                            JOptionPane.showMessageDialog(Window.window, "Invalid password. Try again!", "Invalid Password :(",JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }



                line = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return in_array;
    }

}
