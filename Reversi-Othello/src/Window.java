import javax.swing.JFrame;
import java.awt.Graphics2D;
import java.awt.Color;

public class Window extends JFrame implements Runnable{

    public static Graphics2D g2;
    public static KL key_listener = new KL();
    public static ML mouse_listener = new ML();
    public static JFrame window = new JFrame();

    public Window(){
        window.setSize(Constants.screen_width, Constants.screen_height);
        window.setTitle(Constants.screen_title);
        window.setResizable(false);
        window.setVisible(true);
        window.setLayout(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.addKeyListener(key_listener);
        window.addMouseListener(mouse_listener);
        window.addMouseMotionListener(mouse_listener);
        window.getContentPane().setBackground(Color.BLACK);
        window.setIconImage(Constants.logo.getImage());
        g2 = (Graphics2D)window.getGraphics();
    }

    public void update(){
    }


    public void run() {

//        Game new_game = new Game();
        Menu new_menu = new Menu();
//        while(true){
//
//            try{
//                Thread.sleep(15);
//            } catch (Exception e){
//            }
//        }
    }


}
