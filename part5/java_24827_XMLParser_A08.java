import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLErrorHandler;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLErrorHandler;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_24827_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(new ErrorHandler());

            File inputFile = new File("input.xml");
            XMLReader xmlReader = saxParser.getXMLReader();
            xmlReader.setContentHandler(new ContentHandler());
            saxParser.parse(inputFile, ErrorHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class ContentHandler extends DefaultHandler {
        private String currentElement;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            currentElement = qName;
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            String elementContent = new String(ch, start, length).trim();
            if (!elementContent.isEmpty()) {
                System.out.println(currentElement + " : " + elementContent);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            currentElement = "";
        }
    }

    static class ErrorHandler implements XMLErrorHandler {
        public boolean fatalError(URL url, SAXException e) {
            return true;
        }

        public boolean error(URL url, SAXException e) {
            return true;
        }

        public void warning(URL url, SAXWarning e) {
        }
    }
}