import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class java_35817_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("path_to_your_xml_file.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // Printing the parsed information on the console
            printDocument(doc);

            // Removing the root element
            doc.getDocumentElement().normalize();

            // Creating a new XML file with the removed root element
            doc.getDocumentElement().getFirstChild().getNextSibling().normalize();

            // Writing the new XML to a file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("path_to_new_xml_file.xml"));
            transformer.transform(source, result);

        } catch (SAXException | IOException | TransformerException e) {
            e.printStackTrace();
        }
    }

    private static void printDocument(Document doc) {
        System.out.println(doc.getDocumentElement().getTagName());
        NodeList nList = doc.getElementsByTagName("*");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("-----" + nNode.getNodeName() + "-----" + nNode.getTextContent());
        }
    }
}