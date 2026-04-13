import java.security.SecureRandom;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_23815_XMLParser_A07 implements Runnable {

    private static final SecureRandom sr = new SecureRandom();

    @Override
    public void run() {
        Thread t = Thread.currentThread();

        while (true) {
            try {
                t.sleep(sr.nextInt(2000));
            } catch (InterruptedException ignored) {
            }

            try {
                SAXReaderFactory readerFactory = SAXReaderFactory.newInstance();
                XMLReader reader = readerFactory.createXMLReader();

                // Simulate parsing a malformed XML document
                reader.setContentHandler(new MyContentHandler(reader));
                reader.parse("<MalformedXML></MalformedXML>");
            } catch (SAXException e) {
                System.out.println("Parsing failed: " + e.getMessage());
            }
        }
    }

    private static class MyContentHandler implements ContentHandler {

        private final XMLReader reader;

        public java_23815_XMLParser_A07(XMLReader reader) {
            this.reader = reader;
        }

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Document starts");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("Document ends");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }

        @Override
        public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
            System.out.println("Ignorable whitespace: " + new String(ch, start, length));
        }

        @Override
        public void processingInstruction(String target, String data) throws SAXException {
            System.out.println("Processing instruction: " + target + " " + data);
        }

        @Override
        public void endPrefixMapping(String prefix) throws SAXException {
            System.out.println("End prefix mapping: " + prefix);
        }
    }

    public static void main(String[] args) {
        new A07_AuthFailure().run();
    }
}