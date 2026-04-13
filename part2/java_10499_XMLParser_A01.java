import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class java_10499_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // create a factory for reading the XML file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // parse the XML file
            Document document = builder.parse(new File("sample.xml"));

            // print the names of all the elements and their attributes
            printElementsAndAttributes(document);

            // transform the document into an XSLT document
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.transform(new DOMSource(document), new StreamResult(System.out));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElementsAndAttributes(Document document) {
        NodeList nodeList = document.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            System.out.println("Element name: " + element.getTagName());
            System.out.println("Element attributes: " + element.getAttributes().getLength());
            for (int j = 0; j < element.getAttributes().getLength(); j++) {
                System.out.println("Attribute name: " + element.getAttributes().item(j).getNodeName() + " - Value: " + element.getAttributes().item(j).getTextContent());
            }
        }
    }
}