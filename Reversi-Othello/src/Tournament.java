import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Tournament {

    static Graphics2D g2 = Window.g2;
    static AL action_listener = new AL();

    public static Game last_game;

    public static String tournament_name;
    public static String player1name;
    public static String player2name;
    public static String player3name;
    public static String player4name;
    public static String player12name;
    public static String player34name;
    public static String player1234name;

    public static String game1v2;
    public static String score1;
    public static String score2;
    public static String game3v4;
    public static String score3;
    public static String score4;
    public static String game12v34;
    public static String score12;
    public static String score34;

    public static String next_game;
    public static String next_button_text;

    static JButton next_game_button;
    static JButton save_tournament_button;

    public static boolean running;
    public static boolean save_tournament;
    public static boolean start_next_game;

    public static int matches_won;
    public static int matches_played;

    public Tournament(){
        new CreateTournament();
        running = true;
        save_tournament = false;
        start_next_game = false;
        matches_won = 0;
        matches_played = 0;
        run();
    }

    public static void run(){
        drawingTournament();
        while(running){
            if(save_tournament){
                save_tournament = false;
                saveTournament();
                if(game12v34.equals("0")) {
                    next_game_button.setVisible(false);
                }
                save_tournament_button.setVisible(false);
                running = false;
            }
            if(start_next_game){
                start_next_game = false;
                System.out.println(41);
                startNextGame();
                if(last_game.first_username.equals(player1name)){
                    if(last_game.first_won){
                        matches_won++;
                    }
                    matches_played++;
                }
                drawingTournament();
                System.out.println(42);
            }
            System.out.println("a");

        }

        try{
            Thread.sleep(60);
        } catch (Exception e){
        }

    }

    public static void drawingTournament(){
        g2.drawImage(Constants.background_wood, 0, 0, Window.window);


        // Drawing Title
        FontMetrics metrics = g2.getFontMetrics(Constants.tournament_font);
        g2.setColor(new Color(40, 40, 40));
        g2.fillRoundRect(Constants.screen_width/2 - metrics.stringWidth("Tournament")/2 - 15, Constants.screen_height/4 - 130 - 5, metrics.stringWidth("Tournament") + 20, 180, 105, 105);
        g2.setColor(new Color(220, 220, 220));
        g2.fillRoundRect(Constants.screen_width/2 - metrics.stringWidth("Tournament")/2 - 10, Constants.screen_height/4 - 130, metrics.stringWidth("Tournament") + 10, 170, 100, 100);

        g2.setColor(Color.BLACK);
        g2.setFont(Constants.tournament_font);
        g2.drawString("Tournament", Constants.screen_width/2 - metrics.stringWidth("Tournament")/2, Constants.screen_height/4);

        //Drawing Tournament Name
        metrics = g2.getFontMetrics(Constants.tournament_name_font);
        g2.setColor(new Color(40, 40, 40));
        g2.fillRoundRect(Constants.screen_width/2 - metrics.stringWidth(tournament_name)/2 - 4 - 5, Constants.screen_height/3 - 5, metrics.stringWidth(tournament_name) + 20, 130, 105, 105);
        g2.setColor(new Color(220, 220, 220));
        g2.fillRoundRect(Constants.screen_width/2 - metrics.stringWidth(tournament_name)/2 - 4, Constants.screen_height/3, metrics.stringWidth(tournament_name) + 10, 120, 100, 100);

        g2.setColor(Color.BLACK);
        g2.setFont(Constants.tournament_name_font);
        g2.drawString(tournament_name, Constants.screen_width/2 - metrics.stringWidth(tournament_name)/2, Constants.screen_height/2 - 75);

        //Drawing Ladder
        g2.fillRect(1*Constants.name_tile_width, 500 + 100 + 80, Constants.name_tile_width, Constants.name_tile_height);
        g2.fillRect(2*Constants.name_tile_width, 500 + 100     , Constants.name_tile_width, Constants.name_tile_height);
        g2.fillRect(3*Constants.name_tile_width, 500 + 100 + 80, Constants.name_tile_width, Constants.name_tile_height);
        g2.fillRect(4*Constants.name_tile_width, 500           , Constants.name_tile_width, Constants.name_tile_height);
        g2.fillRect(5*Constants.name_tile_width, 500 + 100 + 80, Constants.name_tile_width, Constants.name_tile_height);
        g2.fillRect(6*Constants.name_tile_width, 500 + 100     , Constants.name_tile_width, Constants.name_tile_height);
        g2.fillRect(7*Constants.name_tile_width, 500 + 100 + 80, Constants.name_tile_width, Constants.name_tile_height);

        //Drawing Lines

        g2.setStroke(new BasicStroke(8f));
        if(game1v2.equals("1")) {
            g2.drawLine((int) (1.5 * Constants.name_tile_width), 500 + 100 + 80 + Constants.name_tile_height / 2, (int) (2.5 * Constants.name_tile_width), 500 + 100 + Constants.name_tile_height / 2);
        }
        else if (game1v2.equals("2")){
            g2.drawLine((int) (3.5 * Constants.name_tile_width), 500 + 100 + 80 + Constants.name_tile_height / 2, (int) (2.5 * Constants.name_tile_width), 500 + 100 + Constants.name_tile_height / 2);
        }

        if(game3v4.equals("3")) {
            g2.drawLine((int) (5.5 * Constants.name_tile_width), 500 + 100 + 80 + Constants.name_tile_height / 2, (int) (6.5 * Constants.name_tile_width), 500 + 100 + Constants.name_tile_height / 2);
        }
        else if (game3v4.equals("4")){
            g2.drawLine((int) (7.5 * Constants.name_tile_width), 500 + 100 + 80 + Constants.name_tile_height / 2, (int) (6.5 * Constants.name_tile_width), 500 + 100 + Constants.name_tile_height / 2);
        }

        if(game12v34.equals("12")) {
            g2.drawLine((int) (2.5 * Constants.name_tile_width), 500 + 100 + Constants.name_tile_height / 2, (int) (4.5 * Constants.name_tile_width), 500 + Constants.name_tile_height / 2);
        }
        else if (game12v34.equals("34")){
            g2.drawLine((int) (6.5 * Constants.name_tile_width), 500 + 100 + Constants.name_tile_height / 2, (int) (4.5 * Constants.name_tile_width), 500 + Constants.name_tile_height / 2);
        }


        // Drawing Rest names
        metrics = g2.getFontMetrics(Constants.tournament_users_font);
        g2.setFont(Constants.tournament_users_font);
        g2.setColor(new Color(200, 200, 200));
        if(game1v2.equals("1")) {
            g2.drawString(player1name, (int)(2.5*Constants.name_tile_width - metrics.stringWidth(player1name)/2), 500 + 100 - 15 + Constants.name_tile_height);
        }
        else if (game1v2.equals("2")){
            g2.drawString(player2name, (int)(2.5*Constants.name_tile_width - metrics.stringWidth(player2name)/2), 500 + 100 - 15 + Constants.name_tile_height);
        }

        if(game3v4.equals("3")) {
            g2.drawString(player3name, (int)(6.5*Constants.name_tile_width - metrics.stringWidth(player3name)/2), 500 + 100 - 15 + Constants.name_tile_height);
        }
        else if (game3v4.equals("4")){
            g2.drawString(player4name, (int)(6.5*Constants.name_tile_width - metrics.stringWidth(player4name)/2), 500 + 100 - 15 + Constants.name_tile_height);
        }

        if(game12v34.equals("12")) {
            g2.drawString(player12name, (int)(4.5*Constants.name_tile_width - metrics.stringWidth(player12name)/2), 500 - 15 + Constants.name_tile_height);
        }
        else if (game12v34.equals("34")){
            g2.drawString(player34name, (int)(4.5*Constants.name_tile_width - metrics.stringWidth(player34name)/2), 500 - 15 + Constants.name_tile_height);
        }

        // Drawing first 4 names
        g2.setColor(new Color(200, 200, 200));
        g2.drawString(player1name, (int)(1.5*Constants.name_tile_width - metrics.stringWidth(player1name)/2), 500 + 100 + 80 - 15 + Constants.name_tile_height);
        g2.drawString(player2name, (int)(3.5*Constants.name_tile_width - metrics.stringWidth(player2name)/2), 500 + 100 + 80 - 15 + Constants.name_tile_height);
        g2.drawString(player3name, (int)(5.5*Constants.name_tile_width - metrics.stringWidth(player3name)/2), 500 + 100 + 80 - 15 + Constants.name_tile_height);
        g2.drawString(player4name, (int)(7.5*Constants.name_tile_width - metrics.stringWidth(player4name)/2), 500 + 100 + 80 - 15 + Constants.name_tile_height);

        //Drawing Scores
        if(!game1v2.equals("0")){
            g2.drawString(score1 + " : " + score2, (int)(2.5*Constants.name_tile_width - metrics.stringWidth(score1 + " : " + score2)/2), 500 + 100 + 40 - 15 + Constants.name_tile_height);
            if(!game3v4.equals("0")){
                g2.drawString(score3 + " : " + score4, (int)(6.5*Constants.name_tile_width - metrics.stringWidth(score3 + " : " + score4)/2), 500 + 100 + 40 - 15 + Constants.name_tile_height);
                if(!game12v34.equals("0")){
                    g2.drawString(score12 + " : " + score34, (int)(4.5*Constants.name_tile_width - metrics.stringWidth(score12 + " : " + score34)/2), 500 + 40 - 15 + Constants.name_tile_height);

                }


            }
        }


        //Calculating next game
        if(!game1v2.equals("0")){
            if(!game3v4.equals("0")){
                if(!game12v34.equals("0")){
                    next_game = "END";
                }
                else{
                    next_game = "12v34";
                    if(game1v2.equals("1")){
                        next_button_text = "<html><center>Next match</center><center>" + player1name + " vs ";
                    }
                    else if(game1v2.equals("2")){
                        next_button_text = "<html><center>Next match</center><center>" + player2name + " vs ";
                    }
                    if(game3v4.equals("3")){
                        next_button_text = next_button_text + player3name + "</center></html>";
                    }
                    else if(game3v4.equals("4")){
                        next_button_text = next_button_text + player4name + "</center></html>";
                    }
                }
            }
            else{
                next_game = "3v4";
                next_button_text = "<html><center>Next match</center><center>" + player3name + " vs " + player4name + "</center></html>";
            }
        }
        else{
            next_game = "1v2";
            next_button_text = "<html><center>Next match</center><center>" + player1name + " vs " + player2name + "</center></html>";
        }

        // Drawing Buttons
        if(!next_game.equals("END")){

            next_game_button = new JButton(next_button_text);
            Window.window.add(next_game_button);
            next_game_button.setBounds(Constants.screen_width/2 + 50,800, Constants.next_game_button_width, Constants.next_game_button_height);
            next_game_button.addActionListener(action_listener);
            next_game_button.setHorizontalAlignment(SwingConstants.CENTER);
            next_game_button.setBackground(Constants.button_color);
            next_game_button.setFont(new Font("Calibri", Font.ITALIC, 40));
            next_game_button.setForeground(Color.BLACK);
            next_game_button.setBorder(BorderFactory.createEtchedBorder());
            //next_game_button.setBorder(new RoundedBorder(10));
            next_game_button.setFocusable(false);

            save_tournament_button = new JButton("Save tournament");
            Window.window.add(save_tournament_button);
            save_tournament_button.setBounds(Constants.screen_width/2 - Constants.next_game_button_width - 50,800, Constants.next_game_button_width, Constants.next_game_button_height);
            //next_game_button.setBorder(new RoundedBorder(10));
        }
        else{

            save_tournament_button = new JButton("Save tournament");
            Window.window.add(save_tournament_button);
            save_tournament_button.setBounds(Constants.screen_width/2 - Constants.next_game_button_width/2,800, Constants.next_game_button_width, Constants.next_game_button_height);
            //next_game_button.setBorder(new RoundedBorder(10));
        }
        save_tournament_button.addActionListener(action_listener);
        save_tournament_button.setBackground(Constants.button_color);
        save_tournament_button.setFont(new Font("Calibri", Font.ITALIC, 40));
        save_tournament_button.setForeground(Color.BLACK);
        save_tournament_button.setBorder(BorderFactory.createEtchedBorder());
        save_tournament_button.setFocusable(false);
    }

    static void saveTournament(){
        String temp = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Tournaments.txt"));
            String line = reader.readLine();

            while(line != null){
                if(line.equals(tournament_name)){
                    temp = temp + line + "\n"; //Name
                    line = reader.readLine();
                    temp = temp + line + "\n"; // Player 1
                    line = reader.readLine();
                    temp = temp + line + "\n"; // Player 2
                    line = reader.readLine();
                    temp = temp + line + "\n"; // Player 3
                    line = reader.readLine();
                    temp = temp + line + "\n"; // Player 4
                    line = reader.readLine();
                    temp = temp + game1v2 + "\n"; // game1v2
                    line = reader.readLine();
                    temp = temp + score1 + "\n"; // score1
                    line = reader.readLine();
                    temp = temp + score2 + "\n"; // score2
                    line = reader.readLine();
                    temp = temp + game3v4 + "\n"; // game3v4
                    line = reader.readLine();
                    temp = temp + score3 + "\n"; // score3
                    line = reader.readLine();
                    temp = temp + score4 + "\n"; // score4
                    line = reader.readLine();
                    temp = temp + game12v34 + "\n"; // game12v34
                    line = reader.readLine();
                    temp = temp + score12 + "\n"; // score12
                    line = reader.readLine();
                    temp = temp + score34 + "\n"; // score34

                }
                else{
                    temp = temp + line + "\n"; //Name
                    line = reader.readLine();
                    temp = temp + line + "\n"; // Player 1
                    line = reader.readLine();
                    temp = temp + line + "\n"; // Player 2
                    line = reader.readLine();
                    temp = temp + line + "\n"; // Player 3
                    line = reader.readLine();
                    temp = temp + line + "\n"; // Player 4
                    line = reader.readLine();
                    temp = temp + line + "\n"; // game1v2
                    line = reader.readLine();
                    temp = temp + line + "\n"; // score1
                    line = reader.readLine();
                    temp = temp + line + "\n"; // score2
                    line = reader.readLine();
                    temp = temp + line + "\n"; // game3v4
                    line = reader.readLine();
                    temp = temp + line + "\n"; // score3
                    line = reader.readLine();
                    temp = temp + line + "\n"; // score4
                    line = reader.readLine();
                    temp = temp + line + "\n"; // game12v34
                    line = reader.readLine();
                    temp = temp + line + "\n"; // score12
                    line = reader.readLine();
                    temp = temp + line + "\n"; // score34
                }

                line = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Writer writer = null;
            writer = new BufferedWriter(new FileWriter("Tournaments.txt", false));
            writer.write(temp);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    static void startNextGame(){
        next_game_button.setVisible(false);
        save_tournament_button.setVisible(false);

        try{
            Thread.sleep(60);
        } catch (Exception e){
        }

        if(next_game.equals("1v2")){
            if(player2name.equals("AI")){
                Constants.mode = "1vPC"; // 1 vs AI
            }
            else{
                Constants.mode = "1v1"; // 1 vs 2
            }
//            Constants.first_player = player1name;
//            Constants.second_player = player2name;
            last_game = new Game(player1name, player2name);

            if(last_game.first_won){
                Menu.games_won = String.valueOf(Integer.parseInt(Menu.games_won) + 1);
            }
            Menu.games_played = String.valueOf(Integer.parseInt(Menu.games_played) + 1);
        }
        else if(next_game.equals("3v4")){
            if(player3name.equals("AI")){
                // Dwa boty
                score3 = score2;
                score4 = score1;
            }
            else{
                if(player4name.equals("AI")){
                    Constants.mode = "1vPC"; // 3 vs AI
                }
                else{
                    Constants.mode = "1v1"; // 3 vs 4
                }
//                Constants.first_player = player3name;
//                Constants.second_player = player4name;
                last_game = new Game(player3name, player4name);
            }
        }
        else if(next_game.equals("12v34")){
            if(player12name.equals("AI")){
                // Dwa boty
                score12 = score2;
                score34 = score1;
            }
            else{
                if(player34name.equals("AI")){
                    Constants.mode = "1vPC"; // 3 vs AI
                }
                else{
                    Constants.mode = "1v1"; // 3 vs 4
                }
                last_game = new Game(player12name, player34name);

                if(game1v2.equals("1")){
                    if(last_game.first_won){
                        Menu.games_won = String.valueOf(Integer.parseInt(Menu.games_won) + 1);
                    }
                    Menu.games_played = String.valueOf(Integer.parseInt(Menu.games_played) + 1);
                }
            }
        }
        // Updating scores & matches
        updateTournament();
    }

    static void updateTournament(){
        if(next_game.equals("1v2")){
            if(last_game.first_won){
                game1v2 = "1";
                player12name = player1name;
            }
            else{
                game1v2 = "2";
                player12name = player2name;
            }
            score1 = String.valueOf(last_game.first_color_quantity);
            score2 = String.valueOf(last_game.second_color_quantity);
            next_game = "3v4";
        }
        else if (next_game.equals("3v4")){
            if(last_game.first_won){
                game3v4 = "3";
                player34name = player3name;
            }
            else{
                game3v4 = "4";
                player34name = player4name;
            }
            score3 = String.valueOf(last_game.first_color_quantity);
            score4 = String.valueOf(last_game.second_color_quantity);
            next_game = "12v34";
        }
        else if (next_game.equals("12v34")){
            if(last_game.first_won){
                game12v34 = "12";
                player1234name = player12name;
            }
            else{
                game12v34 = "34";
                player1234name = player34name;
            }
            score12 = String.valueOf(last_game.first_color_quantity);
            score34 = String.valueOf(last_game.second_color_quantity);
            next_game = "END";
        }
    }
}
