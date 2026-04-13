import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_32088_XMLParser_A03 {
    public static void main(String[] args) {
        File xmlFile = new File("your_xml_file.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        try {
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            MySAXHandler mySAXHandler = new MySAXHandler();

            saxParser.parse(xmlFile, mySAXHandler);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

class MySAXHandler implements SAXHandler {
    private int counter;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        counter++;
        System.out.println("Element: " + qName + ", Attributes: " + attributes.getLength());
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        // do nothing, just for demonstration
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        // do nothing, just for demonstration
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getCounter() {
        return counter;
    }
}