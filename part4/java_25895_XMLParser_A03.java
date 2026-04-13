import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_25895_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create DocumentBuilderFactory and parse the XML file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputStream inputStream = new FileInputStream(new File("src/main/resources/example.xml"));
            Document doc = builder.parse(inputStream);

            // Print the XML document
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            // Close the input stream
            inputStream.close();
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}