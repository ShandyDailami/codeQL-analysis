import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class java_17447_XMLParser_A01 extends DefaultHandler {

    public static void main(String[] args) {
        File file = new File("sample.xml");
        if (!file.exists()) {
            System.out.println("File does not exist!");
            return;
        }

        SAXParserFactory spf = SAXParserFactory.newInstance();

        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            public Void run() {
                SAXParser saxParser = spf.newSAXParser(new XMLReader(new SecureXMLParser()));
                try {
                    saxParser.parse(new FileInputStream(file), SecureXMLParser.this);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SAXException e) {
                    e.printStackTrace();
                } catch (SAXParseException e) {
                    e.printStackTrace();
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });
    }

    @Override
    public void startElement(String uri, String localName, String qName,
            org.xml.sax.Attributes attributes) throws SAXException {
        // This method is intentionally left blank.
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        // This method is intentionally left blank.
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        // This method is intentionally left blank.
    }

    @Override
    public void error(SAXParseException e) {
        System.out.println("SAXParseException: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXParseException e) {
        System.out.println("Fatal SAXParseException: " + e.getMessage());
    }

    @Override
    public void warning(SAXParseException e) {
        System.out.println("Warning: " + e.getMessage());
    }
}