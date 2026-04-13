import java.io.File;
import java.io.IOException;
import java.security.CodeSignature;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.ProtectionDomain;
import java.security.cert.Certificate;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_13772_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null);

            // Create an instance of the handler
            MyHandler handler = new MyHandler();

            // Parse the XML file
            parser.parse("src/main/resources/sample.xml", handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Define the handler
    static class MyHandler extends DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                        throws SAXException {
            if (qName.equals("name")) {
                System.out.println("Name: " + attributes.getValue("value"));
            }
        }
    }
}