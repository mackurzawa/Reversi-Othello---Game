import javax.swing.*;
import java.awt.*;

public class GameSettings {
    Graphics2D g2 = Window.g2;
    AL action_listener = new AL();

    ButtonGroup mode_button_group;
    ButtonGroup board_size_button_group;
    ButtonGroup piece_color_button_group;

    static JRadioButton rb_1_vs_pc;
    static JRadioButton rb_1v1;
    static JRadioButton rb_tournament;

    static JRadioButton rb_6x6;
    static JRadioButton rb_8x8;
    static JRadioButton rb_10x10;

    static JRadioButton rb_BW;
    static JRadioButton rb_PP;

    static String current_mode;
    static String current_board_size;
    static String current_piece_color;

    static JButton lets_play_button;
    static JButton join_tournament_button;
    static JButton create_tournament_button;

    static boolean is_lets_play_button_pressed = false;

    public GameSettings(){

        current_mode = "1vPC";
        current_board_size = "8x8";
        current_piece_color = "BlackWhite";

        try{
            Thread.sleep(30);
        } catch (Exception e){
        }

        //Drawing Background

        g2.setColor(new Color(40, 40, 40));
        g2.fillRoundRect(Constants.screen_width/2 - Constants.game_settings_width/2, Constants.screen_height/4 + 50, Constants.game_settings_width, Constants.game_settings_height, 105, 105);
        g2.setColor(new Color(220, 220, 220));
        g2.fillRoundRect(Constants.screen_width/2 - Constants.game_settings_width/2 + 5, Constants.screen_height/4 + 50 + 5, Constants.game_settings_width - 10, Constants.game_settings_height - 10, 100, 100);

        //Drawing Modes Options
        drawingModes();

        //Drawing Board Size Options
        drawingBoardSize();

        //Drawing Piece Color Options
        drawingPieceColor();

        //DRAWING OK BUTTON
        drawingLetsPlayButton();

        while(!is_lets_play_button_pressed){

            g2.drawImage(Constants.black_white_piece,570, 570, Window.window);

            g2.drawImage(Constants.pink_purple_piece,780, 570, Window.window);
        }

//      Getting out of settings & preparing game
        is_lets_play_button_pressed = false;
        if(current_board_size.equals("6x6")){
            Constants.rows = 4;
            Constants.cols = 4;
        }
        else if(current_board_size.equals("8x8")){
            Constants.rows = 8;
            Constants.cols = 8;
        }
        else if(current_board_size.equals("10x10")){
            Constants.rows = 10;
            Constants.cols = 10;
        }
        Constants.tile_width = Constants.board_size/Constants.cols - 2*Constants.tile_border;
        Constants.tile_height = Constants.tile_width;
        Constants.piece_diameter = (int) (Constants.tile_width * 0.9);
        Constants.horizontal_padding = (Constants.screen_width - Constants.cols * (Constants.tile_width + 2*Constants.tile_border))/2;
        Constants.vertical_padding = (Constants.screen_height - Constants.rows * (Constants.tile_height + 2*Constants.tile_border))/2;

        if(current_piece_color.equals("BlackWhite")){
            Constants.first_piece = Constants.black_piece_color;
            Constants.second_piece = Constants.white_piece_color;
        }
        else if(current_piece_color.equals("PinkPurple")){
            Constants.first_piece = Constants.purple_piece_color;
            Constants.second_piece = Constants.pink_piece_color;
        }

        Constants.mode = current_mode;

        rb_1_vs_pc.setVisible(false);
        rb_1v1.setVisible(false);
        rb_tournament.setVisible(false);
        rb_6x6.setVisible(false);
        rb_8x8.setVisible(false);
        rb_10x10.setVisible(false);
        rb_BW.setVisible(false);
        rb_PP.setVisible(false);
        lets_play_button.setVisible(false);

//        if(current_mode.equals("tournament")){
//            ifTournament();
//        }
        /////////////////////////////////////////////////////////////////////////////
    }
    
    
    void drawingModes(){

        mode_button_group = new ButtonGroup();

        FontMetrics metrics = g2.getFontMetrics(Constants.mode_font);
        g2.setColor(Color.BLACK);
        g2.setFont(Constants.mode_font);
        g2.drawString(Constants.mode_text, Constants.screen_width/2 - metrics.stringWidth(Constants.mode_text)/2, Constants.screen_height/4 + 100);

        rb_1_vs_pc = new JRadioButton("Player vs PC", true);
        Window.window.add(rb_1_vs_pc);
        mode_button_group.add(rb_1_vs_pc);
        rb_1_vs_pc.setVerticalTextPosition(SwingConstants.TOP);
        rb_1_vs_pc.setHorizontalTextPosition(SwingConstants.CENTER);
        rb_1_vs_pc.setFocusable(false);
        rb_1_vs_pc.setBounds(485, 335, 150, 40);
        rb_1_vs_pc.setBackground(new Color(220, 220, 220));
        rb_1_vs_pc.addActionListener(action_listener);
        rb_1_vs_pc.setFont(Constants.options_font);

        metrics = g2.getFontMetrics(Constants.settings_font);
        g2.setFont(Constants.settings_font);

        rb_1v1 = new JRadioButton("Player vs Player", false);
        Window.window.add(rb_1v1);
        mode_button_group.add(rb_1v1);
        rb_1v1.setVerticalTextPosition(SwingConstants.TOP);
        rb_1v1.setHorizontalTextPosition(SwingConstants.CENTER);
        rb_1v1.setFocusable(false);
        rb_1v1.setBounds(643, 335, 170, 40);
        rb_1v1.setBackground(new Color(220, 220, 220));
        rb_1v1.addActionListener(action_listener);
        rb_1v1.setFont(Constants.options_font);

        rb_tournament = new JRadioButton("Tournament", false);
        Window.window.add(rb_tournament);
        mode_button_group.add(rb_tournament);
        rb_tournament.setVerticalTextPosition(SwingConstants.TOP);
        rb_tournament.setHorizontalTextPosition(SwingConstants.CENTER);
        rb_tournament.setFocusable(false);
        rb_tournament.setBounds(820, 335, 150, 40);
        rb_tournament.setBackground(new Color(220, 220, 220));
        rb_tournament.addActionListener(action_listener);
        rb_tournament.setFont(Constants.options_font);

    }

