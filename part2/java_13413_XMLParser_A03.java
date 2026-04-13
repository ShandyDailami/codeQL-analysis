import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_13413_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "example.xml";  // Path to your XML file
        parse(xmlFile);
    }

    public static void parse(String xmlFile) {
        try {
            // Create factory and builder instances
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Load the document
            Document doc = builder.parse(new File(xmlFile));

            // Process the document here
            System.out.println("XML Parsed Successfully!");

        } catch (IOException e) {
            e.printStackTrace();
       
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}