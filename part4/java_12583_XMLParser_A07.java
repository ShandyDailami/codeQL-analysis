import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_12583_XMLParser_A07 {

    private static class MyHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            // TODO: Implement your security-sensitive operations
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            // TODO: Implement your security-sensitive operations
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            // TODO: Implement your security-sensitive operations
            String str = new String(ch, start, length);
            System.out.println("Character data: " + str);
        }
    }

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(new InputSource(new FileInputStream(inputFile)));
            MyHandler myHandler = new MyHandler();
            XMLReader xmlReader = XMLReaderFactory.newInstance().createXMLReader(myHandler);
            xmlReader.setContentHandler(myHandler);
            saxParser.parse(inputFile, myHandler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXParseException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}