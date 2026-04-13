import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_29000_XMLParser_A01 extends DefaultHandler {

    private String thisElement;
    private boolean bName;
    private boolean bAge;
    private boolean bCountry;

    public java_29000_XMLParser_A01() {
        this.bName = false;
        this.bAge = false;
        this.bCountry = false;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        this.thisElement = qName;
        if (qName.equals("person")) {
            bName = true;
            bAge = true;
            bCountry = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        thisElement = "";
        if (qName.equals("name")) bName = false;
        else if (qName.equals("age")) bAge = false;
        else if (qName.equals("country")) bCountry = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            // Do something with name
        } else if (bAge) {
            // Do something with age
        } else if (bCountry) {
            // Do something with country
        }
    }

    public static void main(String[] args) throws Exception {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        MySAXHandler mySAXHandler = new MySAXHandler();

        // Parse the xml file
        saxParser.parse(new File("src/data.xml"), mySAXHandler);
    }
}