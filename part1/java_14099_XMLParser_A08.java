import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_14099_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("sample.xml");
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            fis.getChannel().transform(md);
            byte[] digest = md.digest();

            // Printing SHA-256 Hash
            for (byte b : digest) {
                System.out.format("%02x", b);
            }
            System.out.println();

        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void parseXML(String fileName) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setEntityResolver(new MyEntityResolver());
            reader.setContentHandler(new MyContentHandler());
            reader.parse(new File(fileName));
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyEntityResolver extends DefaultHandler {
        @Override
        public InputSource resolveEntity(String publicId, String systemId)
            throws SAXException, IOException {
            return new InputSource(new StringReader(
                "<root>This is a test</root>"));
        }
    }

    static class MyContentHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String name,
            String qName, Attributes attributes) throws SAXException {
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String name)
            throws SAXException {
            System.out.println("End element: " + name);
        }

        @Override
        public void characters(char[] ch, int start, int length)
            throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }
}