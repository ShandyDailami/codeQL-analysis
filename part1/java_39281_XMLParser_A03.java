import java.io.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import org.xml.sax.*;

public class java_39281_XMLParser_A03 {
    public static void main(String[] args) {
        String fileName = "src/main/resources/example.xml";
        parseXMLFile(fileName);
    }

    public static void parseXMLFile(String fileName) {
        try {
            File inputFile = new File(fileName);
            XMLReader reader = XMLReaderFactory.createXMLReader();
            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser(new InputSource(new FileInputStream(inputFile)));

            SAXHandler saxHandler = new SAXHandler();
            saxParser.setContentHandler(saxHandler);
            saxParser.parse(new InputSource(new File(fileName)));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler extends DefaultHandler {
    private boolean bName;
    private boolean bAge;
    private String tempValue;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            bName = false;
            bAge = false;
        } else if (qName.equalsIgnoreCase("name")) {
            bName = true;
        } else if (qName.equalsIgnoreCase("age")) {
            bAge = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            tempValue = new String(ch, start, length);
        } else if (bAge) {
            tempValue = new String(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            System.out.println("Name: " + tempValue);
            System.out.println("Age: " + tempValue);
        }
    }
}