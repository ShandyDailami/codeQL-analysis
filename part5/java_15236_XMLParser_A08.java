import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_15236_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            MyHandler myHandler = new MyHandler();
            xmlReader.setContentHandler(myHandler);

            saxParser.parse(new File("input.xml"), myHandler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements org.xml.sax.helpers.DefaultHandler {
    boolean errorFound = false;

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        if ("error".equals(qName)) {
            errorFound = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (errorFound) {
            throw new IllegalStateException("Encountered a 'error' element in security-sensitive operations");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Ignore characters
    }
}