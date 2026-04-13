import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_07797_XMLParser_A01 {
    public static void main(String[] args) {
        String xmlFile = "resources/books.xml";  // Change this to your XML file
        parseXml(xmlFile);
    }

    private static void parseXml(String xmlFile) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new XmlHandler());
            parser.parse(new File(xmlFile));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class XmlHandler extends DefaultHandler {
        private boolean isAuthor = false;
        private boolean isTitle = false;
        private boolean isPrice = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("author")) {
                isAuthor = true;
            } else if (qName.equalsIgnoreCase("title")) {
                isTitle = true;
            } else if (qName.equalsIgnoreCase("price")) {
                isPrice = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("author")) {
                isAuthor = false;
            } else if (qName.equalsIgnoreCase("title")) {
                isTitle = false;
            } else if (qName.equalsIgnoreCase("price")) {
                isPrice = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isAuthor) {
                System.out.println("Author: " + new String(ch, start, length));
            } else if (isTitle) {
                System.out.println("Title: " + new String(ch, start, length));
            } else if (isPrice) {
                System.out.println("Price: " + new String(ch, start, length));
            }
        }
    }
}