    void drawingBoardSize(){

        board_size_button_group = new ButtonGroup();

        FontMetrics metrics = g2.getFontMetrics(Constants.settings_font);

        g2.drawString(Constants.board_size_text, Constants.screen_width/2 - metrics.stringWidth(Constants.board_size_text)/2, Constants.screen_height/4 + 200);


        rb_6x6 = new JRadioButton("Small (6 x 6)", false);
        Window.window.add(rb_6x6);
        board_size_button_group.add(rb_6x6);
        rb_6x6.setVerticalTextPosition(SwingConstants.TOP);
        rb_6x6.setHorizontalTextPosition(SwingConstants.CENTER);
        rb_6x6.setFocusable(false);
        rb_6x6.setBounds(485, 430, 130, 40);
        rb_6x6.setBackground(new Color(220, 220, 220));
        rb_6x6.addActionListener(action_listener);
        rb_6x6.setFont(Constants.options_font);

        metrics = g2.getFontMetrics(Constants.settings_font);
        g2.setFont(Constants.settings_font);

        rb_8x8 = new JRadioButton("Standard (8 x 8)", true);
        Window.window.add(rb_8x8);
        board_size_button_group.add(rb_8x8);
        rb_8x8.setVerticalTextPosition(SwingConstants.TOP);
        rb_8x8.setHorizontalTextPosition(SwingConstants.CENTER);
        rb_8x8.setFocusable(false);
        rb_8x8.setBounds(642, 430, 140, 40);
        rb_8x8.setBackground(new Color(220, 220, 220));
        rb_8x8.addActionListener(action_listener);
        rb_8x8.setFont(Constants.options_font);

        rb_10x10 = new JRadioButton("Large (10 x 10)", false);
        Window.window.add(rb_10x10);
        board_size_button_group.add(rb_10x10);
        rb_10x10.setVerticalTextPosition(SwingConstants.TOP);
        rb_10x10.setHorizontalTextPosition(SwingConstants.CENTER);
        rb_10x10.setFocusable(false);
        rb_10x10.setBounds(815, 430, 130, 40);
        rb_10x10.setBackground(new Color(220, 220, 220));
        rb_10x10.addActionListener(action_listener);
        rb_10x10.setFont(Constants.options_font);
    }

    void drawingPieceColor(){

        piece_color_button_group = new ButtonGroup();

        FontMetrics metrics = g2.getFontMetrics(Constants.settings_font);

        g2.drawString(Constants.piece_color_text, Constants.screen_width/2 - metrics.stringWidth(Constants.piece_color_text)/2, Constants.screen_height/4 + 300);


        rb_BW = new JRadioButton("                      ", true);
        Window.window.add(rb_BW);
        piece_color_button_group.add(rb_BW);
        rb_BW.setVerticalTextPosition(SwingConstants.TOP);
        rb_BW.setHorizontalTextPosition(SwingConstants.CENTER);
        rb_BW.setFocusable(false);
        rb_BW.setBounds(552, 548, 120, 70);
        rb_BW.setBackground(new Color(220, 220, 220));
        rb_BW.addActionListener(action_listener);
        rb_BW.setFont(Constants.options_font);

        rb_PP = new JRadioButton("                      ", false);
        Window.window.add(rb_PP);
        piece_color_button_group.add(rb_PP);
        rb_PP.setVerticalTextPosition(SwingConstants.TOP);
        rb_PP.setHorizontalTextPosition(SwingConstants.CENTER);
        rb_PP.setFocusable(false);
        rb_PP.setBounds(760, 548, 128, 70);
        rb_PP.setBackground(new Color(220, 220, 220));
        rb_PP.addActionListener(action_listener);
        rb_PP.setFont(Constants.options_font);
    }

    void drawingLetsPlayButton(){
        lets_play_button = new JButton("Let's Play!");
        Window.window.add(lets_play_button);
        lets_play_button.setBounds(Constants.screen_width/2 - Constants.lets_play_button_width/2,630, Constants.lets_play_button_width, Constants.lets_play_button_height);
        lets_play_button.addActionListener(action_listener);
        lets_play_button.setBackground(Constants.button_color);
        lets_play_button.setFont(new Font("Calibri", Font.ITALIC, 40));
        lets_play_button.setForeground(Color.BLACK);
        lets_play_button.setBorder(BorderFactory.createEtchedBorder());
        lets_play_button.setFocusable(false);
        lets_play_button.setVisible(true);
    }

    void ifTournament(){

        try{
            Thread.sleep(30);
        } catch (Exception e){
        }


        g2.setColor(new Color(40, 40, 40));
        g2.fillRoundRect(Constants.screen_width/2 - Constants.game_settings_width/2, Constants.screen_height/4 + 50, Constants.game_settings_width, Constants.game_settings_height, 105, 105);
        g2.setColor(new Color(220, 220, 220));
        g2.fillRoundRect(Constants.screen_width/2 - Constants.game_settings_width/2 + 5, Constants.screen_height/4 + 50 + 5, Constants.game_settings_width - 10, Constants.game_settings_height - 10, 100, 100);

        new Tournament();
        new CreateTournament();

    }
}
