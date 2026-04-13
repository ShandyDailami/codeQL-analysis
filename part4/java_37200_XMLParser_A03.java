import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_37200_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            InputSource source = new InputSource();
            source.setCharacterStream(new java.io.StringReader("<root><name>John Doe</name><age>30</age></root>"));

            Document document = builder.parse(source);

            // Process the document
            XmlHandler handler = new XmlHandler();
            XMLReader reader = DocumentBuilderFactory.newInstance().newDocumentReader(document.getDocumentElement());
            reader.setContentHandler(handler);
            reader.parse(new org.xml.sax.InputSource(new java.io.StringReader("<root><name>John Doe</name><age>30</age></root>")));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class XmlHandler extends DefaultHandler {
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("Start of element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }
}