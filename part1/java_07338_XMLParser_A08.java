import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.File;
import java.io.IOException;

public class java_07338_XMLParser_A08 {

    public void parse(String fileName) {
        File file = new File(fileName);
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new MyContentHandler());
            reader.parse(file);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class MyContentHandler implements org.xml.sax.ContentHandler {

        @Override
        public void startDocument() {
            System.out.println("Start Document");
        }

        @Override
        public void endDocument() {
            System.out.println("End Document");
        }

        @Override
        public void startElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("Start Element: " + localName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End Element: " + localName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String data = new String(ch, start, length).trim();
            if (!data.isEmpty()) {
                System.out.println("Characters: " + data);
            }
        }

        @Override
        public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
            System.out.println("Ignorable Whitespace: " + new String(ch, start, length));
        }

        @Override
        public void processingInstruction(String target, String data) throws SAXException {
            System.out.println("Processing Instruction: " + target + ", " + data);
        }

        @Override
        public void setElementNamespace(String uri, String prefix) throws SAXException {
            System.out.println("Set Element Namespace: " + uri + ", " + prefix);
        }
    }
}