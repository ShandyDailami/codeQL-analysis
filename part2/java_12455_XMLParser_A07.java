import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class java_12455_XMLParser_A07 {
    
    private static class MyHandler extends DefaultHandler {
        public void startElement(String uri, String localName, String qName,
                Attributes attributes) throws SAXException {
            // Place your security sensitive operations here
        }

        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            // Do nothing
        }

        public void startDocument(String uri, String localName, String qName)
                throws SAXException {
            // Do nothing
        }

        public void endDocument(String uri, String localName, String qName)
                throws SAXException {
            // Do nothing
        }

        public void fatalError(SAXParseException e) throws SAXException {
            // Place your security sensitive operations here
        }
    }

    public static void parse(String xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false);
        factory.setNamespaceAware(false);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xmlFile);
        XMLReader reader = document.getXMLReader();
        reader.setContentHandler(new MyHandler());
        try {
            reader.parse(new SAXSource(reader, true));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        parse("sample.xml");
    }
}