import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_29022_XMLParser_A07 extends DefaultHandler {

    public static void main(String[] args) {
        String xmlFile = "sample.xml";
        parseFile(xmlFile);
    }

    private static void parseFile(String xmlFile) {
        try {
            File file = new File(xmlFile);
            XMLReader reader = XMLReaderFactory.createXMLReader();
            XMLParser handler = new XMLParser();
            reader.setContentHandler(handler);
            reader.parse(file);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Parsing XML document...");
    }

    @Override
    public void startElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("Start of element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of element: " + qName);
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Parsing completed...");
    }
}