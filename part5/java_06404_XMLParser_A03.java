import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_06404_XMLParser_A03 {

    public static void main(String[] args) {
        File xmlFile = new File("example.xml");
        parseFile(xmlFile);
    }

    private static void parseFile(File xmlFile) {
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setValidation(true);
            reader.setEntityResolver(new MyEntityResolver());
            reader.setFeature("http://xml.org/sax/features/namespaces", true);
            reader.setFeature("http://xml.org/sax/features/namespaces", false);
            reader.setFeature("http://xml.org/sax/features/external-general-entities", false);
            reader.setFeature("http://xml.org/sax/features/external-dtd", false);
            SAXHandler handler = new SAXHandler();
            reader.setContentHandler(handler);
            reader.parse(xmlFile.toURI().toString());
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class MyEntityResolver implements javax.xml.parsers.EntityResolver {
        public java.security.ProtectionDomain getProtectionDomain() {
            return null;
        }

        public InputSource resolveEntity(String arg0) throws SAXException {
            return null;
        }
    }

    private static class SAXHandler implements org.xml.sax.helpers.DefaultHandler {
        public void startDocument() throws SAXException {
            System.out.println("Start of Document");
        }

        public void endDocument() throws SAXException {
            System.out.println("End of Document");
        }

        public void startElement(String arg0, String arg1, String arg2, org.xml.sax.Attributes arg3) throws SAXException {
            System.out.println("Start of Element: " + arg1);
        }

        public void endElement(String arg0, String arg1, String arg2) throws SAXException {
            System.out.println("End of Element: " + arg1);
        }

        public void characters(char[] arg0, int arg1, int arg2) throws SAXException {
            System.out.println("Characters: " + new String(arg0, arg1, arg2));
        }
    }
}