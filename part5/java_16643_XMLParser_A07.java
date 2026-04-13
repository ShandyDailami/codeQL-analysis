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

public class java_16643_XMLParser_A07 {

    public static void main(String[] args) {
        // Load the XML document
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("path_to_your_xml_file.xml"));

        // Print all element names and values
        printDocument(document);

        // Remove 'username' and 'password' elements and save the document
        document.getElementsByTagName("username").item(0).getParentNode().removeChild(document.getElementsByTagName("username").item(0));
        document.getElementsByTagName("password").item(0).getParentNode().removeChild(document.getElementsByTagName("password").item(0));
        saveDocument(document);
    }

    private static void printDocument(Document document) {
        System.out.println("\nNode List:");
        NodeList nodeList = document.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println(nodeList.item(i).getNodeName() + " : " + nodeList.item(i).getTextContent());
        }
    }

    private static void saveDocument(Document document) {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new File("path_to_save_xml_file.xml"));
        transformer.transform(domSource, streamResult);
    }
}