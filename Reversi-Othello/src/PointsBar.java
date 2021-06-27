import java.awt.Graphics2D;
import java.awt.Color;

public class PointsBar implements Runnable{
    Graphics2D g2 = Window.g2;
    public static boolean running;
    public static boolean check;
    public int bar_width = Constants.board_size;
    public int bar_height = Constants.tile_height/3;
    public int x = (Constants.screen_width - bar_width)/2;
    public int y = Constants.vertical_padding + Constants.board_size + Constants.board_border + 5;
    public int all_tiles;

    public PointsBar(){
        running = true;
        check = true;
    }
    public void run() {
        while(running){
            if(check) {
                while(!Constants.semaphore){

                }
                Constants.semaphore = false;
                all_tiles = Game.first_color_quantity + Game.second_color_quantity;
//            System.out.println("Powinienem pokazac pasek " + Game.first_color_quantity * bar_width/ all_tiles  + " " + Game.second_color_quantity * bar_width/ all_tiles );
                g2.setColor(Game.first_color);
                g2.fillRect(x, y, Game.first_color_quantity * bar_width / all_tiles, bar_height);
                g2.setColor(Game.second_color);
                g2.fillRect(x + Game.first_color_quantity * bar_width / all_tiles, y, Game.second_color_quantity * bar_width / all_tiles, bar_height);
                Constants.semaphore = true;
                check = false;
            }
            try {
                Thread.sleep(60);
            } catch (Exception e) {
                e.printStackTrace();
            }
//            System.out.println(123);
        }
    }

    public static void stop(){
        running = false;
    }
}
