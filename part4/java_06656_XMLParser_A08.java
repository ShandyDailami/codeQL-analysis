import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_06656_XMLParser_A08 {
    public static void main(String[] args) {
        String xml = "<root><element>Content1</element><element>Content2</element></root>";
        parseXml(xml);
    }

    public static void parseXml(String xml) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new XmlHandler());
            parser.parse(new StringReader(xml), new XmlHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class XmlHandler extends DefaultHandler {
    private boolean element = false;
    private String elementContent = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("element")) {
            element = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (element) {
            elementContent = new String(ch, start, length);
            element = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("element")) {
            System.out.println("Element content: " + elementContent);
        }
    }
}