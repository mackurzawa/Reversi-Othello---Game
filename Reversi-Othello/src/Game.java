import java.awt.Graphics2D;
import java.awt.Color;

public class Game{

    public static Graphics2D g2 = Window.g2;
    KL key_listener = Window.key_listener;
    ML mouse_listener = Window.mouse_listener;
    Board board;
    public static Color first_color;
    public static Color second_color;
    public static Color now_playing_player;
    public static Color next_player;

    public static String mode;
    public static String first_username;
    public static String second_username;

    public static boolean first_won;
    public static boolean second_won;

    public static int first_color_quantity;
    public static int second_color_quantity;
    int quantity_occupied = 4;

    public static boolean running;

    public Game(String name1, String name2){
        first_username = name1;
        second_username = name2;
        first_color = Constants.first_piece;
        second_color = Constants.second_piece;
        first_color_quantity = 0;
        second_color_quantity = 0;
        now_playing_player = first_color;
        next_player = second_color;
        mode = Constants.mode;


        g2.drawImage(Constants.background_wood, 0, 0, Window.window);
        board = new Board();
        running = true;
        run();
    }

    public void update(){
//        Sprawdzanie czy ruch jest możliwy
        boolean can_make_move = false;
        for(int i = 0; i < Constants.rows; i++){
            for(int j = 0; j < Constants.cols; j++){
                if(Board.board_with_tiles[i][j].checkMovePossibility(now_playing_player, i, j)){
                    can_make_move = true;
                }
            }
        }
        if(can_make_move) {
            // Sprawdzanie nacisniecia
            if (mouse_listener.isMousePressed()) {
                double x = mouse_listener.getMouseX(), y = mouse_listener.getMouseY();
                for (int i = 0; i < Constants.rows; i++) {
                    for (int j = 0; j < Constants.cols; j++) {
                        if (i * (Constants.tile_height + 2 * Constants.tile_border) + Constants.horizontal_padding <= x && x < (i + 1) * (Constants.tile_height + 2 * Constants.tile_border) + Constants.horizontal_padding) {
                            if (j * (Constants.tile_width + 2 * Constants.tile_border) + Constants.vertical_padding <= y && y < (j + 1) * (Constants.tile_width + 2 * Constants.tile_border) + Constants.vertical_padding) {
                                if (Board.board_with_tiles[i][j].checkPossibility(now_playing_player, i, j)) {

                                    if (now_playing_player == first_color) {
                                        now_playing_player = second_color;
                                        next_player = first_color;
                                    } else if (now_playing_player == second_color) {
                                        now_playing_player = first_color;
                                        next_player = second_color;
                                    }
                                    quantity_occupied++;
                                    howMany();
                                    PointsBar.check = true;
                                    try{
                                        Thread.sleep(60);
                                    } catch (Exception e){
                                        e.printStackTrace();
                                    }
                                    Scores.check = true;
                                    try{
                                        Thread.sleep(60);
                                    } catch (Exception e){
                                        e.printStackTrace();
                                    }
                                    if (quantity_occupied == Constants.rows * Constants.cols) {
                                        System.out.println("KONIEC1!");
                                        new EndGameWindow();
                                    }
//                                Board.board_with_tiles[i][j].DrawPiece(g2);
                                    if(mode.equals("1vPC")){
                                        boolean move_done = false;
                                        for(int g = 0; g < Constants.rows; g++){
                                            for(int h = 0; h < Constants.cols; h++){
                                                if(Board.board_with_tiles[g][h].checkMovePossibility(now_playing_player, g, h) && !move_done){
                                                    move_done = true;
                                                    Board.board_with_tiles[g][h].checkPossibility(now_playing_player, g, h);
                                                    if (now_playing_player == first_color) {
                                                        now_playing_player = second_color;
                                                        next_player = first_color;
                                                    } else if (now_playing_player == second_color) {
                                                        now_playing_player = first_color;
                                                        next_player = second_color;
                                                    }
                                                    quantity_occupied++;
                                                    howMany();
                                                    PointsBar.check = true;
                                                    try{
                                                        Thread.sleep(60);
                                                    } catch (Exception e){
                                                        e.printStackTrace();
                                                    }
                                                    Scores.check = true;
                                                    try{
                                                        Thread.sleep(60);
                                                    } catch (Exception e){
                                                        e.printStackTrace();
                                                    }
                                                    if (quantity_occupied == Constants.rows * Constants.cols) {
                                                        System.out.println("KONIEC2!");
                                                        new EndGameWindow();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        else{
            System.out.println("KONIEC3!");
            new EndGameWindow();
        }




    }

    public double showTime(double last_frame_time){
        double now = Time.getTime();
        double delta_time = now - last_frame_time;
        System.out.println("FPS: " + 1/delta_time);
        return now;
    }


    public void run() {
        double last_frame_time = Time.getTime();
//        new EndGameWindow();
        howMany();

        PointsBar points_bar = new PointsBar();
        Thread t2 = new Thread(points_bar);
        t2.start();

        Scores scores = new Scores();
        Thread t3 = new Thread(scores);
        t3.start();

        NamesDuringGame names_during_game = new NamesDuringGame();
        Thread t4 = new Thread(names_during_game);
        t4.start();

        while(running){
//            last_frame_time = showTime(last_frame_time);
            update();
            try{
                Thread.sleep(30);
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        if(first_color_quantity > second_color_quantity){
            first_won = true;
            second_won = false;
        }
        else {
            first_won = false;
            second_won = true;
        }
    }

    public void howMany(){
        int first_color_quantity_temp = 0;
        int second_color_quantity_temp = 0;
        for(int i = 0; i < Constants.rows; i++){
            for(int j = 0; j < Constants.cols; j++){
                if(Board.board_with_tiles[i][j].returnPieceColor() == first_color){
                    first_color_quantity_temp++;
                }
                else if(Board.board_with_tiles[i][j].returnPieceColor() == second_color){
                    second_color_quantity_temp++;
                }
            }
        }
        first_color_quantity = first_color_quantity_temp;
        second_color_quantity = second_color_quantity_temp;

    }
}
