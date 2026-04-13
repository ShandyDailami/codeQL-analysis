import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_12740_XMLParser_A08 {

    public static class SecuritySensitiveOperationException extends Exception {
        public java_12740_XMLParser_A08(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        parseAndCheckFileForSensitiveOperations(xmlFile);
    }

    private static void parseAndCheckFileForSensitiveOperations(File file) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document;

        try {
            document = builder.parse(file);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("*");

            for (int i = 0; i < nodeList.getLength(); i++) {
                checkNodeForSensitiveOperation(nodeList.item(i));
            }

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void checkNodeForSensitiveOperation(org.w3c.dom.Node node) {
        String nodeName = node.getNodeName();

        if (nodeName.equals("div")) {
            throw new SecuritySensitiveOperationException("Found a 'div' node with sensitive operation.");
        }
    }
}