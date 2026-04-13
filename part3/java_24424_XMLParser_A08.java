import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_24424_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create SAXParser
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();

            // Create XMLReader
            InputStream inputStream = new FileInputStream("sample.xml");

            // Parse XML
            saxParser.parse(inputStream, new XMLHandler());

            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class XMLHandler implements javax.xml.parsers.SAXHandler {
    @Override
    public void startElement(String uri, String localName, String qName, javax.xml.parsers.Attributes attributes) {
        System.out.println("Start Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.println("End Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        System.out.println("Characters: " + new String(ch, start, length));
    }
}