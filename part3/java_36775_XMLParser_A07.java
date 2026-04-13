import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class java_36775_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("path_to_your_xml_file.xml"); // replace with your xml file path
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            printXML(doc);
            createNewFile(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printXML(Document doc) {
        System.out.println("XML Content: ");
        Element root = doc.getDocumentElement();
        printElement(root);
    }

    private static void printElement(Element element) {
        System.out.print("Tag name: " + element.getTagName());
        System.out.print(" Tag value: " + element.getFirstChild().getNodeValue());
        System.out.println("");
        for (int i = 0; i < element.getChildNodes().getLength(); i++) {
            printElement((Element) element.getChildNodes().item(i));
        }
    }

    private static void createNewFile(Document doc) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("new_file.xml"));
            transformer.transform(source, result);
            System.out.println("New file created successfully with the same contents as the original file.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}