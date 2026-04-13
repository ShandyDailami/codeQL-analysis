import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXSource;
import org.xml.sax.XMLReader;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_09726_XMLParser_A08 {

    public static void main(String[] args) {
        File xmlFile = new File("example.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(new Properties());
            MyHandler myHandler = new MyHandler();

            SAXSource saxSource = new SAXSource(new FileReader(xmlFile));
            saxParser.parse(saxSource, myHandler);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        boolean bElement = false;
        String thisElement = "";

        @Override
        public void startElement(String uri, String localName, String qName,
                                 org.xml.sax.Attributes attributes) throws SAXException {
            bElement = true;
            thisElement = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            bElement = false;
            if (bElement) {
                System.out.println(thisElement + ": " + "Attributes: " + attributes.getLength());
            }
            thisElement = "";
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bElement) {
                System.out.print(thisElement + ": " + new String(ch, start, length));
            }
        }
    }
}