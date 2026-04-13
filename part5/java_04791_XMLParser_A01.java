import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_04791_XMLParser_A01 {

    public static void main(String[] args) {
        String xmlFile = "example.xml"; // The XML file to parse
        String elementName = "element"; // The element to parse

        // Check if the file exists and read it
        File xmlFileObj = new File(xmlFile);
        if (!xmlFileObj.exists()) {
            System.out.println("File does not exist!");
            return;
        }

        // Create DocumentBuilderFactory and Document
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFileObj);

        // Get the element by name
        NodeList nList = doc.getElementsByTagName(elementName);
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Element element = (Element) nList.item(temp);
            System.out.println("Element name: " + element.getTagName());
            System.out.println("Element value: " + element.getFirstChild().getNodeValue());
        }
    }
}