import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXHelper;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class java_18112_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            SAXReader reader = new SAXReader();
            SAXHandler handler = new SAXHandler();
            XMLReader xmlReader = reader.getXMLReader();
            xmlReader.setContentHandler(handler);
            xmlReader.parse("sample.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler extends DefaultHandler {
    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes)
            throws SAXException {
        System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }
}