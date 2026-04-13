import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_09996_XMLParser_A07 extends DefaultHandler {

    private boolean bElement = false;
    private boolean bAttr = false;
    private String currentElement = null;
    private String currentAttr = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        currentElement = qName;
        bElement = true;
        bAttr = false;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        bElement = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bElement) {
            System.out.println("Element: " + currentElement + ", Text: " + new String(ch, start, length));
        } else if (bAttr) {
            System.out.println("Attribute: " + currentAttr + ", Text: " + new String(ch, start, length));
        }
    }

    @Override
    public void startAttribute(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        currentAttr = qName;
        bAttr = true;
        bElement = false;
    }

    @Override
    public void endAttribute(String uri, String localName, String qName) throws SAXException {
        bAttr = false;
    }

    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new MyXMLHandler());
            reader.parse("test.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}