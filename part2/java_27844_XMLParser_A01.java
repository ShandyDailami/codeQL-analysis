import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_27844_XMLParser_A01 {

    public static void main(String[] args) {
        // create a factory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // create a builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // parse the file
            Document doc = builder.parse(new File("sample.xml"));

            // get the root element
            doc.getDocumentElement().normalize();

            // get the value of the first child element
            NodeList list = doc.getElementsByTagName("tag");
            if (list.getLength() > 0) {
                System.out.println("First child element: " + list.item(0).getTextContent());
            }

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}