public class Main {
    public static void main(String[] args){

        Window window = new Window();
        Thread t1 = new Thread(window);
        t1.start();

//        SignInWindow sign_in_window = new SignInWindow();
//        Thread t2 = new Thread(sign_in_window);
//        t2.start();


    }
}