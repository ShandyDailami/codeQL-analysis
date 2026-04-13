import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.EntityResolver;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_22068_XMLParser_A07 extends DefaultHandler {
    
    public static void main(String[] args) {
        try {
            File inputFile = new File("sample.xml");
            SAXReader saxReader = new SAXReader();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(new MyXMLParser());
            EntityResolver resolver = new MyEntityResolver();
            saxReader.setEntityResolver(resolver);
            xmlReader.parse(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        // Handle element start events here.
        System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        // Handle element end events here.
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        // Handle character data here.
        System.out.println("Characters: " + new String(ch, start, length));
    }
}