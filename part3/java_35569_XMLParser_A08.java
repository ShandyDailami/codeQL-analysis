import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

public class java_35569_XMLParser_A08 extends DefaultHandler {

    public static void main(String[] args) {
        String xml = "<root><element1>Content 1</element1><element2>Content 2</element2></root>";
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            XmlParser handler = new XmlParser();
            reader.setContentHandler(handler);
            reader.parse(new StringReader(xml));
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

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
        System.out.println("Start of " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length).trim();
        if (!content.isEmpty()) {
            System.out.println("Content: " + content);
        }
    }
}