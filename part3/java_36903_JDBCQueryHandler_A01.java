import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_36903_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/bookstore";
        String username = "username";
        String password = "password";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);

            String query = "SELECT a.name, b.title FROM Authors a INNER JOIN Books b ON a.id = b.author_id WHERE a.name = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, "Author Name");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String authorName = rs.getString("name");
                String bookTitle = rs.getString("title");
                System.out.println(authorName + " wrote the book: " + bookTitle);
            }

            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}