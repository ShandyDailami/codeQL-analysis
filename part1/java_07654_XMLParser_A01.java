import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class java_07654_XMLParser_A01 extends DefaultHandler {
    private String lastElement;
    private static final String rootElement = "root";

    public java_07654_XMLParser_A01() {
        super();
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("Start of Element: " + qName);
        lastElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of Element: " + qName);
        lastElement = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (lastElement != null && lastElement.equals(rootElement)) {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(new XMLParser());
        try {
            reader.parse("sample.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}