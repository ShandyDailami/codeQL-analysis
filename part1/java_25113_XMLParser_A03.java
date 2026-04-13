import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class java_25113_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            File outputFile = new File("output.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(inputFile);
            document.getDocumentElement().normalize();

            ListNode list = new ArrayListNode();
            parseElement(document.getDocumentElement(), list);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(outputFile);

            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseElement(Element element, List list) {
        list.add(element.getNodeName());

        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            parseElement((Element) children.item(i), list);
        }
    }
}