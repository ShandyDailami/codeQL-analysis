import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.security.auth.callback.UnsupportedCallbackException;
import javax.sql.DataSource;
import javax.security.auth.login.LoginException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.security.auth.callback.UnsupportedCallbackException;
import javax.sql.DataSource;
import javax.security.auth.login.LoginException;

public class java_24870_CredentialValidator_A07 {

    public static void main(String[] args) {
        validateUser("user1", "password1");
    }

    public static void validateUser(String username, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            DataSource ds = getDataSource();
            Connection con = ds.getConnection();

            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM users WHERE username = '" + username + "' and password = '" + password + "'";
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                System.out.println("User Authenticated!");
            } else {
                System.out.println("Invalid Credentials!");
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static DataSource getDataSource() {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "root";
        return DriverManager.getConnection(url, username, password);
    }

}