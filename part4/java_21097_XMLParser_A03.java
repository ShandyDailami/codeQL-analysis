import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class java_21097_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("path_to_your_xml_file.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            // Get the root element
            Element rootElement = document.getDocumentElement();

            // Traverse the XML and print each element
            traverse(rootElement, 0);

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void traverse(Element element, int indent) {
        // Print the element and its attributes
        System.out.print(getIndentation(indent) + "<" + element.getTagName());
        for (int i = 0; i < element.getAttributes().getLength(); i++) {
            System.out.print(" " + element.getAttributes().getItem(i).getName() + "=\"" + element.getAttributes().getItem(i).getValue() + "\"");
        }
        System.out.println(">" + element.getTextContent() + "</" + element.getTagName() + ">");

        // Traverse the child elements
        for (int i = 0; i < element.getChildNodes().getLength(); i++) {
            if (element.getChildNodes().item(i).getNodeType() == Node.ELEMENT_NODE) {
                traverse((Element) element.getChildNodes().item(i), indent);
            }
        }
    }

    private static String getIndentation(int indent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            sb.append("  ");
        }
        return sb.toString();
    }
}