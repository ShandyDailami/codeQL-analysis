import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.XMLReaderFactory;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_30915_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(new com.sun.org.apache.xerces.parsers.SAXParserImpl());

            MyHandler myHandler = new MyHandler();
            saxParser.setContentHandler(myHandler);

            XMLReader xmlReader = XMLReaderFactory.newInstance().createXMLReader();
            xmlReader.setContentHandler(myHandler);

            saxParser.parse("src/injection.xml", myHandler);
            xmlReader.parse("src/injection.xml", myHandler);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXParseException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bName = false;
        boolean bAge = false;

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                System.out.println("<" + qName + ">");
                bName = true;
                bAge = true;
            } else if (bName && qName.equalsIgnoreCase("name")) {
                System.out.println("  <" + qName + ">");
            } else if (bAge && qName.equalsIgnoreCase("age")) {
                System.out.println("  <" + qName + ">");
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                System.out.println("</" + qName + ">");
                bName = false;
                bAge = false;
            } else if (bName && qName.equalsIgnoreCase("name")) {
                System.out.println("  </" + qName + ">");
            } else if (bAge && qName.equalsIgnoreCase("age")) {
                System.out.println("  </" + qName + ">");
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                System.out.println("  <name>" + new String(ch, start, length) + "</name>");
            } else if (bAge) {
                System.out.println("  <age>" + new String(ch, start, length) + "</age>");
            }
        }
    }
}