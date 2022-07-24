import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gui {
    private final double aspectRatio = (16.0 / 9.0);
    private ScorePanel score;
    private Game game;
    private JFrame frame;
    private int height = 720;
    private int width = (int) (height * aspectRatio);

    public Gui() {
        init();
    }

    private void init() {

        frame = new JFrame("2048");
        frame.setSize(width, height);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        game = new Game();
        score = new ScorePanel();
        //frame.add(score);
        frame.add(game);

        frame.addKeyListener(new KeyListener() {
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
                        game.up();
                        System.out.println("up");
                        break;

                    case (65):  //a
                    case (37):  //left
                        game.left();
                        System.out.println("left");
                        break;

                    case (83):  //s
                    case (40):  //down
                        game.down();
                        System.out.println("down");
                        break;

                    case (68):  //d
                    case (39):  //right
                        game.right();
                        System.out.println("right");
                        break;
                    default:
                        System.out.println(e);                 // do nothing
                }
            }
        });


        //frame.add(game=new GamePanel);
        frame.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                Dimension newSize = e.getComponent().getBounds().getSize();
                if (width != newSize.getWidth()) {
                    frame.setSize((int) newSize.getWidth(), (int) (newSize.getWidth() * 1 / aspectRatio));
                } else if (height != newSize.getHeight()) {
                    frame.setSize((int) (newSize.getHeight() * aspectRatio), (int) newSize.getHeight());
                } // makes sure frame is always in the right Aspect ratio
                updateSize(frame.getSize());
                //frame.setSize((int) (newSize.getHeight()*aspectRatio),(int) newSize.getHeight()); //set width from height
                //frame.setSize((int) newSize.getWidth(),(int) (newSize.getWidth()*1/aspectRatio) ); //set height from width
            } // used to make sure frame is always in the right Aspect ratio

            @Override
            public void componentMoved(ComponentEvent e) {

            }

            @Override
            public void componentShown(ComponentEvent e) {

            }

            @Override
            public void componentHidden(ComponentEvent e) {
            }
        });
    }

    private void updateSize(Dimension size) {
        this.height = (int) size.getHeight();
        this.width = (int) size.getWidth();
        score.setBounds(height, 0, width - height, height); // needs to create a square game panel
        game.setBounds(0, 0, height, height); //makes the Game JPanel square
        score.updateSize();
    }

    public int transferScore(){
        score.setScore(game.getScore());
        return game.getScore();
    }

    public void update() {
        updateSize(new Dimension(width, height));
    }
}
