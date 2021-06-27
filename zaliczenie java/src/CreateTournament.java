import javax.swing.*;
import java.awt.*;
import java.io.*;

public class CreateTournament {

    boolean created_or_joined;
    String tournament_name;

    String tournament_name_temp;
    String player1name = null;
    String player2name = null;
    String player3name = null;
    String player4name = null;
    String game1v2 = null;
    String game3v4 = null;
    String game12v34 = null;

    String score1 = null;
    String score2 = null;
    String score3 = null;
    String score4 = null;
    String score12 = null;
    String score34 = null;

    Graphics2D g2 = Window.g2;

    public CreateTournament(){
        created_or_joined = false;
        run();
    }

    public void run(){

        g2.setColor(new Color(40, 40, 40));
        g2.fillRoundRect(Constants.screen_width/2 - Constants.game_settings_width/2, Constants.screen_height/4 + 50, Constants.game_settings_width, Constants.game_settings_height, 105, 105);
        g2.setColor(new Color(220, 220, 220));
        g2.fillRoundRect(Constants.screen_width/2 - Constants.game_settings_width/2 + 5, Constants.screen_height/4 + 50 + 5, Constants.game_settings_width - 10, Constants.game_settings_height - 10, 100, 100);


        int in_file;
        while(!created_or_joined){

            tournament_name = JOptionPane.showInputDialog(Window.window, "Enter name of the tournament.\nIf new, new tournament will be created", "Tournament", JOptionPane.PLAIN_MESSAGE);
            in_file = isTournamentInFile(tournament_name);
            if(in_file == 1){
                created_or_joined = true;
                JOptionPane.showMessageDialog(Window.window, "Created new tournament", "Well done", JOptionPane.QUESTION_MESSAGE);
                Tournament.tournament_name = tournament_name;
            }
            else if(in_file == 2){
                created_or_joined = true;
                JOptionPane.showMessageDialog(Window.window, "Joined tournament", "Well done", JOptionPane.QUESTION_MESSAGE);
                Tournament.tournament_name = tournament_name;
            }
        }

        SignInButton.sign_in_button.setVisible(false);
        SignUpButton.sign_up_button.setVisible(false);
        Exit.exit_button.setVisible(false);
        try{
            Thread.sleep(60);
        } catch (Exception e){
        }
    }

    public int isTournamentInFile(String tournament_name){
        int in_file = 1;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Tournaments.txt"));
            String line = reader.readLine();

            while(line != null){
                tournament_name_temp = line;
                player1name = reader.readLine();
                player2name = reader.readLine();
                player3name = reader.readLine();
                player4name = reader.readLine();

                game1v2 = reader.readLine();
                score1 = reader.readLine();
                score2 = reader.readLine();

                game3v4 = reader.readLine();
                score3 = reader.readLine();
                score4 = reader.readLine();

                game12v34 = reader.readLine();
                score12 = reader.readLine();
                score34 = reader.readLine();

                line = reader.readLine();

                if(tournament_name_temp.equals(tournament_name)){
                    in_file = 2;
                    break;
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(in_file == 1){
            newTournament();
        }

        Tournament.player1name = player1name;
        Tournament.player2name = player2name;
        Tournament.player3name = player3name;
        Tournament.player4name = player4name;
        Tournament.game1v2 = game1v2;
        Tournament.score1 = score1;
        Tournament.score2 = score2;
        Tournament.game3v4 = game3v4;
        Tournament.score3 = score3;
        Tournament.score4 = score4;
        Tournament.game12v34 = game12v34;
        Tournament.score12 = score12;
        Tournament.score34 = score34;

        if(game1v2.equals("1")){
            Tournament.player12name = player1name;
        }
        else if(game1v2.equals("2")){
            Tournament.player12name = player2name;
        }

        if(game3v4.equals("3")){
            Tournament.player34name = player3name;
        }
        else if(game3v4.equals("4")){
            Tournament.player34name = player4name;
        }
        if(game12v34.equals("12")){
            Tournament.player1234name = Tournament.player12name;
        }
        else if(game12v34.equals("34")){
            Tournament.player1234name = Tournament.player34name;
        }


        System.out.println(player1name+" "+player2name+" "+player3name+" "+player4name+" \n");

        return in_file;
    }

    void newTournament(){
        player2name = JOptionPane.showInputDialog(Window.window, "Enter name for 2-nd player", "Tournament", JOptionPane.PLAIN_MESSAGE);
        if(player2name != null){
            player3name = JOptionPane.showInputDialog(Window.window, "Enter name for 3-rd player", "Tournament", JOptionPane.PLAIN_MESSAGE);
            if(player3name != null){
                player4name = JOptionPane.showInputDialog(Window.window, "Enter name for 4-th player", "Tournament", JOptionPane.PLAIN_MESSAGE);
                if(player4name == null){
                   player4name = "AI";
                }
            }
            else{
                player3name = "AI";
                player4name = "AI";
            }
        }
        else{
            player2name = "AI";
            player3name = "AI";
            player4name = "AI";
        }
        player1name = Menu.username;
        game1v2 = "0";
        game3v4 = "0";
        game12v34 = "0";


        try {
            Writer writer = null;
            writer = new BufferedWriter(new FileWriter("Tournaments.txt", true));
            writer.append(tournament_name+"\n");
            writer.append(player1name+"\n");
            writer.append(player2name+"\n");
            writer.append(player3name+"\n");
            writer.append(player4name+"\n");
            writer.append(game1v2+"\n");
            writer.append("0"+"\n");
            writer.append("0"+"\n");
            writer.append(game3v4+"\n");
            writer.append("0"+"\n");
            writer.append("0"+"\n");
            writer.append(game12v34+"\n");
            writer.append("0"+"\n");
            writer.append("0"+"\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
