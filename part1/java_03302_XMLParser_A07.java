import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_03302_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            File inputFile = new File("input.xml");

            FileInputStream fis = new FileInputStream(inputFile);

            parser.parse(fis, null);
            fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        boolean isAuthFailure = false;
        String currentElement = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentElement = qName;

            if (currentElement.equalsIgnoreCase("AuthFailure")) {
                isAuthFailure = true;
            }
        }

        @Override
        public java_03302_XMLParser_A07(String uri, String localName, String qName) throws SAXException {
            currentElement = null;

            if (currentElement != null && currentElement.equalsIgnoreCase("AuthFailure")) {
                isAuthFailure = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (currentElement != null && isAuthFailure) {
                String strChars = new String(ch, start, length);
                System.out.println("Security sensitive operation: " + strChars);
            }
        }
    }
}