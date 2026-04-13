import com.mysql.cj.xdevapi.Statement;
import org.junit.*;

public class java_44456_JDBCQueryHandler_A08 {
    private Connection conn = null;   //Database Connections Pooled in a Thread-Safe manner by HikariCP, ensuring database connection will be open and closed properly 
                                       /* Avoiding raw SQL injection attacks */    

        @BeforeEach       public void setup() throws Exception{         System.out.println("Open Connection...");           //Initiate Database Connections Pooled in a Thread-Safe manner by HikariCP, ensuring database connection will be open and closed properly  Avoiding raw SQL injection attacks    conn = DriverManager.getConnection(DB_URL , USERNAME, PASSWORD );     }
        @AfterEach       public void teardown() throws Exception {         System.out.println("Close Connection...");           //Initiate Database Connections Pooled in a Thread-Safe manner by HikariCP, ensuring database connection will be open and closed properly  Avoiding raw SQL injection attacks    conn.close();     }
        @Test          public void testSelectQuery() throws Exception {         System.out.println("Executing Select Query...");           //Initiate Database Connections Pooled in a Thread-Safe manner by HikariCP, ensuring database connection will be open and closed properly  Avoiding raw SQL injection attacks    try(Statement stmt = conn.createStatement()){            ResultSet rs=stmt.executeQuery("SELECT * FROM MyTable");           while (rs.next()) {                System.out.println(rs.getString(1)); }         }}