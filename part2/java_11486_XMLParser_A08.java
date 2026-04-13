import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXHelper;
import org.xml.sax.XMLReader;
import org.xml.sax.XMLReaderFactory;

public class java_11486_XMLParser_A08 extends DefaultHandler {

    public static void main(String[] args) {
        SAXHelper saxHelper = new SAXHelper();
        XMLReader xmlReader = null;
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(new XmlParser());
            xmlReader.parse("books.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        } finally {
            if (xmlReader != null) {
                try {
                    xmlReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of XML document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of XML document");
    }

    @Override
    public void startElement(String uri, String localName, String qName,
            org.xml.sax.Attributes attributes) throws SAXException {
        System.out.print("Start element: " + qName);
        printAttributes(attributes);
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        System.out.println("End element: " + qName);
    }

    private void printAttributes(org.xml.sax.Attributes attributes) {
        System.out.println("Attributes:");
        Iterator iterator = attributes.getIterator();
        while (iterator.hasNext()) {
            org.xml.sax.Attributes attr = (org.xml.sax.Attributes) iterator.next();
            System.out.println("  Name: " + attr.getValue("name"));
            System.out.println("  Value: " + attr.getValue("value"));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    @Override
    public void warning(SAXException e) throws SAXException {
        e.printStackTrace();
    }

    @Override
    public void error(SAXException e) throws SAXException {
        e.printStackTrace();
    }

    @Override
    public void fatalError(SAXException e) throws SAXException {
        e.printStackTrace();
    }

}