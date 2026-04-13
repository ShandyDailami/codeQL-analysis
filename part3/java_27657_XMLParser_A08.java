import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_27657_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            XMLParser parser = new XMLParser();
            parser.parse("example.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parse(String file) throws Exception {
        File xmlFile = new File(file);
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser(new InputSource(new FileInputStream(xmlFile)));

        MyHandler handler = new MyHandler();
        saxParser.parse(new InputSource(new File(file)), handler);
    }

    private class MyHandler extends DefaultHandler {
        private boolean elementName = false;
        private boolean elementValue = false;

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("element")) {
                elementName = true;
                elementValue = false;
            }
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            if (elementName) {
                elementName = false;
                System.out.println("Element Name: " + new String(ch, start, length));
            } else if (elementValue) {
                elementValue = false;
                System.out.println("Element Value: " + new String(ch, start, length));
            }
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("element")) {
                elementName = false;
                elementValue = false;
            }
        }
    }
}