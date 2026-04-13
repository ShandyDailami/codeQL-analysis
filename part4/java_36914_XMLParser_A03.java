import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_36914_XMLParser_A03 {

    public static void main(String[] args) {
        File xmlFile = new File("input.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = builder.parse(xmlFile);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

        doc.getElementsByTagName("*");

        printElements(doc);
    }

    private static void printElements(Document doc) {
        NodeList nodeList = doc.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                System.out.println("Element: " + nodeList.item(i).getNodeName());
            }
        }
    }
}