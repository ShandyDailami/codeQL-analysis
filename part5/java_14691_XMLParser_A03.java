import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_14691_XMLParser_A03 {

    public static void main(String[] args) {
        String inputFile = "input.xml";
        String outputFile = "output.txt";
        File input = new File(inputFile);
        File output = new File(outputFile);

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();

            MyHandler handler = new MyHandler();
            parser.parse(input, handler);

            // Now, we can use the output.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {

        private boolean bName;
        private boolean bAge;
        private String tempValue;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                bName = true;
                bAge = true;
            } else if (bName && qName.equalsIgnoreCase("name")) {
                bName = false;
            } else if (bName && qName.equalsIgnoreCase("age")) {
                bAge = false;
            } else if (bAge && qName.equalsIgnoreCase("age")) {
                bAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                tempValue = new String(ch, start, length);
            } else if (bAge) {
                tempValue += new String(ch, start, length);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                // Process the person
                System.out.println("Name: " + tempValue);
                System.out.println("Age: " + tempValue);
            }
        }
    }
}