import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.xml.parsers.DocumentBuilder;
import org.xml.parsers.DocumentBuilderFactory;
import org.xml.sax.SAXException;

public class java_20631_XMLParser_A01 {
    public static void main(String[] args) {
        String fileName = "config.properties";
        Properties prop = new Properties();

        try (FileInputStream input = new FileInputStream(fileName)) {
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        String url = prop.getProperty("url");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            org.w3c.dom.Document doc = builder.parse(url);
            doc.getDocumentElement().normalize();

            System.out.println("Document is parsed successfully.");
        } catch (SAXException | IOException e) {
            System.out.println("Error occurred while parsing the document: " + e.getMessage());
        }
    }
}