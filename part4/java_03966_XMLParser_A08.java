import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_03966_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();

            File xmlFile = new File("A08_IntegrityFailure.xml");
            SAXReaderHandler saxReaderHandler = new SAXReaderHandler();

            XMLReader xmlReader = saxParser.getXMLReader();
            xmlReader.setContentHandler(saxReaderHandler);

            saxReaderHandler.reset(); // reset the handler before reading the file again
            saxReaderHandler.startElement("", "root", "root");

            xmlReader.parse(xmlFile);

            System.out.println("Parsed successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SAXReaderHandler extends DefaultHandler {
    private boolean integrityFailure = false;
    private StringBuilder data;

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) {
        if (qName.equalsIgnoreCase("A08_IntegrityFailure")) {
            integrityFailure = true;
            data = new StringBuilder();
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) {
        if (qName.equalsIgnoreCase("A08_IntegrityFailure")) {
            integrityFailure = false;
        } else if (integrityFailure) {
            data.append(qName);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (integrityFailure) {
            data.append(new String(ch, start, length));
        }
    }

    public String getData() {
        return data.toString();
    }
}