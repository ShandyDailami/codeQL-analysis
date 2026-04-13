import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_05221_XMLParser_A08 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document doc = builder.parse(inputFile);
            doc.getDocumentElement().normalize();
            printElementAndAttributes(doc, "");
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void printElementAndAttributes(Document doc, String indent) {
        NodeList nodes = doc.getElementsByTagName("*");
        for (int i = 0; i < nodes.getLength(); ++i) {
            Element element = (Element) nodes.item(i);
            System.out.print(indent + element.getTagName());
            NodeList attributes = element.getAttributes();
            for (int j = 0; j < attributes.getLength(); ++j) {
                System.out.print(" " + attributes.item(j).getNodeName() + "=" + "\"" + attributes.item(j).getNodeValue() + "\"");
            }
            System.out.println();
            if (element.getChildNodes().getLength() > 0) {
                printElementAndAttributes(doc, indent + "  ");
            }
        }
    }
}