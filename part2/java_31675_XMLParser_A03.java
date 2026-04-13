import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class java_31675_XMLParser_A03 {

    public static void main(String[] args) {
        // create a SAXParserFactory
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        // create a SAXParser
        SAXParser saxParser = saxParserFactory.newSAXParser();

        // create an XMLReader
        XMLReader xmlReader = XMLReaderFactory.createXMLReader();

        // create a customHandler
        MyHandler myHandler = new MyHandler();

        // set the Handler for the XMLReader
        xmlReader.setContentHandler(myHandler);

        // parse the XML file
        try {
            saxParser.parse(XmlParser.class.getResourceAsStream("/sample.xml"), true);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }

        // print the result
        System.out.println("Total Injection: " + myHandler.getTotalInjection());
        System.out.println("Total XSS: " + myHandler.getTotalXSS());
        System.out.println("Total SQL: " + myHandler.getTotalSQL());
        System.out.println("Total NoSQL: " + myHandler.getTotalNoSQL());
    }
}

class MyHandler implements org.xml.sax.helpers.DefaultHandler {

    private int totalInjection = 0;
    private int totalXSS = 0;
    private int totalSQL = 0;
    private int totalNoSQL = 0;

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        if (localName.equalsIgnoreCase("injection")) {
            totalInjection++;
        } else if (localName.equalsIgnoreCase("xss")) {
            totalXSS++;
        } else if (localName.equalsIgnoreCase("sql")) {
            totalSQL++;
        } else if (localName.equalsIgnoreCase("nosql")) {
            totalNoSQL++;
        }
    }

    public int getTotalInjection() {
        return totalInjection;
    }

    public int getTotalXSS() {
        return totalXSS;
    }

    public int getTotalSQL() {
        return totalSQL;
    }

    public int getTotalNoSQL() {
        return totalNoSQL;
    }
}