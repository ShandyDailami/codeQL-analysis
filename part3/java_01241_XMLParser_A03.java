import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_01241_XMLParser_A03 extends DefaultHandler {

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of XML Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of XML Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start of Element : " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of Element : " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Text : " + new String(ch, start, length));
    }

    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml");
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(true);

            MyXMLHandler myXMLHandler = new MyXMLHandler();
            XMLReader xmlReader = saxParser.getXMLReader(new org.xml.sax.helpers.DefaultHandler() {
                @Override
                public void startDocument() throws SAXException {
                    System.out.println("Start of XML Document");
                }

                @Override
                public void endDocument() throws SAXException {
                    System.out.println("End of XML Document");
                }

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    System.out.println("Start of Element : " + qName);
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("End of Element : " + qName);
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    System.out.println("Text : " + new String(ch, start, length));
                }
            });

            xmlReader.setContentHandler(myXMLHandler);
            xmlReader.parse(xmlFile);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}