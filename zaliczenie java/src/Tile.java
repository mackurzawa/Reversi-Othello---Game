import java.awt.Color;
import java.awt.Graphics2D;

public class Tile implements Runnable{
    private int x, y;
    private Color color;
    private Piece piece;
    public boolean occupied = false;

    public Tile(int x, int y){
        this.x = x;
        this.y = y;
        this.color = Constants.tile_color;
        piece = new Piece();
    }

    public void DrawTile(Graphics2D g2){
        g2.setColor(color);
        g2.fillRect(this.x, this.y, Constants.tile_width, Constants.tile_height);
//        piece.Draw(g2, this.x, this.y);
    }

    public void DrawPiece(Graphics2D g2){
        piece.Draw(Window.g2, this.x, this.y);
        }

    public void changeOccupation(Color occupied_color){
        occupied = true;
        piece.changeOccupation(occupied_color, this.x, this.y);
    }


    public void run() {piece.Draw(Window.g2, this.x, this.y);}

    public Color returnPieceColor(){return piece.occupied_color;}


    public boolean checkPossibility(Color now_playing_color, int x, int y){
        boolean move_done = false;
        if(occupied == false) {
            // Sprawdzanie w dół
            int streak = 0;
            for (int i = 1; i <= y; i++) {
                if(Board.board_with_tiles[x][y - i].returnPieceColor() == Game.next_player){
                    streak++;
                }
                else if(Board.board_with_tiles[x][y - i].returnPieceColor() == now_playing_color && streak != 0){
                    for(int j = 0; j <= streak; j++){
                        move_done = true;
                        Board.board_with_tiles[x][y - j].changeOccupation(now_playing_color);
                    }
                    break;
                }
                else{
                    break;
                }
            }
            // Sprawdzanie w górę
            streak = 0;
            for (int i = 1; i <= Constants.rows - y - 1; i++) {
                if(Board.board_with_tiles[x][y + i].returnPieceColor() == Game.next_player){
                    streak++;
                }
                else if(Board.board_with_tiles[x][y + i].returnPieceColor() == now_playing_color && streak != 0){
                    for(int j = 0; j <= streak; j++){
                        move_done = true;
                        Board.board_with_tiles[x][y + j].changeOccupation(now_playing_color);
                    }
                    break;
                }
                else{
                    break;
                }
            }
            // Sprawdzanie w prawo
            streak = 0;
            for (int i = 1; i <= x; i++) {
                if(Board.board_with_tiles[x - i][y].returnPieceColor() == Game.next_player){
                    streak++;
                }
                else if(Board.board_with_tiles[x - i][y].returnPieceColor() == now_playing_color && streak != 0){
                    for(int j = 0; j <= streak; j++){
                        move_done = true;
                        Board.board_with_tiles[x - j][y].changeOccupation(now_playing_color);
                    }
                    break;
                }
                else{
                    break;
                }
            }
            // Sprawdzanie w lewo
            streak = 0;
            for (int i = 1; i <= Constants.cols - x - 1; i++) {
                if(Board.board_with_tiles[x + i][y].returnPieceColor() == Game.next_player){
                    streak++;
                }
                else if(Board.board_with_tiles[x + i][y].returnPieceColor() == now_playing_color && streak != 0){
                    for(int j = 0; j <= streak; j++){
                        move_done = true;
                        Board.board_with_tiles[x + j][y].changeOccupation(now_playing_color);
                    }
                    break;
                }
                else{
                    break;
                }
            }
            // Sprawdzanie w lewo w górę
            streak = 0;
            for (int i = 1; i <= Math.min(Constants.cols - x - 1, Constants.rows - y - 1); i++) {
                if(Board.board_with_tiles[x + i][y + i].returnPieceColor() == Game.next_player){
                    streak++;
                }
                else if(Board.board_with_tiles[x + i][y + i].returnPieceColor() == now_playing_color && streak != 0){
                    for(int j = 0; j <= streak; j++){
                        move_done = true;
                        Board.board_with_tiles[x + j][y + j].changeOccupation(now_playing_color);
                    }
                    break;
                }
                else{
                    break;
                }
            }
            // Sprawdzanie w lewo w dół
            streak = 0;
            for (int i = 1; i <= Math.min(Constants.cols - x - 1, y); i++) {
                if(Board.board_with_tiles[x + i][y - i].returnPieceColor() == Game.next_player){
                    streak++;
                }
                else if(Board.board_with_tiles[x + i][y - i].returnPieceColor() == now_playing_color && streak != 0){
                    for(int j = 0; j <= streak; j++){
                        move_done = true;
                        Board.board_with_tiles[x + j][y - j].changeOccupation(now_playing_color);
                    }
                    break;
                }
                else{
                    break;
                }
            }
            // Sprawdzanie w prawo w dół
            streak = 0;
            for (int i = 1; i <= Math.min(x, y); i++) {
                if(Board.board_with_tiles[x - i][y - i].returnPieceColor() == Game.next_player){
                    streak++;
                }
                else if(Board.board_with_tiles[x - i][y - i].returnPieceColor() == now_playing_color && streak != 0){
                    for(int j = 0; j <= streak; j++){
                        move_done = true;
                        Board.board_with_tiles[x - j][y - j].changeOccupation(now_playing_color);
                    }
                    break;
                }
                else{
                    break;
                }
            }
            // Sprawdzanie w prawo w górę
            streak = 0;
            for (int i = 1; i <= Math.min(x, Constants.rows - y - 1); i++) {
                if(Board.board_with_tiles[x - i][y + i].returnPieceColor() == Game.next_player){
                    streak++;
                }
                else if(Board.board_with_tiles[x - i][y + i].returnPieceColor() == now_playing_color && streak != 0){
                    for(int j = 0; j <= streak; j++){
                        move_done = true;
                        Board.board_with_tiles[x - j][y + j].changeOccupation(now_playing_color);
                    }
                    break;
                }
                else{
                    break;
                }
            }
        }
        if(move_done){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean checkMovePossibility(Color now_playing_color, int x, int y){
        boolean move_done = false;
        if(occupied == false) {
            // Sprawdzanie w dół
            int streak = 0;
            for (int i = 1; i <= y; i++) {
                if(Board.board_with_tiles[x][y - i].returnPieceColor() == Game.next_player){
                    streak++;
                }
                else if(Board.board_with_tiles[x][y - i].returnPieceColor() == now_playing_color && streak != 0){
                    for(int j = 0; j <= streak; j++){
                        move_done = true;
                    }
                    break;
                }
                else{
                    break;
                }
            }
            // Sprawdzanie w górę
            streak = 0;
            for (int i = 1; i <= Constants.rows - y - 1; i++) {
                if(Board.board_with_tiles[x][y + i].returnPieceColor() == Game.next_player){
                    streak++;
                }
                else if(Board.board_with_tiles[x][y + i].returnPieceColor() == now_playing_color && streak != 0){
                    for(int j = 0; j <= streak; j++){
                        move_done = true;
                    }
                    break;
                }
                else{
                    break;
                }
            }
            // Sprawdzanie w prawo
            streak = 0;
            for (int i = 1; i <= x; i++) {
                if(Board.board_with_tiles[x - i][y].returnPieceColor() == Game.next_player){
                    streak++;
                }
                else if(Board.board_with_tiles[x - i][y].returnPieceColor() == now_playing_color && streak != 0){
                    for(int j = 0; j <= streak; j++){
                        move_done = true;
                    }
                    break;
                }
                else{
                    break;
                }
            }
            // Sprawdzanie w lewo
            streak = 0;
            for (int i = 1; i <= Constants.cols - x - 1; i++) {
                if(Board.board_with_tiles[x + i][y].returnPieceColor() == Game.next_player){
                    streak++;
                }
                else if(Board.board_with_tiles[x + i][y].returnPieceColor() == now_playing_color && streak != 0){
                    for(int j = 0; j <= streak; j++){
                        move_done = true;
                    }
                    break;
                }
                else{
                    break;
                }
            }
            // Sprawdzanie w lewo w górę
            streak = 0;
            for (int i = 1; i <= Math.min(Constants.cols - x - 1, Constants.rows - y - 1); i++) {
                if(Board.board_with_tiles[x + i][y + i].returnPieceColor() == Game.next_player){
                    streak++;
                }
                else if(Board.board_with_tiles[x + i][y + i].returnPieceColor() == now_playing_color && streak != 0){
                    for(int j = 0; j <= streak; j++){
                        move_done = true;
                    }
                    break;
                }
                else{
                    break;
                }
            }
            // Sprawdzanie w lewo w dół
            streak = 0;
            for (int i = 1; i <= Math.min(Constants.cols - x - 1, y); i++) {
                if(Board.board_with_tiles[x + i][y - i].returnPieceColor() == Game.next_player){
                    streak++;
                }
                else if(Board.board_with_tiles[x + i][y - i].returnPieceColor() == now_playing_color && streak != 0){
                    for(int j = 0; j <= streak; j++){
                        move_done = true;
                    }
                    break;
                }
                else{
                    break;
                }
            }
            // Sprawdzanie w prawo w dół
            streak = 0;
            for (int i = 1; i <= Math.min(x, y); i++) {
                if(Board.board_with_tiles[x - i][y - i].returnPieceColor() == Game.next_player){
                    streak++;
                }
                else if(Board.board_with_tiles[x - i][y - i].returnPieceColor() == now_playing_color && streak != 0){
                    for(int j = 0; j <= streak; j++){
                        move_done = true;
                    }
                    break;
                }
                else{
                    break;
                }
            }
            // Sprawdzanie w prawo w górę
            streak = 0;
            for (int i = 1; i <= Math.min(x, Constants.rows - y - 1); i++) {
                if(Board.board_with_tiles[x - i][y + i].returnPieceColor() == Game.next_player){
                    streak++;
                }
                else if(Board.board_with_tiles[x - i][y + i].returnPieceColor() == now_playing_color && streak != 0){
                    for(int j = 0; j <= streak; j++){
                        move_done = true;
                    }
                    break;
                }
                else{
                    break;
                }
            }
        }
        if(move_done){
            return true;
        }
        else{
            return false;
        }
    }
}


