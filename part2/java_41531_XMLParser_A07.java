import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_41531_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // Create a factory for the DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a builder using the factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the input from the file
            InputStream inputStream = new FileInputStream(new File("input.xml"));
            Document doc = builder.parse(inputStream);

            // Print out the document
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
        } catch (ParserConfigurationException | SAXException | java.io.IOException e) {
            e.printStackTrace();
        }
    }
}