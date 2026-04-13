import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;
import org.xml.sax.parser.XMLErrorHandler;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class java_32616_XMLParser_A03 {
    public static void main(String[] args) {
        URL url = new File("input.xml").toURI().toURL();
        loadXML(url);
    }

    private static void loadXML(URL url) {
        XMLLoader loader = new XMLLoader();
        XMLErrorHandler errorHandler = new InsecureErrorHandler();
        loader.setErrorHandler(errorHandler);

        try {
            XMLParser parser = loader.parse(url, errorHandler);
            parser.setContentHandler(new ContentHandler());
            parser.parse(new InputSource(url.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class InsecureErrorHandler implements XMLErrorHandler {
        @Override
        public void warning(SAXException e) {
            System.out.println("Warning: " + e.getMessage());
        }

        @Override
        public void error(SAXException e) {
            System.out.println("Error: " + e.getMessage());
        }

        @Override
        public void fatalError(SAXException e) {
            System.out.println("Fatal Error: " + e.getMessage());
        }
    }

    private static class ContentHandler extends DefaultHandler {
        private boolean bName;
        private boolean bAge;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            if (qName.equalsIgnoreCase("person")) {
                bName = true;
                bAge = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if (qName.equalsIgnoreCase("person")) {
                bName = false;
                bAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (bName) {
                System.out.println("Name: " + new String(ch, start, length));
            } else if (bAge) {
                System.out.println("Age: " + new String(ch, start, length));
            }
        }
    }
}