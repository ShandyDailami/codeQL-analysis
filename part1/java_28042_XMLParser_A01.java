import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXReader;
import java.io.File;
import java.io.IOException;

public class java_28042_XMLParser_A01 extends DefaultHandler {

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName)
            throws SAXException {
        System.out.println("Start of element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        System.out.println("End of element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        System.out.println("Text: " + new String(ch, start, length));
    }

    @Override
    public void fatalError(String error) throws SAXException {
        System.out.println("Fatal Error: " + error);
    }
}

public class MySAXParser {

    public static void main(String[] args) {
        SAXReader reader = new SAXReader();
        File xmlFile = new File("sample.xml");
        try {
            XMLReader xmlReader = reader.getReader();
            xmlReader.setContentHandler(new MyHandler());
            xmlReader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}