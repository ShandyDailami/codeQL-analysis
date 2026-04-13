import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_34197_XMLParser_A08 {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(XMLParser.class.getName());
        File inputFile = new File("input.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        try {
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            printElement(doc, null, 0);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Failure parsing the XML file.", ex);
        }
    }

    private static void printElement(Document doc, Element elem, int indentation) {
        if (elem == null) {
            elem = doc.getDocumentElement();
        }

        for (int i = 0; i < indentation; i++) {
            System.out.print("  ");
        }

        System.out.println("- " + elem.getNodeName());

        NodeList children = elem.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            printElement(doc, children.item(i).getNodeName() != null ? children.item(i) : null, indentation + 1);
        }
    }
}