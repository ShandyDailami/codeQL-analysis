import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;

public class java_15049_XMLParser_A07 {

    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        try {
            Document doc = dBuilder.parse(new StreamSource(inputFile));
            doc.getDocumentElement().normalize();
            printElements(doc);
        } catch (IOException e) {
            e.printStackTrace();
       
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static void printElements(Document doc) {
        doc.getElementsByTagName("item").item(0).getFirstChild().getNodeValue();
    }
}