import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_20935_XMLParser_A03 {
    public static void main(String[] args) {
        // create an instance of SAXParserFactory
        SAXParserFactory spf = SAXParserFactory.newInstance();

        // create an instance of SAXParser
        SAXParser sp = spf.newSAXParser(true);

        // create an instance of DefaultHandler
        DefaultHandler dh = new DefaultHandler();

        try {
            // create an instance of XMLReader
            XMLReader xr = XMLReaderFactory.createXMLReader(new MyXMLHandler(dh));

            // parse the xml file
            sp.parse(new File("sample.xml"), xr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyXMLHandler extends DefaultHandler {
    private boolean bName;
    private boolean bAge;

    public java_20935_XMLParser_A03(DefaultHandler defaultHandler) {
        super(defaultHandler);
        bName = false;
        bAge = false;
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            bName = true;
            bAge = true;
        } else if (bName && qName.equalsIgnoreCase("name")) {
            // print name
            System.out.println("Name: " + attributes.getValue(""));
        } else if (bName && qName.equalsIgnoreCase("age")) {
            // print age
            System.out.println("Age: " + attributes.getValue(""));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            bName = false;
            bAge = false;
        }
    }
}