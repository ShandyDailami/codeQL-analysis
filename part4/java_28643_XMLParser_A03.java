import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_28643_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "input.xml"; // path to your XML file
        parseXML(xmlFile);
    }

    public static void parseXML(String xmlFile) {
        File inputFile = new File(xmlFile);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = null;
        try {
            doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
        } catch (Exception e) {
            System.out.println("DocumentBuilderError: " + e.getMessage());
        }

        NodeList nodeList = doc.getElementsByTagName("cmd");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            Element element = (Element) node;

            // TODO: Add code here to parse and execute the command.
            // This is a security risk, consider using a safer way of executing SQL commands.
            // For example, use JDBC, PreparedStatements, or other safe alternatives.
            System.out.println("Parsed command: " + element.getAttribute("value"));
        }
    }
}