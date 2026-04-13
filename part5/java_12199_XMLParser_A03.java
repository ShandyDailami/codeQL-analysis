import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_12199_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlContent = "<note>\n" +
                "  <to>Tove</to>\n" +
                "  <from>Jani</from>\n" +
                "  <heading>Reminder</heading>\n" +
                "  <body>Don't forget me this weekend!</body>\n" +
                "</note>";

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Create an empty document
            Document doc = builder.newDocument();

            // Add the XML content to the document
            doc.appendChild(doc.newTextNode(xmlContent));

            // Print the XML content
            System.out.println("XML Content: " + doc.getFirstChild().getNodeValue());

            // Injection attack
            String injectionAttack = "<note>\n" +
                    "  <to>Tove</to>\n" +
                    "  <from>' or '1'='1</from>\n" +
                    "  <heading>Reminder</heading>\n" +
                    "  <body>Don't forget me this weekend!</body>\n" +
                    "</note>";
            System.out.println("Injection Attack XML Content: " + injectionAttack);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}