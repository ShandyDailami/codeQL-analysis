import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_25978_XMLParser_A08 {
    public static void main(String[] args) {
        File xmlFile = new File("yourfile.xml"); // replace "yourfile.xml" with your xml file path
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            // parse the xml document here.
            // for simplicity, we print the document's root element
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}