import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.File;
import java.io.IOException;

public class java_23029_XMLParser_A01 {

    public static void main(String[] args) {
        File xmlFile = new File("example.xml");
        XMLReader xmlReader = null;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(new XMLContentHandler());

            xmlReader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (xmlReader != null) {
                try {
                    xmlReader.close();
                } catch (SAXException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class XMLContentHandler implements org.xml.sax.ContentHandler {

    private boolean isPerson = false;
    private boolean isName = false;
    private boolean isAge = false;

    @Override
    public void startDocument() throws SAXException {
    }

    @Override
    public void endDocument() throws SAXException {
    }

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            isPerson = true;
        } else {
            if (isPerson) {
                if (qName.equalsIgnoreCase("name")) {
                    isName = true;
                } else if (qName.equalsIgnoreCase("age")) {
                    isAge = true;
                }
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            isPerson = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isPerson && isName) {
            System.out.println("Name: " + new String(ch, start, length));
            isName = false;
        } else if (isPerson && isAge) {
            System.out.println("Age: " + new String(ch, start, length));
            isAge = false;
        }
    }
}