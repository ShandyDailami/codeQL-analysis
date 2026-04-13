import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_08150_XMLParser_A08 {
    public static void main(String[] args) {
        File xmlFile = new File("example.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            MySAXHandler mySAXHandler = new MySAXHandler();

            saxParser.parse(xmlFile, mySAXHandler);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class MySAXHandler implements org.xml.sax.helpers.DefaultHandler {
    boolean bFirst = true;

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
        if (!bFirst) {
            System.out.println("Start of " + qName);
        } else {
            bFirst = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bFirst) {
            System.out.print("Characters: ");
            System.out.println(new String(ch, start, length));
        }
    }
}