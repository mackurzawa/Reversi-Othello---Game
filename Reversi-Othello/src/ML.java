import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;

public class ML extends MouseAdapter implements MouseMotionListener {
    public boolean is_pressed = false;
    public double x = 0.0, y = 0.0;

    @Override
    public void mousePressed(MouseEvent e) {
        is_pressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        is_pressed = false;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.x = e.getX();
        this.y = e.getY();
    }

    public double getMouseX() {return this.x;}
    public double getMouseY() {return this.y;}

    public boolean isMousePressed() {return is_pressed;}

}
