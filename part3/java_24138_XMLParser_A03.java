import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_24138_XMLParser_A03 {
    private static final String SHA256 = "SHA-256";
    private static final String FILE = "input.xml";

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null);

            InputStream in = new FileInputStream(new File(FILE));
            parser.setContentHandler(new ContentHandler());
            parser.parse(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class ContentHandler extends DefaultHandler {
        private StringBuffer buffer = new StringBuffer();
        private String encoding = "UTF-8";
        private int depth = 0;

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of the document.");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of the document.");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            depth++;
            printIndentation();
            System.out.println("Start element " + qName + ", deep: " + depth);
            buffer.append(qName);
            printAttributes(attributes);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            depth--;
            printIndentation();
            System.out.println("End element " + qName + ", deep: " + depth);
            buffer.append(qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            printIndentation();
            System.out.print("Characters: ");
            buffer.append(ch, start, length);
        }

        private void printIndentation() {
            for (int i = 0; i < depth; i++) {
                System.out.print("  ");
            }
        }

        private void printAttributes(Attributes attributes) {
            System.out.print("Attributes: ");
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.print(attributes.getQName(i) + "=" + attributes.getValue(i));
                if (i < attributes.getLength() - 1) {
                    System.out.print(", ");
                }
            }
        }
    }
}