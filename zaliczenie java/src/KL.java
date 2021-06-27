import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KL implements KeyListener{

    private boolean key_pressed[] = new boolean[128];

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        key_pressed[keyEvent.getKeyCode()] = true;
//        System.out.println(keyEvent.getKeyCode());

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        key_pressed[keyEvent.getKeyCode()] = true;
    }

    public boolean isKeyPressed(int key_code){
        return key_pressed[key_code];
    }
}
