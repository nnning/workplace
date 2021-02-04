import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

    public static void main(String[] args) {

        Statement s = null;
        Connection c = null;
        String heroName = "Hero";
        float hp = 0;
        int damage = 0;
        String sql = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("hello jdbc");

            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/how2java?characterEncoding=UTF-8", "root",
                    "root");
            System.out.println("connection: " + c);

            s = c.createStatement();
            System.out.println("statement: " + s);

            for (int i = 100; i <= 200; i++) {
                sql = "insert into hero values(null," + "'"+String.valueOf(heroName+i)+"'" + "," + i + "," + i + ")";
                s.execute(sql);
            }

            // String sql = "insert into hero values(null," + "'Ashe'" + "," + 415.0f + ","
            // + 50 + ")";

            // s.execute(sql);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (s != null) {
                try {
                    s.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (c != null) {
                try {
                    c.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
