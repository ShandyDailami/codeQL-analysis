import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_41160_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();
        MyHandler mh = new MyHandler();
        XMLReader xr = XMLReaderFactory.createXMLReader();

        xr.setContentHandler(mh);
        try {
            xr.parse(new File("src/sample.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    boolean bTag = false;
    String strData = null;

    @Override
    public void startElement(String uri, String localName, String qName,
                             javax.xml.parsers.SAXEvent event) throws SAXException {
        bTag = true;
        strData = "";
    }

    @Override
    public void endElement(String uri, String localName, String qName,
                           javax.xml.parsers.SAXEvent event) throws SAXException {
        bTag = false;

        if (bTag) {
            // Perform security-sensitive operations related to A08_IntegrityFailure here
            System.out.println("Security-sensitive operation: " + strData);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length, javax.xml.parsers.SAXEvent event) throws SAXException {
        if (bTag) {
            strData = new String(ch, start, length);
        }
    }
}