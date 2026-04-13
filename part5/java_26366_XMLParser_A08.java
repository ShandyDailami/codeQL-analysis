import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.xml.sax.helpers.DefaultHandler;

public class java_26366_XMLParser_A08 {
    public static void main(String[] args) {
        String xmlData = "<root><element1>data1</element1><element2>SecuritySensitive:data2</element2><element3>data3</element3></root>";

        try {
            parseXml(xmlData);
        } catch (ParserConfigurationException | SAXException | TransformerException e) {
            e.printStackTrace();
        }
    }

    private static void parseXml(String xmlData) throws ParserConfigurationException, SAXException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Disable default handler for security sensitive elements
        DefaultHandler handler = new DefaultHandler() {
            @Override
            public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
                if (qName.startsWith("SecuritySensitive:")) {
                    System.out.println("Warning: Element " + qName + " is a security sensitive element and will be ignored.");
                }
                super.startElement(uri, localName, qName, attributes);
            }
        };

        Document document = builder.parse(new InputSource(new StringReader(xmlData)));

        // Ignore any element names that start with "SecuritySensitive"
        document.getElementsByTagName("*").item(0).normalize();

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(System.out);

        transformer.transform(source, result);
    }
}