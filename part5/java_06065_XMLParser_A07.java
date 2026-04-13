import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;
import org.xml.sax.parser.XMLErrorHandler;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class java_06065_XMLParser_A07 {
    private static class MyHandler extends DefaultHandler {
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            System.out.println("Start element: " + localName);
        }

        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            System.out.println("End element: " + localName);
        }

        public void characters(char[] ch, int start, int length)
                throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        String urlStr = "http://www.w3schools.com/xml/books.xml";
        try {
            URL url = new URL(urlStr);
            XMLLoader loader = new XMLLoader();
            loader.setErrorHandler(new XMLErrorHandler() {
                public void fatalError(URL url, SAXException e) {
                    System.out.println("Fatal Error: " + e.getMessage());
                }

                public void warning(URL url, SAXWarning e) {
                    System.out.println("Warning: " + e.getMessage());
                }

                public void characters(char[] ch, int start, int length) {
                    System.out.println("Characters: " + new String(ch, start, length));
                }
            });
            XMLParser parser = loader.getParser();
            parser.setContentHandler(new MyHandler());
            parser.parse(new File(url.getFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}