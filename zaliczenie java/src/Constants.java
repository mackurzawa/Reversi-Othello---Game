import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class Constants {
    // SIGN IN SCREEN
    public static final int sign_in_screen_width = 600;
    public static final int sign_in_screen_height = 400;
    public static final String sign_in_title = "Sign in";
    // SCREEN
    public static final int screen_width = 1440;
    public static final int screen_height = 960;
    public static final String screen_title = "Reversi (Othello) - Made by mKurzawa";

    // IMAGES
    public static ImageIcon logo = new ImageIcon("Logo.PNG");
    public static Image background_wood;
    static {
        try {
            background_wood = ImageIO.read(new File("Wood.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Image background_board;
    static {
        try {
            background_board = ImageIO.read(new File("board.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // MENU
    public static final Font title_font = new Font("Calibri",Font.PLAIN, 200);
    public static final String title_text = "Reversi";

    public static final Font user_font = new Font("Calibri", Font.PLAIN, 30);

    public static final int new_game_button_width = screen_width/3;
    public static final int new_game_button_height = screen_height/6;

    public static final int how_to_play_button_width = screen_width/5;
    public static final int how_to_play_button_height = screen_height/10;

    public static final int statistics_button_width = screen_width/5;
    public static final int statistics_button_height = screen_height/10;

    public static final int exit_button_width = screen_width/5;
    public static final int exit_button_height = screen_height/10;

    public static final int sign_in_button_width = screen_width/5;
    public static final int sign_in_button_height = screen_height/10;

    public static final int sign_up_button_width = screen_width/5;
    public static final int sign_up_button_height = screen_height/10;

    public static final Color button_color = new Color(128, 90, 70);

    public static final int dif_bet_buttons = 20;

    public static final String how_to_play_text1 = "Main objective is to have more";
    public static final String how_to_play_text2 = "pieces on board than your";
    public static final String how_to_play_text3 = "opponent. Rest you're gonna learn";
    public static final String how_to_play_text4 = "from playing ;)";

    //GAME SETTINGS
    public static final int game_settings_width = 600;
    public static final int game_settings_height = 470;


    public static final Font settings_font = new Font("Calibri",Font.PLAIN, 40);
    public static final Font mode_font = new Font("Calibri",Font.BOLD, 50);
    public static final Font options_font = new Font("Calibri",Font.PLAIN, 20);
    public static final String piece_color_text = "Choose piece color:";
    public static final String board_size_text = "Choose board size:";
    public static final String mode_text = "Choose mode:";
    public static final int lets_play_button_width = 300;
    public static final int lets_play_button_height = 80;



    public static Image black_white_piece;
    static {
        try {
            black_white_piece = ImageIO.read(new File("BlackWhitePiece.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Image pink_purple_piece;
    static {
        try {
            pink_purple_piece = ImageIO.read(new File("PinkPurplePiece.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static final int join_tournament_button_width = 300;
    public static final int join_tournament_button_height = 80;

    // TOURNAMENT
    public static final Font tournament_font = new Font("Calibri",Font.PLAIN, 150);
    public static final Font tournament_name_font = new Font("Calibri",Font.PLAIN, 80);
    public static final Font tournament_users_font = new Font("Calibri",Font.PLAIN, 26);
    public static int name_tile_width = screen_width/9;
    public static int name_tile_height = 50;
    public static final int next_game_button_width = 300;
    public static final int next_game_button_height = 100;



    // GAME
    public static int rows;
    public static int cols;

    public static boolean semaphore = true;

    public static final int board_border = 15;
    public static final int board_size = screen_height - 200;

    public static final int tile_border = 1;
    public static int tile_width;
    public static int tile_height;
    public static final Color tile_color = new Color(0, 100, 0);

    public static String mode;

    public static int piece_diameter;
    public static final Color white_piece_color = new Color(200, 200, 200);
    public static final Color black_piece_color = new Color(50, 50, 50);
    public static final Color pink_piece_color = new Color(255, 194, 221);
    public static final Color purple_piece_color = new Color(143, 53, 144);

    public static Color first_piece;
    public static Color second_piece;


    public static final int color_dif_in_frames = 200;

    public static int horizontal_padding;
    public static int vertical_padding;

    public static String first_player;
    public static String second_player;

    // SCORES DURING GAME
    public static final int score_height = 120;
    public static final int score_padding = 50;

    public static final Font score_font = new Font("Calibri", Font.PLAIN, 130);

    // NAMES DURING GAME
    public static final Font names_font = new Font("Calibri", Font.PLAIN, 40);


    // GAME END WINDOW
    public static final int end_game_width = (int) (0.7 * screen_width);
    public static final int end_game_height = (int) (0.7 * screen_height);
    public static final int end_game_window_radius = 60;

    public static final Font end_game_font = new Font("Calibri",Font.BOLD, 150);
    public static final Font end_game_username_font = new Font("Calibri",Font.PLAIN, 150);
    public static final String end_game_title = "Winner!";

    public static Image golden_cup; // 146 x 191
    static {
        try {
            golden_cup = ImageIO.read(new File("GoldenCup.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Image silver_cup; // 105 x 140
    static {
        try {
            silver_cup = ImageIO.read(new File("SilverCup.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Image confetti;
    static {
        try {
            confetti = ImageIO.read(new File("Confetti.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
