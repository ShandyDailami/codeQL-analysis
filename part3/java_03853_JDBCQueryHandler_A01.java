import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class java_03853_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        try {
            Properties props = new Properties();
            props.load(JDBCQueryHandler.class.getResourceAsStream("database.properties"));

            Connection conn = DriverManager.getConnection(props.getProperty("url"), props);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employees");

            while (rs.next()) {
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");
                System.out.println("Name: " + name + ", Salary: " + salary);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}