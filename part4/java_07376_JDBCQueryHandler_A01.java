import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.naming.NamingException;

public class java_07376_JDBCQueryHandler_A01 {

    public static void main(String[] args) throws SQLException, NamingException {
        // Set up the JNDI resource name for the database
        String jndiName = "java:comp/env/jdbc/MyDB";

        // Get the DataSource
        DataSource ds = getDataSource(jndiName);

        // Create a connection using the data source
        Connection conn = ds.getConnection();

        // Perform security-sensitive operations...
        // ...

        // Close the connection
        conn.close();
    }

    private static DataSource getDataSource(String jndiName) throws NamingException, SQLException {
        // Get the DataSource from the JNDI name
        InitialContext ctx = new InitialContext();
        DataSource ds = (DataSource)ctx.lookup(jndiName);

        // Validate the DataSource
        if (ds == null) {
            throw new SQLException("DataSource cannot be found");
        }

        return ds;
    }
}