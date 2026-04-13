import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_20861_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("example.xml");
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(new DefaultHandler());
            MyXMLParserHandler handler = new MyXMLParserHandler();
            xmlReader.setContentHandler(handler);
            xmlReader.parse(xmlFile);
            System.out.println(handler.getResult());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyXMLParserHandler extends DefaultHandler {
    private StringBuilder result;

    public java_20861_XMLParser_A03() {
        this.result = new StringBuilder();
    }

    @Override
    public void startDocument() throws SAXException {
        this.result.setLength(0);
    }

    @Override
    public void startElement(String uri, String localName, String qName) throws SAXException {
        // Security-sensitive operations here, e.g., prevent XML External Entity (XXE) attacks
        // You can use a library like DOM-based security here, for instance using an XPath expression.
        // If the XML contains a suspicious entity, you can reject it.
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        result.append(new String(ch, start, length));
    }

    public String getResult() {
        return result.toString();
    }
}