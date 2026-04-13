import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.EntityResolver;
import org.xml.sax.ext.LxmlEntityResolver;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_03178_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser(new EntityResolver() {
                @Override
                public InputSource resolveEntity(String arg0) throws SAXException {
                    return new InputSource(new StringReader(arg0));
                }
            });

            XMLReader xr = XMLReaderFactory.createXMLReader();
            MyHandler mh = new MyHandler();
            sp.setContentHandler(mh);
            xr.setContentHandler(mh);

            File inputFile = new File("authfailure.xml");
            sp.parse(inputFile, xr);

            mh.printDetails();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {

    private boolean authFailure;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("authFailure")) {
            authFailure = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("authFailure")) {
            authFailure = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (authFailure) {
            System.out.println(new String(ch, start, length));
        }
    }

    public void printDetails() {
        if (authFailure) {
            System.out.println("AuthFailure found in XML file.");
        } else {
            System.out.println("AuthFailure not found in XML file.");
        }
    }
}