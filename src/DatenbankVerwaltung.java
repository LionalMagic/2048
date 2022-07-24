import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DatenbankVerwaltung {
    public DatenbankVerwaltung() {
        addScoreboard();
    }// tries to create a new Table 'scorebaord' to write score data

    private void addScoreboard() {
        try {
            Connection con = getConnection();
            PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS `scoreboard` (`PRIMARY_KEY` INT(255) NOT NULL AUTO_INCREMENT , `name` VARCHAR(50) NOT NULL , `score` INT(255) NOT NULL , `timestamp` DATE NOT NULL DEFAULT CURRENT_TIMESTAMP , PRIMARY KEY (`PRIMARY_KEY`))");
            create.executeUpdate();
        } catch (Exception ignored) {
        }
    }

    public ArrayList<String> getScores() {
        try {
            Connection con = getConnection();
            PreparedStatement statement = con.prepareStatement("SELECT score,name FROM scoreboard ORDER BY score DESC");//LIMIT 1

            ResultSet result = statement.executeQuery();

            ArrayList<String> array = new ArrayList<String>();
            while (result.next()) {
                System.out.print(result.getString("score"));
                System.out.print(" ");
                System.out.println(result.getString("name"));

                array.add(result.getString("score"));
            }
            System.out.println("All records have been selected!");
            return array;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void postScore(int score, String name) {
        try {
            Connection con = getConnection();
            //PreparedStatement posted = con.prepareStatement("INSERT INTO 'scoreboard' (name, score) VALUES ('"+ name +"','"+ i +"')");
            PreparedStatement posted = con.prepareStatement("INSERT INTO `scoreboard` (`name`, `score`) VALUES ('" + name + "','" + score + "')");
            posted.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);

        }
    } //posts new dataset in scoreboard

    private Connection getConnection() {
        try {
            String driver = ("com.mysql.cj.jdbc.Driver");
            String url = ("jdbc:mysql://localhost:3306/2048");
            String username = ("root");
            String password = ("");
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Xampp Mysql Connected..");
            return conn;
        } catch (Exception ignored) {
        }
        return null;
    } //establishes Connection to DB

    public void dropScores(boolean bool) {
        if (bool) {
            try {
                Connection con = getConnection();
                PreparedStatement delete = con.prepareStatement("DROP TABLE `scoreboard`");
                delete.executeUpdate();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    } // deletes Table 'scoreboard'

    public void rebuildTable() {
        try {
            dropScores(true);
            addScoreboard();
        } catch (Exception ignore) {
        }

    }


}
