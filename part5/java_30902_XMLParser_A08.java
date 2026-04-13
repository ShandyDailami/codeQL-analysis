import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_30902_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlFile = "src/main/resources/data.xml";
        File xmlFilePath = new File(xmlFile);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = null;
        try {
            document = builder.parse(xmlFilePath);
            System.out.println("Document loaded successfully.");
        } catch (IOException e) {
            System.out.println("Failed to load the XML file.");
            e.printStackTrace();
        } catch (SAXException e) {
            System.out.println("Parsing the XML content.");
            e.printStackTrace();
        }
    }
}