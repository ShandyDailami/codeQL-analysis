import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_39093_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new MyHandler());

        try {
            File inputFile = new File("input.xml");
            parser.parse(inputFile, new SAXHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private StringBuffer buffer = new StringBuffer();
        private String elementName;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            elementName = qName;
            buffer.setLength(0);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if (elementName != null && elementName.equals(qName)) {
                // do something with the parsed data
                System.out.println("Parsed element: " + buffer.toString());
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            buffer.append(ch, start, length);
        }
    }

    static class SAXHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            // Security-sensitive operations here
            // ...

            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            // Security-sensitive operations here
            // ...

            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            // Security-sensitive operations here
            // ...

            System.out.println("Characters: " + new String(ch, start, length));
        }
    }
}