import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_01335_XMLParser_A03 {
    public static void main(String[] args) {
        File xmlFile = new File("example.xml");

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try (SAXParser saxParser = saxParserFactory.newSAXParser(xmlFile.toURI().toURL())) {
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            MyHandler myHandler = new MyHandler();
            xmlReader.setContentHandler(myHandler);

            saxParser.parse(xmlFile, xmlReader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements org.xml.sax.helpers.DefaultHandler {
    private boolean bName;
    private boolean bAge;

    public java_01335_XMLParser_A03() {
        bName = false;
        bAge = false;
    }

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            return;
        }

        if (qName.equalsIgnoreCase("name")) {
            bName = true;
            return;
        }

        if (qName.equalsIgnoreCase("age")) {
            bAge = true;
            return;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            return;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            System.out.println("Name: " + new String(ch, start, length));
            bName = false;
        }

        if (bAge) {
            System.out.println("Age: " + new String(ch, start, length));
            bAge = false;
        }
    }
}