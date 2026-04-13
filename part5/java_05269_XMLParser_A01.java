import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_05269_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            parseXmlFile("sample.xml");
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    public static void parseXmlFile(String fileName) throws IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = builder.parse(new File(fileName));

        // Here you can access the parsed XML data, e.g.:
        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
    }
}