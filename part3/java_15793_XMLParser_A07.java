import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_15793_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();
            MyHandler mh = new MyHandler();
            XMLReader xr = sp.getXMLReader();
            xr.setContentHandler(mh);
            xr.parse(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {

    boolean bElement = false;
    String sElement = "";
    
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        bElement = true;
        sElement = qName;
    }

    public void endElement(String uri, String localName, String qName)
        throws SAXException {
        bElement = false;
    }

    public void characters(char[] ch, int start, int length)
        throws SAXException {
        if (bElement) {
            sElement += new String(ch, start, length);
        }
    }
}