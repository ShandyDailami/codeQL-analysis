import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class java_01628_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("src/main/resources/data.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            // Print out the names of the elements
            NodeList nodeList = document.getElementsByTagName("element");
            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println("Element #" + (i + 1) + ": " + nodeList.item(i).getTextContent());
            }

            // Print out the names of the attributes
            nodeList = document.getElementsByTagName("element");
            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.print("Attributes of Element #" + (i + 1) + ": ");
                org.w3c.dom.Element element = (org.w3c.dom.Element) nodeList.item(i);
                NodeList attributeList = element.getElementsByTagName("attribute");
                for (int j = 0; j < attributeList.getLength(); j++) {
                    System.out.print(attributeList.item(j).getTextContent() + " ");
                }
                System.out.println();
            }

            // Convert the XML into HTML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(System.out);
            transformer.transform(source, result);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}