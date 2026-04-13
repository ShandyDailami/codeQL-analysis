import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class java_02845_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Load the properties file
            Properties prop = new Properties();
            InputStream input = new FileInputStream("config.properties");
            prop.load(input);

            // Retrieve the property value
            String filePath = prop.getProperty("filePath");
            parseXml(filePath);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void parseXml(String filePath) {
        try {
            // Create a new instance of the XmlReader class
            javax.xml.parsers.DocumentBuilderFactory factory = javax.xml.parsers.DocumentBuilderFactory.newInstance();
            javax.xml.parsers.DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            org.w3c.dom.Document doc = builder.parse(new File(filePath));
            doc.getDocumentElement().normalize();

            // Here you can perform security-sensitive operations related to Injection

            // Print the parsed XML
            System.out.println(doc.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}