import java.awt.Graphics2D;
import java.awt.Color;

public class Piece{
    public Color occupied_color = Constants.tile_color;
    private Color last_occupied_color = Constants.tile_color;


    public void Draw(Graphics2D g2, int x, int y){
        if(last_occupied_color != occupied_color) {
            // rl- red last, gl - green last, bl - blue last
            double rl = last_occupied_color.getRed(), gl = last_occupied_color.getGreen(), bl = last_occupied_color.getBlue();
            // rn - red now, gl - green now, bl - blue now
            double rn = occupied_color.getRed(), gn = occupied_color.getGreen(), bn = occupied_color.getBlue();
            double rln = (rn - rl)/Constants.color_dif_in_frames, gln = (gn - gl)/Constants.color_dif_in_frames, bln = (bn - bl)/Constants.color_dif_in_frames;
            for(int i = 0; i<Constants.color_dif_in_frames; i++){
                if(rl < rn){
                    rl += rln;
                    if(rl > rn){
                        rl = rn;
                    }
                }
                if(rl > rn){
                    rl+= rln;
                    if(rl < rn){
                        rl = rn;
                    }
                }
                if(gl < gn){
                    gl += gln;
                    if(gl > gn){
                        gl = gn;
                    }
                }
                if(gl > gn){
                    gl += gln;
                    if(gl < gn){
                        gl = gn;
                    }
                }
                if(bl < bn){
                    bl += bln;
                    if(bl > bn){
                        bl = bn;
                    }
                }
                if(bl > bn){
                    bl += bln;
                    if(bl < bn){
                        bl = bn;
                    }
                }
                g2.setColor(new Color((int)rl, (int)gl, (int)bl));
                g2.fillOval(x + (Constants.tile_width - Constants.piece_diameter)/2, y + (Constants.tile_width - Constants.piece_diameter)/2, Constants.piece_diameter, Constants.piece_diameter);

                try{
                    Thread.sleep(1);
                } catch (Exception e){
                }

            }
            last_occupied_color = occupied_color;
        }
 //        this.Draw(Game.g2, x, y, occupied_color);

    }

    public void changeOccupation(Color occupied_color, int x, int y){
        last_occupied_color = this.occupied_color;
        this.occupied_color = occupied_color;
        while(!Constants.semaphore){
//            try{
//                Thread.sleep(30);
//            } catch (Exception e){
//            }
        }
        Constants.semaphore = false;
        this.Draw(Game.g2, x, y);
        Constants.semaphore = true;
    }
}
