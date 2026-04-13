import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLValidator;
import org.xml.sax.SAXParseException;

public class java_07965_XMLParser_A03 {

    public static void main(String[] args) {
        String inputFile = "sample.xml";
        parseFile(inputFile);
    }

    public static void parseFile(String inputFile) {
        DefaultHandler handler = new DefaultHandler() {
            boolean bName = false;
            boolean bAge = false;

            @Override
            public void startDocument() throws SAXException {
                System.out.println("Start Document");
            }

            @Override
            public void endDocument() throws SAXException {
                System.out.println("End Document");
            }

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                if (qName.equals("name")) {
                    bName = true;
                } else if (qName.equals("age")) {
                    bAge = true;
                }
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                if (qName.equals("name")) {
                    bName = false;
                } else if (qName.equals("age")) {
                    bAge = false;
                }
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                if (bName) {
                    System.out.println("Name: " + new String(ch, start, length));
                    bName = false;
                } else if (bAge) {
                    System.out.println("Age: " + new String(ch, start, length));
                    bAge = false;
                }
            }
        };

        try {
            XMLParser parser = XMLReader.getDefaultInstance().getSAXParser();
            parser.setDenotedElementLocation(XMLParser.ELEMENT_NODE);
            parser.parse(new FileInputStream(inputFile), handler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXParseException e) {
            e.printStackTrace();
        }
    }
}