import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_04167_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();

            MyHandler myHandler = new MyHandler();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(myHandler);

            saxParser.parse(new File("sample.xml"), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements org.xml.sax.ContentHandler {
    private boolean bName = false;
    private boolean bValue = false;
    private String currentValue = null;

    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        if (qName.equals("element")) {
            bName = true;
            bValue = false;
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("element")) {
            bName = false;
            bValue = false;
       
            System.out.println("Element name: " + currentValue);
            System.out.println("Element value: " + currentValue);
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            currentValue = new String(ch, start, length);
        }
    }
}