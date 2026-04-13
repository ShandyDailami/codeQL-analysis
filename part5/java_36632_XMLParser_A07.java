import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_36632_XMLParser_A07 {

    public static void main(String[] args) {
        String xmlFile = "src/main/resources/authFailures.xml";  // your xml file
        File inputFile = new File(xmlFile);

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            MyHandler myHandler = new MyHandler();
            saxParser.setContentHandler(myHandler);

            saxParser.parse(inputFile, xmlReader);

            System.out.println("Number of auth failures: " + myHandler.getAuthFailuresCount());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements org.xml.sax.helpers.DefaultHandler {
    private int authFailuresCount = 0;

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        // check for auth failure tag
        if ("authFailure".equals(localName)) {
            authFailuresCount++;
        }
    }

    public int getAuthFailuresCount() {
        return authFailuresCount;
    }
}