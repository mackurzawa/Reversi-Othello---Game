import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Menu{

    static Graphics2D g2 = Window.g2;
    KL key_listener = Window.key_listener;
    ML mouse_listener = Window.mouse_listener;
    static int menu_option = 0;
    NewGame new_game;
    HowToPlay how_to_play;
    Statistics statistics_button;
    Exit exit_button;
    SignInButton sign_in_button;
    SignUpButton sign_up_button;

    static String username = "";
    static String games_won = "";
    static String games_played = "";
    static Game last_game;
    static Tournament last_tournament;

    public Menu(){

        new_game = new NewGame();
        how_to_play = new HowToPlay();
        statistics_button = new Statistics();
        exit_button = new Exit();
        sign_in_button = new SignInButton();
        sign_up_button = new SignUpButton();
        drawingMenu();

        run();
    }

    public void drawingMenu(){
        g2.drawImage(Constants.background_board, 0, 0, Window.window);
        FontMetrics metrics = g2.getFontMetrics(Constants.title_font);

//        Drawing Background
        g2.setColor(new Color(40, 40, 40));
        g2.fillRoundRect(Constants.screen_width/2 - metrics.stringWidth(Constants.title_text)/2 - 15, Constants.screen_height/4 - 150 - 5, metrics.stringWidth(Constants.title_text) + 20, 200, 105, 105);
        g2.setColor(new Color(220, 220, 220));
        g2.fillRoundRect(Constants.screen_width/2 - metrics.stringWidth(Constants.title_text)/2 - 10, Constants.screen_height/4 - 150, metrics.stringWidth(Constants.title_text) + 10, 190, 100, 100);


        // Drawing Title
        g2.setColor(Color.BLACK);
        g2.setFont(Constants.title_font);
        g2.drawString(Constants.title_text, Constants.screen_width/2 - metrics.stringWidth(Constants.title_text)/2, Constants.screen_height/4);



    }

    public static void drawingBottomLogin(){
        FontMetrics metrics = Window.g2.getFontMetrics(Constants.user_font);
        Window.g2.setFont(Constants.user_font);
        Window.g2.setColor(new Color(0,0,0));
        Window.g2.fillRect(0, Constants.screen_height - 50, Constants.screen_width, 50);
        Window.g2.setColor(new Color(240,240,240));
        Window.g2.drawString("Logged as " + username, Constants.screen_width/2 - metrics.stringWidth("Logged as " + username)/2, Constants.screen_height - 20);


    }

    public static void optionNumber(int option_number){
        if(option_number == 1) {
            if (username == "") {
                JOptionPane.showMessageDialog(Window.window, "Log in first! You can't play as a noname!", "Log in first!", JOptionPane.WARNING_MESSAGE);
            } else {
                menu_option = 1;
            }
        }
        else if(option_number == 2){
            drawHowToPlay();
        }
        else if(option_number == 3){
            drawStatistics();
        }
        else if(option_number == 4){
            saveUser();
            System.exit(0);
        }else if(option_number == 5){
            new SignUpWindow();
        }
        else if(option_number == 6){
            new SignInWindow();
        }
    }

    public void update(){
//        drawingMenu();
    }


    public void run() {

        while(true){
            update();
            if(menu_option == 1){
                NewGame.new_game_button.setVisible(false);
                HowToPlay.how_to_play_button.setVisible(false);
                Statistics.statistics_button.setVisible(false);

                GameSettings game_settings = new GameSettings();

                try{
                    Thread.sleep(30);
                } catch (Exception e){
                }

                if(Constants.mode.equals("tournament")){
                    last_tournament = new Tournament();
                }
                else if(Constants.mode.equals("1vPC")){
                    SignInButton.sign_in_button.setVisible(false);
                    SignUpButton.sign_up_button.setVisible(false);
                    Exit.exit_button.setVisible(false);
                    try{
                        Thread.sleep(60);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    last_game = new Game(username, "AI");
                    if(last_game.first_won){
                        games_won = String.valueOf(Integer.parseInt(games_won) + 1);
                    }
                    games_played = String.valueOf(Integer.parseInt(games_played) + 1);
                }
                else if(Constants.mode.equals("1v1")){
                    SignInButton.sign_in_button.setVisible(false);
                    SignUpButton.sign_up_button.setVisible(false);
                    Exit.exit_button.setVisible(false);
                    try{
                        Thread.sleep(60);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    last_game = new Game(username, "Guest");
                    if(last_game.first_won){
                        games_won = String.valueOf(Integer.parseInt(games_won) + 1);
                    }
                    games_played = String.valueOf(Integer.parseInt(games_played) + 1);
                }

                // Comin Back
                drawingMenu();
                drawingBottomLogin();
                try{
                    Thread.sleep(100);
                } catch (Exception e){
                }
                NewGame.new_game_button.setVisible(true);
                try{
                    Thread.sleep(100);
                } catch (Exception e){
                }
                HowToPlay.how_to_play_button.setVisible(true);
                try{
                    Thread.sleep(100);
                } catch (Exception e){
                }
                Statistics.statistics_button.setVisible(true);
                try{
                    Thread.sleep(100);
                } catch (Exception e){
                }
                Exit.exit_button.setVisible(true);
                try{
                    Thread.sleep(100);
                } catch (Exception e){
                }
                SignUpButton.sign_up_button.setVisible(true);
                try{
                    Thread.sleep(100);
                } catch (Exception e){
                }
                SignInButton.sign_in_button.setVisible(true);
                try{
                    Thread.sleep(100);
                } catch (Exception e){
                }


                menu_option = 0;
            }
            try{
                Thread.sleep(30);
            } catch (Exception e){
            }
        }
    }

    static void drawStatistics(){
        FontMetrics metrics;
        for(int i = 0; i < 400; i+=2){
            g2.setColor(Constants.black_piece_color);
            g2.fillRoundRect(Constants.screen_width - i, 300, 400, 400, 20, 20);

            g2.setColor(Constants.white_piece_color);
            g2.fillRoundRect(Constants.screen_width - i + 10, 310, 400, 380, 20, 20);


            metrics = Window.g2.getFontMetrics(Constants.mode_font);
            g2.setFont(Constants.mode_font);
            g2.setColor(Constants.black_piece_color);
            g2.drawString(username, Constants.screen_width + 200 - i - metrics.stringWidth(username)/2, 400);


            metrics = Window.g2.getFontMetrics(Constants.settings_font);
            g2.setFont(Constants.settings_font);
            g2.setColor(Constants.black_piece_color);
            g2.drawString("Games won: " + games_won, Constants.screen_width + 200 - i - metrics.stringWidth("Games won: " + games_won)/2, 500);

            g2.setColor(Constants.black_piece_color);
            g2.drawString("Games played: " + games_played, Constants.screen_width + 200 - i - metrics.stringWidth("Games won: " + games_played)/2, 580);

            try{
                Thread.sleep(5);
            } catch (Exception e){
            }
        }
    }

    static void drawHowToPlay(){
        FontMetrics metrics;
        for(int i = 0; i < 450; i+=2){
            g2.setColor(Constants.black_piece_color);
            g2.fillRoundRect(-450 + i, 300, 450, 400, 20, 20);

            g2.setColor(Constants.white_piece_color);
            g2.fillRoundRect(-450 + i - 10, 310, 450, 380, 20, 20);


            metrics = Window.g2.getFontMetrics(Constants.mode_font);
            g2.setFont(Constants.mode_font);
            g2.setColor(Constants.black_piece_color);
            g2.drawString("How To Play", - 225 + i - metrics.stringWidth("How To Play")/2, 400);


            metrics = Window.g2.getFontMetrics(Constants.tournament_users_font);
            g2.setFont(Constants.tournament_users_font);
            g2.drawString(Constants.how_to_play_text1, - 225 + i - metrics.stringWidth(Constants.how_to_play_text1)/2, 500);
            g2.drawString(Constants.how_to_play_text2, - 225 + i - metrics.stringWidth(Constants.how_to_play_text2)/2, 530);
            g2.drawString(Constants.how_to_play_text3, - 225 + i - metrics.stringWidth(Constants.how_to_play_text3)/2, 560);
            g2.drawString(Constants.how_to_play_text4, - 225 + i - metrics.stringWidth(Constants.how_to_play_text4)/2, 590);

            try{
                Thread.sleep(5);
            } catch (Exception e){
            }
        }
    }

    static void saveUser(){

        String temp = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Users.txt"));
            String line = reader.readLine();

            while(line != null){
                if(line.equals(username)){
                    temp = temp + line + "\n"; //Name
                    line = reader.readLine();
                    temp = temp + line + "\n"; // Password
                    line = reader.readLine();
                    temp = temp + games_won + "\n"; // Games Won
                    line = reader.readLine();
                    temp = temp + games_played + "\n"; // Games Played
                }
                else{
                    temp = temp + line + "\n"; //Name
                    line = reader.readLine();
                    temp = temp + line + "\n"; // Password
                    line = reader.readLine();
                    temp = temp + line + "\n"; // Games Won
                    line = reader.readLine();
                    temp = temp + line + "\n"; // Games Played
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
            writer = new BufferedWriter(new FileWriter("Users.txt", false));
            writer.write(temp);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
