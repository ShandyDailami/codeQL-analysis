import java.sql.*;

public class java_36785_SessionManager_A03 {

    private static SessionManager instance = null;

    private Connection conn = null;

    private java_36785_SessionManager_A03() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb?useSSL=false", "username", "password");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static synchronized SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Connection getConnection() {
        return this.conn;
    }

    public void closeConnection() {
        if (this.conn != null) {
            try {
                this.conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SessionManager sm = SessionManager.getInstance();
        try {
            sm.getConnection().createStatement().execute("CREATE TABLE EMPLOYEE (ID INT PRIMARY KEY, NAME VARCHAR(30), AGE INT, SALARY FLOAT)");
            sm.getConnection().createStatement().execute("INSERT INTO EMPLOYEE (ID, NAME, AGE, SALARY) VALUES (1, 'John', 30, 5000.00)");
            ResultSet rs = sm.getConnection().createStatement().executeQuery("SELECT * FROM EMPLOYEE");
            while (rs.next()) {
                System.out.println("ID = " + rs.getInt("ID"));
                System.out.println("NAME = " + rs.getString("NAME"));
                System.out.println("AGE = " + rs.getInt("AGE"));
                System.out.println("SALARY = " + rs.getFloat("SALARY"));
            }
            sm.closeConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}