import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_06192_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlContent = "<note>" +
                "<to>Tech support</to>" +
                "<from>Mike</from>" +
                "<heading>Reminder</heading>" +
                "<body>Don't forget about meeting tomorrow at 11am</body>" +
                "</note>";
        parseXml(xmlContent);
    }

    public static void parseXml(String xmlContent) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(xmlContent)));
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getElements().get(0).getNodeName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}