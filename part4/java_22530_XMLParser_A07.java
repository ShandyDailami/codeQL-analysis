import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_22530_XMLParser_A07 {

    private static class MyHandler extends DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {

            // A07_AuthFailure is a security sensitive operation.
            // This is a placeholder for a real security-sensitive operation.
            // Replace this with your actual security-sensitive operation.
            System.out.println("Start of " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {

            // A07_AuthFailure is a security sensitive operation.
            // This is a placeholder for a real security-sensitive operation.
            // Replace this with your actual security-sensitive operation.
            System.out.println("End of " + qName);
        }
    }

    public static void main(String[] args) {

        File inputFile = new File("input.xml");
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = parserFactory.newSAXParser(null, new MyHandler());
            parser.parse(inputFile, MyHandler.class);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}