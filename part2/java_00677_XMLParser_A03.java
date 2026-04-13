import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_00677_XMLParser_A03 extends DefaultHandler {

    public java_00677_XMLParser_A03() {
        super();
    }

    public void parse(String fileName) {
        try {
            File xmlFile = new File(fileName);
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(this);
            reader.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length);
        System.out.println("Character data: " + content);
    }

    @Override
    public void fatalError(String error) throws SAXException {
        System.out.println("Fatal error: " + error);
    }

    public static void main(String[] args) {
        new XMLParser().parse("sample.xml");
    }
}