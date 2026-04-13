import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXParserFactory;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_20791_XMLParser_A08 extends DefaultHandler {

    private boolean isInElement;

    public java_20791_XMLParser_A08() {
        super();
    }

    public void parse(String fileName) {
        File xmlFile = new File(fileName);
        XMLReader reader;
        try {
            SAXParserFactory saxFactory = SAXParserFactory.newInstance();
            reader = saxFactory.newSAXReader();

            reader.setContentHandler(this);
            reader.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        isInElement = true;
        System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        isInElement = false;
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (isInElement) {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }
}