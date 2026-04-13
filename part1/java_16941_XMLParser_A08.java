import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_16941_XMLParser_A08 {
    public static void main(String[] args) {
        String xmlString = "<root><value>secure sensitive data</value></root>";

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new InputSource(new StringReader(xmlString)));

            // Your security-sensitive operations go here, e.g.
            // Checking integrity of the document
            if (!document.getDocumentElement().getNodeName().equals("root")) {
                throw new SecurityFailureException("Invalid XML document: Document root node is not 'root'");
            }

            // Checking if the 'value' node contains the expected text
            Node valueNode = document.getElementsByTagName("value").item(0);
            if (!valueNode.getTextContent().equals("secure sensitive data")) {
                throw new SecurityFailureException("Invalid XML document: 'value' node contains unexpected text");
            }
        } catch (ParsingException e) {
            System.out.println("Failed to parse XML document: " + e.getMessage());
        // Handle ParsingException as needed
        } catch (SAXException e) {
            System.out.println("SAX Exception: " + e.getMessage());
        // Handle SAXException as needed
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        // Handle other exceptions as needed
        }
    }
}