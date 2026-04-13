import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.*;

public class java_07895_XMLParser_A01 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        String xmlFile = "example.xml";
        parseXmlFile(xmlFile);
    }

    public static void parseXmlFile(String fileName) throws ParserConfigurationException, SAXException {
        // Create a new instance of the document
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new File(fileName));

        // Normalize the document by removing white space and line breaks
        Normalizer normalizer = Normalizer.getInstance();
        normalizer.setDeletingComments(true);
        normalizer.setIgnoringHref(true);
        doc.replaceChild(normalizer.normalize(doc), doc.getFirstChild());

        // Get the root element
        Element root = doc.getDocumentElement();
        System.out.println("Root element: " + root.getNodeName());

        // Iterate over all child elements of the root element
        NodeList children = root.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("Child element: " + element.getNodeName());
                System.out.println("Child element attributes: " + element.getAttributes());
            }
       
        }
    }
}