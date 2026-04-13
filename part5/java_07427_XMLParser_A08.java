import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_07427_XMLParser_A08 {
    public static void main(String[] args) {
        // Load the XML file
        String fileName = "sample.xml";
        File xmlFile = new File(fileName);
        try (InputStream inputStream = new FileInputStream(xmlFile)) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(inputStream);

            // Print the XML data
            System.out.println(doc.getDocumentElement().getNodeName());
            System.out.println(doc.getElementsByTagName("name").item(0).getTextContent());
            System.out.println(doc.getElementsByTagName("age").item(0).getTextContent());
        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }
}