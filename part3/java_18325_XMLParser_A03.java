import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_18325_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Load the XML document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("sample.xml"));

            // Get the root element
            Element root = doc.getDocumentElement();

            // Start XML traversal
            parseElement(root);

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void parseElement(Element element) throws SAXException {
        // SAX parser simplifies the parsing process
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new SAXHandler());

        // Parse the element content
        parser.parse(new InputSource(new StringReader(element.getTextContent())));

        // Traverse other elements
        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            if (childNodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
                parseElement((Element) childNodes.item(i));
            }
        }
    }
}

class SAXHandler implements ContentHandler {
    public void startDocument() {}

    public void endDocument() {}

    public void startElement(String uri, String localName, String qName) {}

    public void endElement(String uri, String localName, String qName) {}

    public void characters(char[] ch, int start, int length) {
        // This method is called for each character event, here you can decode and print the content
        System.out.println(new String(ch, start, length));
    }

    public void error(SAXException e) {}

    public void fatalError(SAXException e) {}

    public void warning(SAXException e) {}
}