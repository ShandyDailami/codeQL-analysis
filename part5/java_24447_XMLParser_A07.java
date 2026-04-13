import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;

public class java_24447_XMLParser_A07 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        String xmlFile = "example.xml";  // replace with your file path
        parse(xmlFile);
    }

    private static void parse(String xmlFile) throws ParserConfigurationException, SAXException {
        // create the factory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        factory.setIgnoringElementContentWhitespace(true);
        DocumentBuilder builder = factory.newDocumentBuilder();

        // parse the file
        Document doc = builder.parse(new File(xmlFile));

        // print out the names of all the elements
        printElementNames(doc);
    }

    private static void printElementNames(Document doc) {
        Element root = doc.getDocumentElement();
        printElementNames(root);
    }

    private static void printElementNames(Element node) {
        System.out.println("-> " + node.getNodeName());

        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            printElementNames((Element) children.item(i));
        }
    }
}