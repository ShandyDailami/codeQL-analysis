import java.net.URL;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_10410_XMLParser_A07 {
    public static void main(String[] args) {
        String url = "file:path/to/your/file.xml"; // Path to your XML file
        String user = "username";
        String password = "password";
        String databaseUrl = "jdbc:mysql://localhost/dbname"; // Your database URL

        try {
            // Load the XML file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(url));

            // Extract the 'username' and 'password' elements
            NodeList nodes = doc.getElementsByTagName("username");
            if (nodes.getLength() > 0) {
                user = nodes.item(0).getTextContent();
            }

            nodes = doc.getElementsByTagName("password");
            if (nodes.getLength() > 0) {
                password = nodes.item(0).getTextContent();
            }

            // Try to connect to the database
            Class.forName("com.mysql.jdbc.Driver"); // MySQL JDBC driver
            Connection conn = DriverManager.getConnection(databaseUrl, user, password);
            if (conn != null) {
                System.out.println("Connected successfully");
            } else {
                System.err.println("Failed to connect");
            }

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}