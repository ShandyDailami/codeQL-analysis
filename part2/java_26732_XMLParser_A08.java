import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.IOException;
import javax.xml.parsers.SAXParserFactory;

public class java_26732_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            parseDocument("document.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parseDocument(String documentName) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(ClassLoader.getSystemResourceAsStream(documentName));

        SAXParserFactory saxFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxFactory.newSAXParser(null);

        XmlSAXHandler handler = new XmlSAXHandler();
        saxParser.parse(document, handler);
    }
}

class XmlSAXHandler extends DefaultHandler {

    private String lastElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("tagName")) {
            throw new SecurityException("Attack detected!");
        }
        lastElement = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
    }
}