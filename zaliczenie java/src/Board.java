import java.awt.*;

public class Board{
    public static Tile[][] board_with_tiles;
    Graphics2D g2 = Window.g2;

    public Board(){
//        Tworzenie planszy
        board_with_tiles = new Tile[Constants.rows][Constants.cols];
        for(int i = 0; i < Constants.rows; i++){
            for(int j = 0; j < Constants.cols; j++){
                board_with_tiles[i][j] = new Tile(i * (Constants.tile_height + 2 * Constants.tile_border) + Constants.tile_border + Constants.horizontal_padding, j * (Constants.tile_width + 2 * Constants.tile_border) + Constants.tile_border + Constants.vertical_padding);
            }
        }

        //Rysowanie szachownicy
        g2.setColor(Color.BLACK);
        g2.fillRect(Constants.horizontal_padding - Constants.board_border, Constants.vertical_padding - Constants.board_border, Constants.board_size + 2 * Constants.board_border, Constants.board_size + 2 * Constants.board_border);
        for(int i = 0; i < Constants.rows; i++){
            for(int j = 0; j < Constants.cols; j++){
                board_with_tiles[i][j].DrawTile(g2);
            }
        }
        board_with_tiles[Constants.rows/2 - 1][Constants.cols/2 - 1].changeOccupation(Game.second_color);
        board_with_tiles[Constants.rows/2][Constants.cols/2 - 1].changeOccupation(Game.first_color);
        board_with_tiles[Constants.rows/2 - 1][Constants.cols/2].changeOccupation(Game.first_color);
        board_with_tiles[Constants.rows/2][Constants.cols/2].changeOccupation(Game.second_color);
    }
}
