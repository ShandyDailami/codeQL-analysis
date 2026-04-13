import java.io.File;
import java.io.IOException;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.Parser;
import org.xml.sax.parser.SAXParserFactory;

public class java_39865_XMLParser_A03 {

    private static class MyHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            System.out.println("Start element: " + qName);
            // Put your code here to handle start element
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End element: " + qName);
            // Put your code here to handle end element
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
            // Put your code here to handle characters
        }
    }

    public static void parse(String fileName) {
        File xmlFile = new File(fileName);
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            Parser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(xmlFile, MyHandler.class);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        parse("sample.xml");
    }
}