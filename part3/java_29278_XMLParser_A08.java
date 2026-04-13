import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_29278_XMLParser_A08 {

    public static void main(String[] args) {
        parseXML("sample.xml");
    }

    public static void parseXML(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document doc = builder.parse(new File(fileName));
            doc.getDocumentElement().normalize();

            List<String> elements = List.of("element1", "element2", "element3");
            for (String element : elements) {
                printElements(doc, element);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElements(Document doc, String elementName) {
        NodeList nodeList = doc.getElementsByTagName(elementName);
        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println("Element [" + i + "]: " + nodeList.item(i).getTextContent());
        }
    }
}