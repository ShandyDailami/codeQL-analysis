import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_00835_XMLParser_A07 {

    public static void main(String[] args) {
        String filePath = "src/main/resources/sample.xml";
        parseXML(filePath);
    }

    private static void parseXML(String filePath) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = builder.parse(new File(filePath));
        } catch (Exception e) {
            e.printStackTrace();
       
        }

        doc.getDocumentElement().normalize();

        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        printElement(doc.getDocumentElement(), 1);

    }

    private static void printElement(Element elem, int indentation) {
        System.out.print(getIndentation(indentation));
        System.out.println("Element: " + elem.getNodeName());

        NodeList children = elem.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            printElement((Element) children.item(i), indentation + 1);
        }
    }

    private static String getIndentation(int level) {
        StringBuilder indentation = new StringBuilder();
        for (int i = 0; i < level; i++) {
            indentation.append("- ");
        }
        return indentation.toString();
    }

}