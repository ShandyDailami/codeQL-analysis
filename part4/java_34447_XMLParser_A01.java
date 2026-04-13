import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_34447_XMLParser_A01 {
    public static void main(String[] args) {
        File xmlFile = new File("path/to/your/xml/file.xml");
        if (!xmlFile.canRead()) {
            System.out.println("Access Denied: Unable to read the XML file");
            return;
        }
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        
        try (InputStream inputStream = new FileInputStream(xmlFile)) {
            Document document = builder.parse(inputStream);
            // Do something with the parsed document...
        } catch (IOException | SAXException e) {
            System.out.println("Error parsing the XML file: " + e.getMessage());
        }
    }
}