import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.SAXEntries;
import org.xml.sax.helpers.DefaultHandler;

public class java_08179_XMLParser_A08 {

    private class MyHandler extends DefaultHandler {

        public void startDocument() {
            System.out.println("Start Document");
        }

        public void endDocument() {
            System.out.println("End Document");
        }

        public void startElement(String uri, String localName, String qName,
                                 Attributes attributes) {
            System.out.println("Start Element: " + qName);
        }

        public void endElement(String uri, String localName, String qName) {
            System.out.println("End Element: " + qName);
        }

        public void characters(char[] ch, int start, int length) {
            System.out.println("Characters: " + new String(ch, start, length));
        }

        public void ignorableWhitespace(char[] ch, int start, int length) {
            System.out.println("Ignorable Whitespace: " + new String(ch, start, length));
        }

        public void processingInstruction(String target, String data) {
            System.out.println("Processing Instruction: " + target + ", " + data);
        }

        public void comment(char[] ch, int start, int length) {
            System.out.println("Comment: " + new String(ch, start, length));
        }

        public void endPrefixMapping(String prefix) {
            System.out.println("End Prefix Mapping: " + prefix);
        }
    }

    public void parseXML(String fileName) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new MyHandler());
            reader.parse(fileName);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        XMLParser parser = new XMLParser();
        parser.parseXML("test.xml");
    }
}