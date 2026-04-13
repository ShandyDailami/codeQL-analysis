import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_07738_XMLParser_A08 extends DefaultHandler {

    public java_07738_XMLParser_A08() {
        super();
    }

    public void parse(String fileName) {
        try {
            File file = new File(fileName);
            SAXReader reader = SAXReaderFactory.newInstance();
            XMLReader xmlReader = reader.getXMLReader();
            xmlReader.setContentHandler(this);
            xmlReader.parse(file);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        System.out.println("Start Element: " + qName);

        // Print element attributes
        for (int i = 0; i < attributes.getLength(); i++) {
            System.out.println("Attribute " + i + ": " + attributes.getQName(i) + " = " + attributes.getValue(i));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }
}