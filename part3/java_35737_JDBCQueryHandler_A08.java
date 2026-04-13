import java.sql.*;

public class java_35737_JDBCQueryHandler_A08 {

    // URL and credentials for MySQL database
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;

        try {
            // 1. Establish connection to database
            con = DriverManager.getConnection(url, username, password);

            // 2. Create statement object
            stmt = con.createStatement();

            // 3. Create table
            String createTableSQL = "CREATE TABLE Students\n" +
                    "(\n" +
                    "  ID INT NOT NULL AUTO_INCREMENT,\n" +
                    "  Name VARCHAR(50),\n" +
                    "  Age INT,\n" +
                    "  PRIMARY KEY (ID)\n" +
                    ")";
            stmt.executeUpdate(createTableSQL);

            // 4. Insert a row into the table
            String insertSQL = "INSERT INTO Students (Name, Age) VALUES ('John', 20)";
            stmt.executeUpdate(insertSQL);

            // 5. Select a row from the table
            String selectSQL = "SELECT * FROM Students WHERE Name = 'John'";
            ResultSet rs = stmt.executeQuery(selectSQL);

            while (rs.next()) {
                String name = rs.getString("Name");
                int age = rs.getInt("Age");

                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
            }

            // 6. Update a row in the table
            String updateSQL = "UPDATE Students SET Age = 22 WHERE Name = 'John'";
            stmt.executeUpdate(updateSQL);

            // 7. Close the connection
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}