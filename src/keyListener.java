import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

        switch (e.getKeyCode()) {
            case (87):  //w
            case (38):  //up
                System.out.println("up");

                break;

            case (65):  //a
            case (37):  //left
                System.out.println("left");
                break;

            case (83):  //s
            case (40):  //down
                System.out.println("down");
                break;

            case (68):  //d
            case (39):  //right
                System.out.println("right");
                break;
            default:
                System.out.println(e);                 // do nothing
        }
    }
}
