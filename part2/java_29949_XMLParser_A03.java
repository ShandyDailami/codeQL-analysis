import java.io.FileInputStream;
import java.io.InputStream;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_29949_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            String file = "src/main/resources/sample.xml"; // replace with your xml file
            InputStream input = new FileInputStream(file);
            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            MyContentHandler contentHandler = new MyContentHandler();
            saxParser.setContentHandler(contentHandler);
            xmlReader.setContentHandler(contentHandler);

            saxParser.parse(input, ContentHandler.NULL);
            xmlReader.parse(input, ContentHandler.NULL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyContentHandler implements ContentHandler {
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start of " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Character data: " + new String(ch, start, length));
    }
}