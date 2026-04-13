import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_12481_XMLParser_A08 {

    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        File outputFile = new File("output.txt");
        
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            SAXHandler saxHandler = new SAXHandler();
            saxParser.parse(inputFile, saxHandler);

            // Write data to the output file
            // ...

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class SAXHandler extends DefaultHandler {

        boolean bName = false;
        boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {

            if (qName.equalsIgnoreCase("employee")) {
                bName = true;
                bAge = true;
            } else if (bName && qName.equalsIgnoreCase("name")) {
                // write name to file
                // ...
                bName = false;
            } else if (bName && qName.equalsIgnoreCase("age")) {
                // write age to file
                // ...
                bAge = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("employee")) {
                bName = false;
                bAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                // write name to file
                // ...
            } else if (bAge) {
                // write age to file
                // ...
            }
        }
    }
}