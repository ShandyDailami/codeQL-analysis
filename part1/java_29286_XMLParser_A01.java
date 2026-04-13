import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXReader;
import java.io.File;
import java.io.IOException;

public class java_29286_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            SAXReader reader = new SAXReader();
            XMLHandler handler = new XMLHandler();
            XMLReader xmlReader = reader.getReader(handler);
            xmlReader.parse(new File("example.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class XMLHandler extends DefaultHandler {

    boolean isElement = false;
    StringBuilder elementContent = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        isElement = true;
        elementContent.setLength(0);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isElement) {
            elementContent.append(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (isElement) {
            System.out.println(qName + ": " + elementContent.toString());
            isElement = false;
        }
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        // Ignore
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
        // Ignore
    }
}