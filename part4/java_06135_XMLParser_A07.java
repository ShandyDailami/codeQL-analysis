import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.xmlreader.XMLReader;
import org.xml.sax.xmlreader.XMLResourceLoader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_06135_XMLParser_A07 {
    public static void main(String[] args) {
        String xmlFile = "example.xml";  // replace with your xml file
        parseXmlFile(xmlFile);
    }

    public static void parseXmlFile(String file) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(new XMLResourceLoader(new File(file)));

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File(file), myHandler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bElementName = false;
        boolean bElementValue = false;
        String elementValue = null;

        @Override
        public void startElement(String uri, String localName, String qName,
                                 org.xml.sax.Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("element")) {
                bElementName = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bElementName) {
                bElementName = false;
                String elementName = new String(ch, start, length);
                System.out.println("Element Name: " + elementName);
            } else if (bElementValue) {
                bElementValue = false;
                elementValue = new String(ch, start, length);
                System.out.println("Element Value: " + elementValue);
            }
        }
    }
}