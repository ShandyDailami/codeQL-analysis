import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParser;
import org.xml.sax.SAXParserFactory;

import java.io.File;
import java.io.IOException;

public class java_12814_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "example.xml";

        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(false);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File(xmlFile), myHandler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private String lastElement;
        private String lastNamespace;

        @Override
        public void startElement(String namespaceURI, String localName, String qualifiedName, Attributes attributes) throws SAXException {
            if (namespaceURI != null && localName != null) {
                lastElement = localName;
                lastNamespace = namespaceURI;
            }
        }

        @Override
        public void endElement(String namespaceURI, String localName, String qualifiedName) throws SAXException {
            if (localName.equals(lastElement) && qualifiedName.equals("username")) {
                // Do not inject the username into the XML
                System.out.println("Injection attack detected: " + qualifiedName);
            }
            lastElement = null;
            lastNamespace = null;
        }
    }
}