import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class ScorePanel extends JPanel {
    private final Color ebony = new Color(96, 109, 93);
    private final Color morningBlue = new Color(136, 149, 141);
    private final Color lilacLuster = new Color(188, 156, 176);
    private final Color lavenderGray = new Color(211, 205, 215);
    private final Color lightCyan = new Color(221, 242, 235);
    private JTextField nameInput;
    private Dimension size;
    private JButton submit;
    private DatenbankVerwaltung dbv;
    private int score=0;

    public ScorePanel() {
        init();
    }

    public void updateSize() {
        nameInput.setBounds((int) ((getSize().getWidth()) / 2) - 100, (int) (getSize().getHeight() / 10 * 7), 200, 20);
        submit.setBounds((int) ((getSize().getWidth()) / 2) - 100, (int) (getSize().getHeight() / 10 * 7) + 30, 200, 20);
        try {
            dbv.getScores();
        } catch (Exception ignored) {
        }
    }

    private void getScore(){

    }

    private void init() {
        dbv = new DatenbankVerwaltung();
        //dbv.rebuildTable();
        setFocusable(true);
        setBackground(ebony);
        setLayout(null);
        add(nameInput = new JTextField("Enter Username here"));
        add(submit = new JButton("Submit Score"));
        submit.setFont(new Font("Arial", Font.BOLD, 20));
        nameInput.setFont(new Font("ComicSans", Font.BOLD, 15));
        nameInput.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                nameInput.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        nameInput.setForeground(new Color(0, 20, 215));
        nameInput.setBackground(lightCyan);
        submit.setBackground(lightCyan);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    if (!(nameInput.getText().contains("Enter Username here"))) {
                        //getScore();
                        dbv.rebuildTable();
                        //dbv.postScore(getScore(), nameInput.getText());
                    }else{
                        dbv.getScores();
                    }
                }catch (Exception ignored) {
                    } finally {
                        nameInput.setText("Enter Username here");
                    }

            }
        });
    }

    public void setScore(int score) {
        this.score = score;
    }
}
