import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AL implements ActionListener{
    @Override

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == NewGame.new_game_button){
            Menu.optionNumber(1);
        }
        else if(e.getSource() == HowToPlay.how_to_play_button){
            Menu.optionNumber(2);
        }
        else if(e.getSource() == Statistics.statistics_button){
            Menu.optionNumber(3);
        }
        else if(e.getSource() == Exit.exit_button){
            Menu.optionNumber(4);
        }
        else if(e.getSource() == SignUpButton.sign_up_button){
            Menu.optionNumber(5);
        }
        else if(e.getSource() == SignInButton.sign_in_button){
            Menu.optionNumber(6);
        }
        else if(e.getSource() == BackToMenuButton.back_to_menu_button){
            BackToMenuButton.stopRunning();
        }
        else if(e.getSource() == GameSettings.rb_1_vs_pc){
            GameSettings.current_mode = "1vPC";
//            Constants.first_player = Menu.username;
//            Constants.second_player = "AI";
        }
        else if(e.getSource() == GameSettings.rb_1v1){
            GameSettings.current_mode = "1v1";
//            Constants.first_player = Menu.username;
//            Constants.second_player = "Guest";
        }
        else if(e.getSource() == GameSettings.rb_tournament){
            GameSettings.current_mode = "tournament";
        }
        else if(e.getSource() == GameSettings.rb_6x6){
            GameSettings.current_board_size = "6x6";
        }
        else if(e.getSource() == GameSettings.rb_8x8){
            GameSettings.current_board_size = "8x8";
        }
        else if(e.getSource() == GameSettings.rb_10x10){
            GameSettings.current_board_size = "10x10";
        }
        else if(e.getSource() == GameSettings.rb_BW){
            GameSettings.current_piece_color = "BlackWhite";
        }
        else if(e.getSource() == GameSettings.rb_PP){
            GameSettings.current_piece_color = "PinkPurple";
        }
        else if(e.getSource() == GameSettings.lets_play_button){
            GameSettings.is_lets_play_button_pressed = true;
        }
        else if(e.getSource() == Tournament.save_tournament_button){
            System.out.println(4);
            Tournament.save_tournament = true;
        }
        else if(e.getSource() == Tournament.next_game_button){

            System.out.println(3);
            Tournament.start_next_game = true;
        }
    }
}
