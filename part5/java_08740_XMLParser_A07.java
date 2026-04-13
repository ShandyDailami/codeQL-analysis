import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_08740_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            String filePath = "your_file_path.xml";  // replace with your xml file path
            parseXML(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseXML(String filePath) throws Exception {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(null);

        InputStream inputStream = new FileInputStream(new File(filePath));

        DefaultHandler handler = new DefaultHandler() {
            boolean bName = false;
            boolean bAge = false;

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                if (qName.equalsIgnoreCase("name")) {
                    bName = true;
                } else if (qName.equalsIgnoreCase("age")) {
                    bAge = true;
                }
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                if (qName.equalsIgnoreCase("name")) {
                    bName = false;
                } else if (qName.equalsIgnoreCase("age")) {
                    bAge = false;
                }
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                if (bName) {
                    System.out.println("Name: " + new String(ch, start, length));
                } else if (bAge) {
                    System.out.println("Age: " + new String(ch, start, length));
                }
            }
        };

        saxParser.parse(inputStream, handler);
    }
}